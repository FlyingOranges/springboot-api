package com.vue.api.filter;

import com.vue.api.utils.JsonUtils;
import com.vue.api.utils.RedisUtils;
import com.vue.api.utilsPackages.ApiResponse;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFIlter implements Filter {

    private RedisUtils redisUtils;

    public LoginFIlter(RedisUtils redisUtils) {
        this.redisUtils = redisUtils;
    }

    //标示符：表示当前用户未登录
    private String NO_LOGIN = "没有您的登录信息,请登录后再进行操作";

    //标示符：表示当前请求未携带token
    private String NO_TOKEN = "参数(token)缺省";

    //不需要登录就可以访问的路径(比如:注册登录等)
    private String[] includeUrls = new String[]{"/login", "/register"};

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String uri = httpServletRequest.getRequestURI();

        //是否需要过滤
        boolean needFilter = isNeedFilter(uri);
        if (!needFilter) {
            //不需要过滤直接传给下一个过滤器
            filterChain.doFilter(servletRequest, servletResponse);
        } else {  //需要过滤的时候

            //设定输出的时候的格式(json)以及编码
            httpServletResponse.setCharacterEncoding("UTF-8");
            httpServletResponse.setContentType("application/json; charset=utf-8");

            //获取header中的token
            String token = httpServletRequest.getHeader("Accept-token");
            if (token == null || ("").equals(token)) {
                httpServletResponse.getWriter().write(this.reponseJson(this.NO_TOKEN, -903));
                return;
            }

            String data = redisUtils.getRedisString(token);
            if (data == null) {
                httpServletResponse.getWriter().write(this.reponseJson(this.NO_LOGIN, -904));
                return;
            }

            filterChain.doFilter(servletRequest, servletResponse);
        }

    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }

    /**
     * 是否需要过滤
     *
     * @param uri
     * @return
     */
    private boolean isNeedFilter(String uri) {

        for (String includeUrl : includeUrls) {
            if (includeUrl.equals(uri)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 返回数据设定到对象中
     *
     * @param message
     * @param code
     * @return
     * @throws IOException
     */
    private String reponseJson(String message, Integer code) throws IOException {

        ApiResponse apiResponse = new ApiResponse();

        apiResponse.setCode(code);
        apiResponse.setMessage(message);

        return JsonUtils.objToJson(apiResponse);
    }

}

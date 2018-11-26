package com.vue.api.configuration;

import com.vue.api.exception.AuthException;
import com.vue.api.filter.CorsFilter;
import com.vue.api.filter.LoginFIlter;
import com.vue.api.utils.RedisUtils;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean CorsFilterRegistration() {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter(new CorsFilter());
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        registration.setOrder(1);
        return registration;

    }

    /**
     * 注册登录过滤器
     * 由于过滤器启动的时候 RedisUtils类还没有被加载到Spring中,所有只能构造方案处理
     *
     * @param redisUtils
     * @return
     */
    @Bean
    public FilterRegistrationBean LoginFilterRegistration(RedisUtils redisUtils) {
        //新建过滤器注册类
        FilterRegistrationBean registration = new FilterRegistrationBean();
        // 添加我们写好的过滤器
        registration.setFilter(new LoginFIlter(redisUtils));
        // 设置过滤器的URL模式
        registration.addUrlPatterns("/*");
        registration.setOrder(2);
        return registration;

    }

}

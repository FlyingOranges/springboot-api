package com.vue.api.controller;

import com.vue.api.entity.UsersEntity;
import com.vue.api.service.UsersService;
import com.vue.api.utils.HttpUtils;
import com.vue.api.utils.JsonUtils;
import com.vue.api.utils.RedisUtils;
import com.vue.api.utils.StringUtils;
import com.vue.api.utilsPackages.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.Optional;

@RestController
public class LoginController {

    @Autowired
    private UsersService usersService;

    @Autowired
    private RedisUtils redisUtils;

    @PostMapping(value = "/login")
    public ApiResponse login(@RequestParam Map<String, Object> params, HttpServletRequest request) throws Exception {

        if (params.get("username") == null) {
            return HttpUtils.apiError("请输入邮箱信息");
        }
        if (params.get("password") == null) {
            return HttpUtils.apiError("请输入密码信息");
        }

        String username = params.get("username").toString();
        String password = params.get("password").toString();

        Optional<UsersEntity> data = usersService.login(username);

        if (data.equals(Optional.empty())) {
            return HttpUtils.apiError("没有账户信息");
        }

        if (!StringUtils.stringTomd5(password).equals(data.get().getPassword())) {
            return HttpUtils.apiError("密码错误,请确认账号信息");
        }

        //登录 success，用户信息存储到redis
        redisUtils.setRedisString(data.get().getToken(), 30 * 24 * 60 * 60, JsonUtils.objToJson(data.get()));


        return HttpUtils.apiSuccess("success", data.get());
    }

}

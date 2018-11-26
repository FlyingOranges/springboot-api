package com.vue.api.utils;

import com.vue.api.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class UsersUtils {

    @Autowired
    private RedisUtils redisUtils;

    //获取redis中的用户信息
    public UsersEntity getUsers(String token) throws IOException {

        String jsonObj = redisUtils.getRedisString(token);

        if (jsonObj == null) {
            return null;
        }

        return (UsersEntity) JsonUtils.jsonToObj(new UsersEntity(), jsonObj);
    }

    //获取redis中的用户信息
    public UsersEntity getUsers(HttpServletRequest httpServletRequest) throws IOException {
        String token = httpServletRequest.getHeader("Accept-token");

        return getUsers(token);
    }

}

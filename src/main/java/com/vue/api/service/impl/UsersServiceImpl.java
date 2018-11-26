package com.vue.api.service.impl;

import com.vue.api.entity.UsersEntity;
import com.vue.api.mapper.UsersMapper;
import com.vue.api.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service(value = "UsersService")
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Optional<UsersEntity> login(String username) {

        return Optional.ofNullable(usersMapper.loginUser(username));
    }
}

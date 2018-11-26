package com.vue.api.service;

import com.vue.api.entity.UsersEntity;

import java.util.Optional;

public interface UsersService {

    Optional<UsersEntity> login(String username);

}

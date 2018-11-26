package com.vue.api.mapper;

import com.vue.api.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UsersMapper {

    UsersEntity loginUser(String username);

}

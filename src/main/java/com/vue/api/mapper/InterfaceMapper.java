package com.vue.api.mapper;

import com.vue.api.entity.InterfaceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface InterfaceMapper {

    Integer createInterface(InterfaceEntity interfaceEntity);

}

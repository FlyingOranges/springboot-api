package com.vue.api.mapper;

import com.vue.api.entity.InterfaceEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface InterfaceMapper {

    Integer createInterface(InterfaceEntity interfaceEntity);

    List<InterfaceEntity> getListInterface(Map<String, Object> interfaceEntity);

    InterfaceEntity getInfoInterface(Map<String, Object> interfaceEntity);
}

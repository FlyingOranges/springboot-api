package com.vue.api.mapper;

import com.vue.api.entity.InterfaceParamsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface InterfaceParamsMapper {

    Integer createParamsList(List<HashMap<String, Object>> interfaceParamsEntityList);

    Integer createData(InterfaceParamsEntity interfaceParamsEntityList);
}

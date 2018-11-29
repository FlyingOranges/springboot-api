package com.vue.api.service;

import com.vue.api.entity.InterfaceParamsEntity;

import java.util.HashMap;
import java.util.List;

public interface InterfaceParamsService {
    Integer addParams(List<HashMap<String, Object>> interfaceParamsEntityList);

    Integer addParam(InterfaceParamsEntity interfaceParamsEntityList);
}

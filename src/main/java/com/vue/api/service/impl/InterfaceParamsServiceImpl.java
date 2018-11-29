package com.vue.api.service.impl;

import com.vue.api.entity.InterfaceParamsEntity;
import com.vue.api.mapper.InterfaceParamsMapper;
import com.vue.api.service.InterfaceParamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "InterfaceParamsService")
public class InterfaceParamsServiceImpl implements InterfaceParamsService {

    @Autowired
    private InterfaceParamsMapper interfaceParamsMapper;

    @Override
    public Integer addParams(List<HashMap<String, Object>> interfaceParamsEntityList) {
        return interfaceParamsMapper.createParamsList(interfaceParamsEntityList);
    }

    @Override
    public Integer addParam(InterfaceParamsEntity interfaceParamsEntityList) {
        return interfaceParamsMapper.createData(interfaceParamsEntityList);
    }
}

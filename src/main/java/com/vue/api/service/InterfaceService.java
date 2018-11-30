package com.vue.api.service;

import com.vue.api.entity.InterfaceEntity;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface InterfaceService {

    Integer createData(HashMap<String, Object> params) throws IOException;

    List<InterfaceEntity> getList(Map<String, Object> params);

    InterfaceEntity getInfo(Map<String, Object> params);

}

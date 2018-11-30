package com.vue.api.service.impl;

import com.vue.api.entity.InterfaceEntity;
import com.vue.api.mapper.InterfaceMapper;
import com.vue.api.service.InterfaceService;
import com.vue.api.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service(value = "InterfaceService")
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    private InterfaceMapper interfaceMapper;

    @Override
    public Integer createData(HashMap<String, Object> params) {
        InterfaceEntity interfaceEntity = new InterfaceEntity();

        interfaceEntity.setInterfaceName(params.get("interface_name").toString());
        interfaceEntity.setInterfaceUse(params.get("interface_use").toString());
        interfaceEntity.setInterfaceType(Integer.parseInt(params.get("interface_type").toString()));
        interfaceEntity.setInterfaceUrl(params.get("interface_url").toString());
        interfaceEntity.setInterfaceJson(params.get("interface_json").toString());
        interfaceEntity.setInterfaceNote(params.get("interface_note").toString());
        interfaceEntity.setInterfaceProjectId(Integer.parseInt(params.get("interface_project_id").toString()));

        String interfaceParams = params.get("interface_params").toString();
        if (interfaceParams != null) {
            interfaceEntity.setInterfaceParams(interfaceParams);
        }

        interfaceEntity.setCreatedAt(TimeUtils.getTimestamp());
        interfaceEntity.setUpdatedAt(TimeUtils.getTimestamp());
        interfaceEntity.setStatus(1);

        return interfaceMapper.createInterface(interfaceEntity);
    }
}

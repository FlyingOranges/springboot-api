package com.vue.api.service.impl;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vue.api.entity.InterfaceEntity;
import com.vue.api.entity.InterfaceParamsEntity;
import com.vue.api.mapper.InterfaceMapper;
import com.vue.api.service.InterfaceParamsService;
import com.vue.api.service.InterfaceService;
import com.vue.api.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service(value = "InterfaceService")
public class InterfaceServiceImpl implements InterfaceService {

    @Autowired
    private InterfaceMapper interfaceMapper;

    private InterfaceParamsService interfaceParamsService;

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

        interfaceEntity.setCreatedAt(TimeUtils.getTimestamp());
        interfaceEntity.setUpdatedAt(TimeUtils.getTimestamp());
        interfaceEntity.setStatus(1);

        Integer integerface = interfaceMapper.createInterface(interfaceEntity);
        if (integerface < 1) {
            return 0;
        }

        if (params.get("interface_params") != null) {
            String json = params.get("interface_params").toString();
            System.out.println(json);

            Gson gson = new Gson();
            List<InterfaceParamsEntity> persons = gson.fromJson(
                    json, new TypeToken<List<InterfaceParamsEntity>>() {
                    }.getType()
            );

            for (int i = 0; i < persons.size(); i++) {

                InterfaceParamsEntity j = persons.get(i);
                j.setInterfaceId(interfaceEntity.getId());
                j.setCreatedAt(TimeUtils.getTimestamp());
                j.setUpdatedAt(TimeUtils.getTimestamp());
                j.setStatus(1);

                System.out.println("getParamsNecessary: " + j.toString());

                interfaceParamsService.addParam(j);
            }

            System.out.println(persons.get(0).toString());

//            for (InterfaceParamsEntity interfaceParamsEntity : persons) {
//                interfaceParamsEntity.setInterfaceId(interfaceEntity.getId());
//                interfaceParamsEntity.setCreatedAt(TimeUtils.getTimestamp());
//                interfaceParamsEntity.setUpdatedAt(TimeUtils.getTimestamp());
//                interfaceParamsEntity.setStatus(1);
//
//                System.out.println(interfaceParamsEntity.getParamsNecessary());
//
//                Integer k = interfaceParamsService.addParam(interfaceParamsEntity);
//            }

//            Integer k = interfaceParamsService.addParams(persons);
//            if (k < 1) {
//                return 0;
//            }
        }

        return 1;
    }
}

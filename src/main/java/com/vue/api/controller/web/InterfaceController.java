package com.vue.api.controller.web;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.vue.api.entity.InterfaceParamsEntity;
import com.vue.api.params.ParamsVo;
import com.vue.api.service.InterfaceParamsService;
import com.vue.api.service.InterfaceService;
import com.vue.api.utils.HttpUtils;
import com.vue.api.utils.TimeUtils;
import com.vue.api.utilsPackages.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "interface")
public class InterfaceController {

    private final static Logger logger = LoggerFactory.getLogger(InterfaceController.class);

    @Autowired
    private InterfaceService interfaceService;

    @Autowired
    private InterfaceParamsService interfaceParamsService;


    @PostMapping(value = "/create")
    public ApiResponse create(@RequestParam HashMap<String, Object> params) throws IOException {

        String jsonStr = params.get("interface_params").toString();

        Gson gson = new Gson();
        List<HashMap<String, Object>> persons = gson.fromJson(
                jsonStr, new TypeToken<List<HashMap<String, Object>>>() {
                }.getType()
        );

        for (HashMap<String, Object> par : persons) {
            par.put("interface_id", 1);
            par.put("created_at", TimeUtils.getTimestamp());
            par.put("updated_at", TimeUtils.getTimestamp());
            par.put("status", 1);
            System.out.println("实体类:  " + par.toString());
        }
        interfaceParamsService.addParams(persons);

//        Integer flag = interfaceService.createData(params);
//        if (flag < 1) {
//            return HttpUtils.apiError("新增接口信息失败");
//        }

        return HttpUtils.apiSuccess("新增接口信息成功");
    }
}


package com.vue.api.controller.web;

import com.vue.api.entity.InterfaceEntity;
import com.vue.api.service.InterfaceService;
import com.vue.api.utils.HttpUtils;
import com.vue.api.utilsPackages.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "interface")
public class InterfaceController {

    private final static Logger logger = LoggerFactory.getLogger(InterfaceController.class);

    @Autowired
    private InterfaceService interfaceService;

    @PostMapping(value = "/create")
    public ApiResponse create(@RequestParam HashMap<String, Object> params) throws IOException {

        Integer flag = interfaceService.createData(params);
        if (flag < 1) {
            return HttpUtils.apiError("新增接口信息失败");
        }

        return HttpUtils.apiSuccess("新增接口信息成功");
    }

    @PostMapping(value = "/list")
    public ApiResponse list(@RequestParam Map<String, Object> params) {
        List<InterfaceEntity> data = interfaceService.getList(params);

        return HttpUtils.apiSuccess("success", data);
    }

    @PostMapping(value = "/info")
    public ApiResponse info(@RequestParam Map<String, Object> params) {
        return HttpUtils.apiSuccess("success", interfaceService.getInfo(params));
    }

    @PostMapping(value = "/edit")
    public ApiResponse edit(@RequestParam HashMap<String, Object> params) {
        return HttpUtils.apiSuccess("编辑成功", interfaceService.saveInterface(params));
    }

    @PostMapping(value = "/delete")
    public ApiResponse delete(@RequestParam(name = "id") Integer id) {
        return HttpUtils.apiSuccess("success",interfaceService.deleteInterface(id));
    }
}


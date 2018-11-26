package com.vue.api.controller.web;

import com.vue.api.entity.ProjectEntity;
import com.vue.api.entity.UsersEntity;
import com.vue.api.service.ProjectService;
import com.vue.api.utils.HttpUtils;
import com.vue.api.utils.UsersUtils;
import com.vue.api.utilsPackages.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private UsersUtils usersUtils;

    @PostMapping(value = "/create")
    public ApiResponse createProject(HttpServletRequest httpServletRequest, @RequestParam("name") String name,
                                     @RequestParam("info") String info) throws IOException {
        UsersEntity users = usersUtils.getUsers(httpServletRequest);

        Integer status = projectService.createProject(name, info, users.getId());

        if (status <= 0) {
            return HttpUtils.apiError("新增失败");
        }

        return HttpUtils.apiSuccess("新增项目成功");
    }

    @PostMapping(value = "/list")
    public ApiResponse listProject(@RequestParam HashMap<String, Object> params,
                                   HttpServletRequest httpServletRequest) throws IOException {
        UsersEntity users = usersUtils.getUsers(httpServletRequest);
        List<ProjectEntity> data = projectService.getProjectList(params, users.getId());

        return HttpUtils.apiSuccess("success", data);
    }

}

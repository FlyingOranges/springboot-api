package com.vue.api.service;

import com.vue.api.entity.ProjectEntity;

import java.util.HashMap;
import java.util.List;

public interface ProjectService {

    //创建项目信息
    Integer createProject(String name, String info, Integer userId);

    List<ProjectEntity> getProjectList(HashMap<String, Object> params, Integer userId);
}

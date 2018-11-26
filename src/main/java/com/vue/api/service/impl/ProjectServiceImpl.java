package com.vue.api.service.impl;

import com.vue.api.entity.ProjectEntity;
import com.vue.api.mapper.ProjectMapper;
import com.vue.api.service.ProjectService;
import com.vue.api.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service(value = "ProjectService")
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public Integer createProject(String name, String info, Integer userId) {

        ProjectEntity projectEntity = new ProjectEntity();

        projectEntity.setName(name);
        projectEntity.setInfo(info);
        projectEntity.setUserId(userId);
        projectEntity.setCreatedAt(TimeUtils.getTimestamp());
        projectEntity.setUpdatedAt(TimeUtils.getTimestamp());

        return projectMapper.createData(projectEntity);
    }

    @Override
    public List<ProjectEntity> getProjectList(HashMap<String, Object> params, Integer userId) {

        params.put("status", 1);

        System.out.println(params.get("flag"));
        if (params.get("flag") != null) {
            params.put("userId", userId);
        }

        System.out.println(params.toString());

        return projectMapper.getList(params);
    }
}

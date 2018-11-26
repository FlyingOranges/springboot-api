package com.vue.api.mapper;

import com.vue.api.entity.ProjectEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface ProjectMapper {

    Integer createData(ProjectEntity projectEntity);

    List<ProjectEntity> getList(HashMap<String, Object> params);
}

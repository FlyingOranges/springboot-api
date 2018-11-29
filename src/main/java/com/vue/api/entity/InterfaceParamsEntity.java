package com.vue.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class InterfaceParamsEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer interfaceId;

    private String paramsName;

    private Integer paramsType;

    private Integer paramsNecessary;

    private String paramsExplain;

    private long createdAt;

    private long updatedAt;

    private Integer status;

    public InterfaceParamsEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInterfaceId() {
        return interfaceId;
    }

    public void setInterfaceId(Integer interfaceId) {
        this.interfaceId = interfaceId;
    }

    public String getParamsName() {
        return paramsName;
    }

    public void setParamsName(String paramsName) {
        this.paramsName = paramsName;
    }

    public Integer getParamsType() {
        return paramsType;
    }

    public void setParamsType(Integer paramsType) {
        this.paramsType = paramsType;
    }

    public Integer getParamsNecessary() {
        return paramsNecessary;
    }

    public void setParamsNecessary(Integer paramsNecessary) {
        this.paramsNecessary = paramsNecessary;
    }

    public String getParamsExplain() {
        return paramsExplain;
    }

    public void setParamsExplain(String paramsExplain) {
        this.paramsExplain = paramsExplain;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}

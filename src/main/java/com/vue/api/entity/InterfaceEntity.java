package com.vue.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class InterfaceEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer interfaceProjectId;

    private String interfaceName;

    private String interfaceUse;

    private Integer interfaceType;

    private String interfaceUrl;

    private String interfaceParams;

    private String interfaceJson;

    private String interfaceNote;

    private long createdAt;

    private long updatedAt;

    private Integer status;

    public InterfaceEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInterfaceProjectId() {
        return interfaceProjectId;
    }

    public void setInterfaceProjectId(Integer interfaceProjectId) {
        this.interfaceProjectId = interfaceProjectId;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getInterfaceUse() {
        return interfaceUse;
    }

    public void setInterfaceUse(String interfaceUse) {
        this.interfaceUse = interfaceUse;
    }

    public Integer getInterfaceType() {
        return interfaceType;
    }

    public void setInterfaceType(Integer interfaceType) {
        this.interfaceType = interfaceType;
    }

    public String getInterfaceUrl() {
        return interfaceUrl;
    }

    public void setInterfaceUrl(String interfaceUrl) {
        this.interfaceUrl = interfaceUrl;
    }

    public String getInterfaceParams() {
        return interfaceParams;
    }

    public void setInterfaceParams(String interfaceParams) {
        this.interfaceParams = interfaceParams;
    }

    public String getInterfaceJson() {
        return interfaceJson;
    }

    public void setInterfaceJson(String interfaceJson) {
        this.interfaceJson = interfaceJson;
    }

    public String getInterfaceNote() {
        return interfaceNote;
    }

    public void setInterfaceNote(String interfaceNote) {
        this.interfaceNote = interfaceNote;
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

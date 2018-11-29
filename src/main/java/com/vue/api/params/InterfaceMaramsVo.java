package com.vue.api.params;

import java.io.Serializable;
import java.util.List;

public class InterfaceMaramsVo implements Serializable {

    private String interfaceName;

    private String interfaceUse;

    private Integer interfaceType;

    private String interfaceUrl;

    private String interfaceJson;

    private Integer interfaceProjectId;

    private String interfaceNote;

    private List<ParamsVo> interfaceParams;

    public InterfaceMaramsVo() {
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

    public String getInterfaceJson() {
        return interfaceJson;
    }

    public void setInterfaceJson(String interfaceJson) {
        this.interfaceJson = interfaceJson;
    }

    public Integer getInterfaceProjectId() {
        return interfaceProjectId;
    }

    public void setInterfaceProjectId(Integer interfaceProjectId) {
        this.interfaceProjectId = interfaceProjectId;
    }

    public String getInterfaceNote() {
        return interfaceNote;
    }

    public void setInterfaceNote(String interfaceNote) {
        this.interfaceNote = interfaceNote;
    }

    public List<ParamsVo> getInterfaceParams() {
        return interfaceParams;
    }

    public void setInterfaceParams(List<ParamsVo> interfaceParams) {
        this.interfaceParams = interfaceParams;
    }
}

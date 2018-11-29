package com.vue.api.params;

import java.io.Serializable;

public class ParamsVo implements Serializable {

    private Integer paramsType;

    private Integer paramsNecessary;

    private String paramsName;

    private String paramsExplain;

    public ParamsVo() {
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

    public String getParamsName() {
        return paramsName;
    }

    public void setParamsName(String paramsName) {
        this.paramsName = paramsName;
    }

    public String getParamsExplain() {
        return paramsExplain;
    }

    public void setParamsExplain(String paramsExplain) {
        this.paramsExplain = paramsExplain;
    }
}

package com.gujun.springboot03.entity;

import com.alibaba.fastjson.annotation.JSONField;
import com.gujun.springboot03.entity.Enum.SexEnum;
import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias(value = "em")
public class Employee implements Serializable {

    private static final long serialVersionUID = 9171160249877051802L;

    private Integer eId;

    private String eName;

    private SexEnum eSex;

    public Integer geteId() {
        return eId;
    }

    public void seteId(Integer eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public SexEnum getSexEnum() {
        return eSex;
    }

    public void setSexEnum(SexEnum eSex) {
        this.eSex = eSex;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "eId=" + eId +
                ", eName='" + eName + '\'' +
                ", eSex=" + eSex +
                '}';
    }
}

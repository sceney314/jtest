package json;

import com.alibaba.fastjson.annotation.JSONField;
import com.google.gson.annotations.SerializedName;

/**
 * Copyright (C), 2015-2019
 * DateTest:     2019-05-29 20:34
 * Description:
 */
public class People {

    @JSONField(name = "is_del")
    @SerializedName("is_del")
    private Integer isDel;

    @JSONField(name = "alias_name")
    @SerializedName("alias_name")
    private String aliasName;

    private String age;

    @JSONField(name = "tel_no")
    @SerializedName("tel_no")
    private String telNo;

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    @Override
    public String toString() {
        return "People{" +
                "isDel=" + isDel +
                ", aliasName='" + aliasName + '\'' +
                ", age='" + age + '\'' +
                ", telNo='" + telNo + '\'' +
                '}';
    }
}

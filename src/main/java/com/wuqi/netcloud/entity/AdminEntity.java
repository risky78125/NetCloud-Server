package com.wuqi.netcloud.entity;


import com.wuqi.netcloud.entity.map.RoleExMap;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

public class AdminEntity implements Serializable {

    private Integer adminId;
    private String adminCode;
    private String password;
    private String adminName;
    private String telephone;
    private String email;
    private Date enrolldate;

    private List<RoleExMap> roleList;

    @Override
    public String toString() {
        return "AdminEntity{" +
                "adminId=" + adminId +
                ", adminCode='" + adminCode + '\'' +
                ", password='" + password + '\'' +
                ", adminName='" + adminName + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", enrolldate=" + enrolldate +
                ", roleList=" + roleList +
                '}';
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }


    public String getAdminCode() {
        return adminCode;
    }

    public void setAdminCode(String adminCode) {
        this.adminCode = adminCode;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }


    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public Date getEnrolldate() {
        return enrolldate;
    }

    public void setEnrolldate(Date enrolldate) {
        this.enrolldate = enrolldate;
    }

    public List<RoleExMap> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<RoleExMap> roleList) {
        this.roleList = roleList;
    }
}

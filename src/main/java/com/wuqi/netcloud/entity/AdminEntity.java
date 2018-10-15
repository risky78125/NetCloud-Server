package com.wuqi.netcloud.entity;


import java.io.Serializable;
import java.sql.Date;

public class AdminEntity implements Serializable {

  private Integer adminId;
  private String adminCode;
  private String password;
  private String adminName;
  private String telephone;
  private String email;
  private Date enrolldate;


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

}

package com.swjtu.hrms.entity;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Staff implements UserDetails {

  private long stId;
  private long depId;
  private long posId;
  private String staffId;
  private String name;
  private String gender;
  private java.sql.Date birthDate;
  private String eduBackground;
  private String nation;
  private String politicalStatus;
  private String contactNum;
  private String password;
  private String accountType;
  private java.sql.Date fromDate;
  private java.sql.Date toDate;
  private String entryType;
  private String depName;
  private String positionName;

  @Override
  public boolean equals(Object rhs) {
    if (rhs instanceof Staff) {
      return staffId.equals(((Staff) rhs).getUsername());
    }
    return false;
  }

  /**
   * Returns the hashcode of the {@code username}.
   */
  @Override
  public int hashCode() {
    return staffId.hashCode();
  }

  public String getDepName() {
    return depName;
  }

  public void setDepName(String depName) {
    this.depName = depName;
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    String str;
    if(accountType.equals("人事管理员"))  str="ROLE_admin";
    else if(accountType.equals("教职工")) str="ROLE_user";
    else str="ROLE_dep";
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(str));
    return authorities;
  }

  @Override
  public String getPassword() {
    return password;
  }

  @Override
  public String getUsername() {
    return staffId;
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

  public long getStId() {
    return stId;
  }

  public void setStId(long stId) {
    this.stId = stId;
  }


  public long getDepId() {
    return depId;
  }

  public void setDepId(long depId) {
    this.depId = depId;
  }


  public long getPosId() {
    return posId;
  }

  public void setPosId(long posId) {
    this.posId = posId;
  }


  public String getStaffId() {
    return staffId;
  }

  public void setStaffId(String staffId) {
    this.staffId = staffId;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }


  public java.sql.Date getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(java.sql.Date birthDate) {
    this.birthDate = birthDate;
  }


  public String getEduBackground() {
    return eduBackground;
  }

  public void setEduBackground(String eduBackground) {
    this.eduBackground = eduBackground;
  }


  public String getNation() {
    return nation;
  }

  public void setNation(String nation) {
    this.nation = nation;
  }


  public String getPoliticalStatus() {
    return politicalStatus;
  }

  public void setPoliticalStatus(String politicalStatus) {
    this.politicalStatus = politicalStatus;
  }


  public String getContactNum() {
    return contactNum;
  }

  public void setContactNum(String contactNum) {
    this.contactNum = contactNum;
  }

  public void setPassword(String password) {
    this.password = password;
  }


  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }


  public java.sql.Date getFromDate() {
    return fromDate;
  }

  public void setFromDate(java.sql.Date fromDate) {
    this.fromDate = fromDate;
  }


  public java.sql.Date getToDate() {
    return toDate;
  }

  public void setToDate(java.sql.Date toDate) {
    this.toDate = toDate;
  }


  public String getEntryType() {
    return entryType;
  }

  public void setEntryType(String entryType) {
    this.entryType = entryType;
  }

}

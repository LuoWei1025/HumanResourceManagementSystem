package com.swjtu.hrms.entity;


public class LeaveApplication {

  private long lvId;
  private long stId;
  private String staffId;//add
  private String name;//add
  private java.sql.Date leaveDate;
  private String leaveReason;
  private long leaveDays;
  private String status;


  public long getLvId() {
    return lvId;
  }

  public void setLvId(long lvId) {
    this.lvId = lvId;
  }


  public long getStId() {
    return stId;
  }

  public void setStId(long stId) {
    this.stId = stId;
  }


  public java.sql.Date getLeaveDate() {
    return leaveDate;
  }

  public void setLeaveDate(java.sql.Date leaveDate) {
    this.leaveDate = leaveDate;
  }


  public String getLeaveReason() {
    return leaveReason;
  }

  public void setLeaveReason(String leaveReason) {
    this.leaveReason = leaveReason;
  }


  public long getLeaveDays() {
    return leaveDays;
  }

  public void setLeaveDays(long leaveDays) {
    this.leaveDays = leaveDays;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getStaffId() { return staffId; }

  public void setStaffId(String staffId) { this.staffId = staffId; }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}

package com.swjtu.hrms.entity;


public class OvertimeRecord {

  private long otId;
  private long stId;
  private String staffId;
  private String name; //test
  private java.sql.Date overtimeDate;
  private long overtimeHours;


  public long getOtId() {
    return otId;
  }

  public void setOtId(long otId) {
    this.otId = otId;
  }


  public long getStId() {
    return stId;
  }

  public void setStId(long stId) {
    this.stId = stId;
  }


  public java.sql.Date getOvertimeDate() {
    return overtimeDate;
  }

  public void setOvertimeDate(java.sql.Date overtimeDate) {
    this.overtimeDate = overtimeDate;
  }


  public long getOvertimeHours() {
    return overtimeHours;
  }

  public void setOvertimeHours(long overtimeHours) {
    this.overtimeHours = overtimeHours;
  }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }

  public String getStaffId() { return staffId; }

  public void setStaffId(String staffId) { this.staffId = staffId; }
}

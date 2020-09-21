package com.swjtu.hrms.entity;


public class AttendanceRecord {

  private long attId;
  private long stId;
  private String staffId;
  private String name;
  private java.sql.Date attendanceDate;
  private String type;


  public long getAttId() {
    return attId;
  }

  public void setAttId(long attId) {
    this.attId = attId;
  }


  public long getStId() {
    return stId;
  }

  public void setStId(long stId) {
    this.stId = stId;
  }


  public java.sql.Date getAttendanceDate() {
    return attendanceDate;
  }

  public void setAttendanceDate(java.sql.Date attendanceDate) {
    this.attendanceDate = attendanceDate;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getStaffId() { return staffId; }

  public void setStaffId(String staffId) { this.staffId = staffId; }

  public String getName() { return name; }

  public void setName(String name) { this.name = name; }
}

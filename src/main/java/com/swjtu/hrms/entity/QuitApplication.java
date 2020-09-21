package com.swjtu.hrms.entity;


public class QuitApplication {

  private long qId;
  private String staffId;
  private String name;
  private java.sql.Date quitDate;
  private String quitReason;
  private String status;

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

  public long getqId() {
    return qId;
  }

  public void setqId(long qId) {
    this.qId = qId;
  }

  public java.sql.Date getQuitDate() {
    return quitDate;
  }

  public void setQuitDate(java.sql.Date quitDate) {
    this.quitDate = quitDate;
  }


  public String getQuitReason() {
    return quitReason;
  }

  public void setQuitReason(String quitReason) {
    this.quitReason = quitReason;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

}

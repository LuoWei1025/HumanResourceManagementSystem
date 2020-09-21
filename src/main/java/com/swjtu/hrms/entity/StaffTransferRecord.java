package com.swjtu.hrms.entity;


public class StaffTransferRecord {

  private long transId;
  private long stId;
  private java.sql.Date transferDate;
  private String originalPosition;
  private String afterPosition;


  public long getTransId() {
    return transId;
  }

  public void setTransId(long transId) {
    this.transId = transId;
  }


  public long getStId() {
    return stId;
  }

  public void setStId(long stId) {
    this.stId = stId;
  }


  public java.sql.Date getTransferDate() {
    return transferDate;
  }

  public void setTransferDate(java.sql.Date transferDate) {
    this.transferDate = transferDate;
  }


  public String getOriginalPosition() {
    return originalPosition;
  }

  public void setOriginalPosition(String originalPosition) {
    this.originalPosition = originalPosition;
  }


  public String getAfterPosition() {
    return afterPosition;
  }

  public void setAfterPosition(String afterPosition) {
    this.afterPosition = afterPosition;
  }

}

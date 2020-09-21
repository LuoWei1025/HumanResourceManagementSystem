package com.swjtu.hrms.entity;

public class DepartmentTrain {

  private long trainId;
  private long depId;
  private String trainName;
  private java.sql.Date trainDate;
  private long trainDays;
  private String trainAddress;
  private String lecturer;
  private long staffNum;


  public long getTrainId() {
    return trainId;
  }

  public void setTrainId(long trainId) {
    this.trainId = trainId;
  }


  public long getDepId() {
    return depId;
  }

  public void setDepId(long depId) {
    this.depId = depId;
  }


  public String getTrainName() {
    return trainName;
  }

  public void setTrainName(String trainName) {
    this.trainName = trainName;
  }


  public java.sql.Date getTrainDate() {
    return trainDate;
  }

  public void setTrainDate(java.sql.Date trainDate) {
    this.trainDate = trainDate;
  }


  public long getTrainDays() {
    return trainDays;
  }

  public void setTrainDays(long trainDays) {
    this.trainDays = trainDays;
  }


  public String getTrainAddress() {
    return trainAddress;
  }

  public void setTrainAddress(String trainAddress) {
    this.trainAddress = trainAddress;
  }


  public String getLecturer() {
    return lecturer;
  }

  public void setLecturer(String lecturer) {
    this.lecturer = lecturer;
  }


  public long getStaffNum() {
    return staffNum;
  }

  public void setStaffNum(long staffNum) {
    this.staffNum = staffNum;
  }

}

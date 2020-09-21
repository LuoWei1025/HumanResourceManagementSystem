package com.swjtu.hrms.entity;


public class Positon {

  private long posId;
  private long depId;
  private String depName;//add
  private String positionId;
  private String positionName;


  public long getPosId() {
    return posId;
  }

  public void setPosId(long posId) {
    this.posId = posId;
  }


  public long getDepId() {
    return depId;
  }

  public void setDepId(long depId) {
    this.depId = depId;
  }


  public String getPositionId() {
    return positionId;
  }

  public void setPositionId(String positionId) {
    this.positionId = positionId;
  }

  public String getPositionName() {
    return positionName;
  }

  public void setPositionName(String positionName) {
    this.positionName = positionName;
  }

  public String getDepName() { return depName; }

  public void setDepName(String depName) { this.depName = depName; }
}

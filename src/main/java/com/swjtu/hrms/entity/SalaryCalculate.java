package com.swjtu.hrms.entity;

public class SalaryCalculate {

  private long salId;
  private long posId;
  private String positionId;//add
  private String positionName;//add
  private long salaryAmount;
  private long absenceStep;
  private long overtimeStep;


  public long getSalId() {
    return salId;
  }

  public void setSalId(long salId) {
    this.salId = salId;
  }


  public long getPosId() {
    return posId;
  }

  public void setPosId(long posId) {
    this.posId = posId;
  }


  public long getSalaryAmount() {
    return salaryAmount;
  }

  public void setSalaryAmount(long salaryAmount) {
    this.salaryAmount = salaryAmount;
  }


  public long getAbsenceStep() {
    return absenceStep;
  }

  public void setAbsenceStep(long absenceStep) {
    this.absenceStep = absenceStep;
  }


  public long getOvertimeStep() {
    return overtimeStep;
  }

  public void setOvertimeStep(long overtimeStep) {
    this.overtimeStep = overtimeStep;
  }

  public String getPositionId() { return positionId; }

  public void setPositionId(String positionId) { this.positionId = positionId; }

  public String getPositionName() { return positionName; }

  public void setPositionName(String positionName) { this.positionName = positionName; }
}

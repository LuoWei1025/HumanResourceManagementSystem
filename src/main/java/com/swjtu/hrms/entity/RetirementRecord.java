package com.swjtu.hrms.entity;


import java.sql.Date;

public class RetirementRecord {
    private long retId;
    private long stId;
    private String name;
    private String staffId;
    private java.sql.Date retirementDate;
    private long retirementAge;
    private long workYears;

    public long getStId() {
        return stId;
    }

    public void setStId(long stId) {
        this.stId = stId;
    }

    public long getRetId() {
        return retId;
    }

    public void setRetId(long retId) {
        this.retId = retId;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public Date getRetirementDate() {
        return retirementDate;
    }

    public void setRetirementDate(Date retirementDate) {
        this.retirementDate = retirementDate;
    }

    public long getRetirementAge() {
        return retirementAge;
    }

    public void setRetirementAge(long retirementAge) {
        this.retirementAge = retirementAge;
    }

    public long getWorkYears() {
        return workYears;
    }

    public void setWorkYears(long workYears) {
        this.workYears = workYears;
    }
}

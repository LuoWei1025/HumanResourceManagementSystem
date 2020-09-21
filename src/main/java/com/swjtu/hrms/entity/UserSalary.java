package com.swjtu.hrms.entity;

public class UserSalary {
    private String staffId;
    private String name;
    private long salaryAmount;
    private long absenceStep;
    private long overtimeStep;

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
}

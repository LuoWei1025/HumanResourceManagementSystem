package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.SalaryCalculate;
import com.swjtu.hrms.entity.UserSalary;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.UsefulPosId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SalaryCalculateDAO {
    List<SalaryCalculate> findAll();
    UserSalary loadUserSalaryByUsername(String staffId);
    int insertNew(SalaryCalculate salaryCalculate);
    int alterField(AlterFieldInfo alterFieldInfo);
    List<UsefulPosId> findUsefulPosId();
}

package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.DepartmentTrain;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.TheDepId;
import com.swjtu.hrms.model.UsefulPosId;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DepartmentTrainDAO {
    List<DepartmentTrain> findAll(String staffId);
    int insertNew(DepartmentTrain departmentTrain);
    int alterField(AlterFieldInfo alterFieldInfo);
    List<TheDepId> findTheDepId(String staffId);
}

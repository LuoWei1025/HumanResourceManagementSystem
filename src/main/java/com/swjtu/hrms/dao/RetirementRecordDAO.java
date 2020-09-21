package com.swjtu.hrms.dao;


import com.swjtu.hrms.entity.RetirementRecord;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface RetirementRecordDAO {
    List<RetirementRecord> findAll();
    int insertNew(RetirementRecord retirementRecord);
    int alterField(AlterFieldInfo alterFieldInfo);
}

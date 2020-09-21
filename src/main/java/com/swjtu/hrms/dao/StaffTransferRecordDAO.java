package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StaffTransferRecordDAO {
    List<StaffTransferRecord> findAll();
    int insertNew(StaffTransferRecord staffTransferRecord);
    int alterField(AlterFieldInfo alterFieldInfo);
}

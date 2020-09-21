package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.OvertimeRecord;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface OvertimeRecordDAO {
    List<OvertimeRecord> findAll();
    int insertNew(OvertimeRecord overtimeRecord);
    List<OvertimeRecord> findByStaffId(String staffId);
    int alterField(AlterFieldInfo alterFieldInfo);
}

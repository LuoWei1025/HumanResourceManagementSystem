package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.Positon;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PositionDAO {
    List<Positon> findAll();
    int insertNew(Positon positon);
    int alterField(AlterFieldInfo alterFieldInfo);
}

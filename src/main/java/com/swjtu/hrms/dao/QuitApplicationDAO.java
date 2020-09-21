package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.QuitApplication;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QuitApplicationDAO {
    List<QuitApplication> findAll();
    String findstId(String staffId);
    void insertQuitApplication(String stId,String quitDate,String quitReason);
    int alterField(AlterFieldInfo alterFieldInfo);
}

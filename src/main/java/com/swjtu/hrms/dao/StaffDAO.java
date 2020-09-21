package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.Staff;
import org.apache.ibatis.annotations.Mapper;

import java.util.Map;

@Mapper
public interface StaffDAO {
    Staff loadUserByStaffId(String staffId);

    Staff loadStaffByStaffId(String staffId);

    void updataStaff(Staff staff);

    void insertRegisterInfo(int depId,int posId,String staffId,String name,String accountType,
                            String fromDate,String toDate);


    void insertRehireInfo(int depId,int posId,String staffId,String name,String accountType,
                          String fromDate,String toDate);
}

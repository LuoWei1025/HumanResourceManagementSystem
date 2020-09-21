package com.swjtu.hrms.dao;

import com.swjtu.hrms.entity.Department;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface DepartmentDAO {
    Department showUserDepInfo(String staffId);
    public void updataDep(Department department);
}

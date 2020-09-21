package com.swjtu.hrms.service;

import com.swjtu.hrms.dao.DepartmentDAO;
import com.swjtu.hrms.entity.Department;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DepartmentService {

    @Resource
    private DepartmentDAO departmentDAO;

    public Department showUserDepInfo(String staffId){
        try {
            Department department = departmentDAO.showUserDepInfo(staffId);
            return department;
        }catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void updataDep(Department department){
        if(department.equals("")){
            return;
        }
        try{
            departmentDAO.updataDep(department);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

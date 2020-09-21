package com.swjtu.hrms.controller;

import com.swjtu.hrms.entity.Department;
import com.swjtu.hrms.service.DepartmentService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.security.Principal;
import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/staff_department")
public class DepartmentController {
    @Resource
    DepartmentService departmentService;

    @RequestMapping("/dep")
    Department department(Principal principal){return departmentService.showUserDepInfo(principal.getName());}

    @RequestMapping("/add")
    public void InsertUserDepInfo(@RequestParam Map<String,Object> map)throws ParseException {
        System.out.println(map.get("departmentId"));
        System.out.println("asdasd");
        Department department = new Department();
        department.setDepartmentId((String)map.get("departmentId"));
        department.setAddress((String)map.get("address"));
        department.setContactNum((String)map.get("contactNum"));
        department.setDepName((String)map.get("depName"));
        departmentService.updataDep(department);
    }
}

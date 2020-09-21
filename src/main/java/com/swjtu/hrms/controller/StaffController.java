package com.swjtu.hrms.controller;

import com.swjtu.hrms.entity.Staff;
import com.swjtu.hrms.service.StaffService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@RestController
@RequestMapping("/staff_info")
public class StaffController {
    @Resource
    StaffService staffService;

    @GetMapping("")
    Staff staffInfo(Principal principal){
        return staffService.loadStaffByUsername(principal.getName());
    }

    @GetMapping("/user")
    String staffName(Principal principal){
        return staffService.loadStaffByUsername(principal.getName()).getName();
    }

    @GetMapping("/userid")
    String staffId(Principal principal){
        return principal.getName();
    }

    @PostMapping("/add")
    public void InsertQuitApplication(@RequestParam Map<String,Object> map) throws ParseException {
        System.out.println(map.get("name"));
        Staff staff=new Staff();
        staff.setStaffId((String) map.get("staffId"));
        staff.setName((String) map.get("name"));
        staff.setGender((String)map.get("gender"));
        staff.setNation((String)map.get("nation"));
        staff.setPoliticalStatus((String)map.get("politicalStatus"));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date d = null;
        try {
            d = format.parse((String) map.get("birthDate"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        java.sql.Date date = new java.sql.Date(d.getTime());
        staff.setBirthDate(date);
        staff.setContactNum((String)map.get("contactNum"));
        staffService.updataStaff(staff);
    }

    //录入教职工的报到信息
    @PostMapping("/register")
    public void insertRegisterInfo(String depId,String posId,String staffId,String name,String accountType,
                                   String fromDate,String toDate)
    {
        if(depId.equals("") || posId.equals("") || staffId.equals("") || name.equals("")
                || accountType.equals("") || fromDate.equals("") || toDate.equals("")){
            return ;
        }
        try{
            staffService.insertRegisterInfo(Integer.parseInt(depId),Integer.parseInt(posId),staffId,name,
                    accountType,fromDate,toDate);
        }catch (Exception e){
            System.out.println("插入教职工报到信息出错");
            e.printStackTrace();
        }
    }

    //录入教职工的报到信息
    @PostMapping("/rehire")
    public void insertRehireInfo(String depId,String posId,String staffId,String name,String accountType,
                                   String fromDate,String toDate)
    {
        if(depId.equals("") || posId.equals("") || staffId.equals("") || name.equals("")
                ||accountType.equals("") || fromDate.equals("") || toDate.equals("")){
            return ;
        }
        try {
            staffService.insertRehireInfo(Integer.parseInt(depId), Integer.parseInt(posId), staffId, name,
                    accountType, fromDate, toDate);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
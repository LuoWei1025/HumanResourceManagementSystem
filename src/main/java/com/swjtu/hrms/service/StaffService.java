package com.swjtu.hrms.service;

import com.swjtu.hrms.dao.StaffDAO;
import com.swjtu.hrms.entity.Staff;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StaffService implements UserDetailsService {
    @Resource
    StaffDAO staffDAO;
    @Override
    public UserDetails loadUserByUsername(String staffId) throws UsernameNotFoundException {
        if(staffId.equals("")){
            return null;
        }
        Staff user = staffDAO.loadUserByStaffId(staffId);
        if(user==null){
            throw new UsernameNotFoundException("账户不存在！");
        }
        return user;
    }

    public Staff loadStaffByUsername(String staffId) {
        if(staffId.equals("")){
            return null;
        }
        Staff user = staffDAO.loadStaffByStaffId(staffId);
        if(user==null){
            throw new UsernameNotFoundException("账户不存在！");
        }
        return user;
    }

    public void updataStaff(Staff staff) {
        if(staff.equals("")){
            return;
        }
        try{
            staffDAO.updataStaff(staff);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertRegisterInfo(int depId,int posId,String staffId,String name,String accountType,
                                   String fromDate,String toDate){
        try{
            staffDAO.insertRegisterInfo(depId,posId,staffId,name,accountType,fromDate,toDate);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void insertRehireInfo(int depId,int posId,String staffId,String name,String accountType,
                                 String fromDate,String toDate) {
        try{
            staffDAO.insertRehireInfo(depId,posId,staffId,name,accountType,fromDate,toDate);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

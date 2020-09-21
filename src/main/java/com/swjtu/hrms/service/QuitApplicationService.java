package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.QuitApplicationDAO;
import com.swjtu.hrms.entity.QuitApplication;
import com.swjtu.hrms.entity.QuitApplication;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class QuitApplicationService {
    @Resource
    private QuitApplicationDAO quitApplicationDAO;

    public List<QuitApplication> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return quitApplicationDAO.findAll();
    }

    public String findstId(String staffId){
        return quitApplicationDAO.findstId(staffId);
    }

    public void insertQuitApplication(String stId,String quitDate,String quitReason){
        quitApplicationDAO.insertQuitApplication(stId,quitDate,quitReason);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return quitApplicationDAO.alterField(alterFieldInfo);
    }
}

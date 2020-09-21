package com.swjtu.hrms.service;

import com.github.pagehelper.PageHelper;
import com.swjtu.hrms.dao.PositionDAO;
import com.swjtu.hrms.entity.Positon;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PositionService {
    @Resource
    private PositionDAO positionDAO;

    public List<Positon> findAll(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);//启用分页
        return positionDAO.findAll();
    }

    public int insertNew(Positon positon) {
        return positionDAO.insertNew(positon);
    }

    public int alterField(AlterFieldInfo alterFieldInfo) {
        return positionDAO.alterField(alterFieldInfo);
    }
}

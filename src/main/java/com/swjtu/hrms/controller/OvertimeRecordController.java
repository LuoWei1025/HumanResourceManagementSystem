package com.swjtu.hrms.controller;

import com.github.pagehelper.PageInfo;
import com.swjtu.hrms.security.IAuthenticationFacade;
import com.swjtu.hrms.entity.OvertimeRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.LayuiPageInfo;
import com.swjtu.hrms.service.OvertimeRecordService;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/overtime_record")
public class OvertimeRecordController {
    @Resource
    OvertimeRecordService overtimeRecordService;

    @Resource
    private IAuthenticationFacade authenticationFacade;

    @GetMapping("/user")
    // Spring boot控制器方法的参数自动与表单提交的参数匹配，
    //当前表单字段名与方法的参数名一致时@Param可以不用
    LayuiPageInfo findByStaffId(Integer page, Integer limit){
        Authentication authentication = authenticationFacade.getAuthentication();
        List<OvertimeRecord> datas = overtimeRecordService.findByStaffId(authentication.getName(),page,limit);
        //使用PageHelper的分页功能获取网页的分页信息，以下语句与上一条之间不能有其他数据库操作
        PageInfo<OvertimeRecord> pageInfo = new PageInfo<OvertimeRecord>(datas);
        //创建返回到客户端的数据模型
        LayuiPageInfo result = new LayuiPageInfo();
        result.setCode(0);
        result.setMsg("");          //数据
        result.setCount(pageInfo.getTotal());   //记录总数
        result.setData(datas);
        return result;

    }

    //page页码  limit页尺寸
    @GetMapping("/list")
    // Spring boot控制器方法的参数自动与表单提交的参数匹配，
    //当前表单字段名与方法的参数名一致时@Param可以不用
    LayuiPageInfo findAll(Integer page, Integer limit) {
        List<OvertimeRecord> datas = overtimeRecordService.findAll(page,limit);
        //使用PageHelper的分页功能获取网页的分页信息，以下语句与上一条之间不能有其他数据库操作
        PageInfo<OvertimeRecord> pageInfo = new PageInfo<OvertimeRecord>(datas);
        //创建返回到客户端的数据模型
        LayuiPageInfo result = new LayuiPageInfo();
        result.setCode(0);
        result.setMsg("");          //数据
        result.setCount(pageInfo.getTotal());   //记录总数
        result.setData(datas);
        return result;
    }

    @PostMapping("/add")
    int insertNew(HttpServletRequest request) {
        OvertimeRecord overtimeRecord = new OvertimeRecord();
        overtimeRecord.setStId(1);
        overtimeRecord.setOvertimeDate(new Date(0));
        overtimeRecord.setOvertimeHours(99);
        return overtimeRecordService.insertNew(overtimeRecord);
    }

    @PostMapping("/alter")
    int alterField(String pk,String field,String value) {
        AlterFieldInfo alterFieldInfo = new AlterFieldInfo();
        alterFieldInfo.setPk(pk);
        alterFieldInfo.setField(field);
        alterFieldInfo.setValue(value);
        return overtimeRecordService.alterField(alterFieldInfo);
    }
}

package com.swjtu.hrms.controller;

import com.github.pagehelper.PageInfo;
import com.swjtu.hrms.entity.SalaryCalculate;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.entity.UserSalary;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.LayuiPageInfo;
import com.swjtu.hrms.model.UsefulPosId;
import com.swjtu.hrms.service.SalaryCalculateService;
import com.swjtu.hrms.service.StaffTransferRecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/salary_calculate")
public class SalaryCalculateController {
    @Resource
    SalaryCalculateService salaryCalculateService;

    //page页码  limit页尺寸
    @GetMapping("/list")
    // Spring boot控制器方法的参数自动与表单提交的参数匹配，
    //当前表单字段名与方法的参数名一致时@Param可以不用
    LayuiPageInfo findAll(Integer page, Integer limit) {
        List<SalaryCalculate> datas = salaryCalculateService.findAll(page,limit);
        //使用PageHelper的分页功能获取网页的分页信息，以下语句与上一条之间不能有其他数据库操作
        PageInfo<SalaryCalculate> pageInfo = new PageInfo<SalaryCalculate>(datas);
        //创建返回到客户端的数据模型
        LayuiPageInfo result = new LayuiPageInfo();
        result.setCode(0);
        result.setMsg("");          //数据
        result.setCount(pageInfo.getTotal());   //记录总数
        result.setData(datas);
        return result;
    }

    @RequestMapping("/salary_info")
    UserSalary userSalary(Principal principal){
        try {
            return salaryCalculateService.loadUserSalaryByUsername(principal.getName());
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/add")
    int insertNew(HttpServletRequest request) {
        SalaryCalculate salaryCalculate = new SalaryCalculate();
        List<UsefulPosId> posIds = salaryCalculateService.findUsefulPosId();
        long usefulPosId = posIds.get(0).getPosId();
        salaryCalculate.setPosId(usefulPosId);
        salaryCalculate.setSalaryAmount(1);
        salaryCalculate.setAbsenceStep(100);
        salaryCalculate.setOvertimeStep(50);
        return salaryCalculateService.insertNew(salaryCalculate);
    }

    @PostMapping("/alter")
    int alterField(String pk,String field,String value) {
        AlterFieldInfo alterFieldInfo = new AlterFieldInfo();
        alterFieldInfo.setPk(pk);
        alterFieldInfo.setField(field);
        alterFieldInfo.setValue(value);
        return salaryCalculateService.alterField(alterFieldInfo);
    }

}

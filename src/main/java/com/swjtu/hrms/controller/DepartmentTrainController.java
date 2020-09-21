package com.swjtu.hrms.controller;

import com.github.pagehelper.PageInfo;
import com.swjtu.hrms.entity.DepartmentTrain;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.LayuiPageInfo;
import com.swjtu.hrms.model.TheDepId;
import com.swjtu.hrms.model.UsefulPosId;
import com.swjtu.hrms.service.DepartmentTrainService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/department_train")
public class DepartmentTrainController {
    @Resource
    DepartmentTrainService departmentTrainService;

    //page页码  limit页尺寸
    @GetMapping("/list")
    // Spring boot控制器方法的参数自动与表单提交的参数匹配，
    //当前表单字段名与方法的参数名一致时@Param可以不用
    LayuiPageInfo findAll(Principal principal, Integer page, Integer limit) {
        List<DepartmentTrain> datas = departmentTrainService.findAll(principal.getName(),page,limit);
        //使用PageHelper的分页功能获取网页的分页信息，以下语句与上一条之间不能有其他数据库操作
        PageInfo<DepartmentTrain> pageInfo = new PageInfo<DepartmentTrain>(datas);
        //创建返回到客户端的数据模型
        LayuiPageInfo result = new LayuiPageInfo();
        result.setCode(0);
        result.setMsg("");          //数据
        result.setCount(pageInfo.getTotal());   //记录总数
        result.setData(datas);
        return result;
    }

    @PostMapping("/add")
    int insertNew(Principal principal,HttpServletRequest request) {
        DepartmentTrain departmentTrain = new DepartmentTrain();
        List<TheDepId> theDepIds = departmentTrainService.findTheDepId(principal.getName());
        long theDepId = theDepIds.get(0).getDepId();
        departmentTrain.setDepId(theDepId);
        departmentTrain.setTrainName("？？？");
        departmentTrain.setTrainDate(new Date(0));
        departmentTrain.setTrainDays(0);
        departmentTrain.setTrainAddress("？？？");
        departmentTrain.setLecturer("？？？");
        departmentTrain.setStaffNum(0);
        return departmentTrainService.insertNew(departmentTrain);
    }

    @PostMapping("/alter")
    int alterField(String pk,String field,String value) {
        AlterFieldInfo alterFieldInfo = new AlterFieldInfo();
        alterFieldInfo.setPk(pk);
        alterFieldInfo.setField(field);
        alterFieldInfo.setValue(value);
        return departmentTrainService.alterField(alterFieldInfo);
    }
}

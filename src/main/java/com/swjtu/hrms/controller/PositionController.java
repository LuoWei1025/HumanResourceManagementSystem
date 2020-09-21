package com.swjtu.hrms.controller;

import com.github.pagehelper.PageInfo;
import com.swjtu.hrms.entity.Positon;
import com.swjtu.hrms.entity.StaffTransferRecord;
import com.swjtu.hrms.model.AlterFieldInfo;
import com.swjtu.hrms.model.LayuiPageInfo;
import com.swjtu.hrms.service.PositionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/position")
public class PositionController {
    @Resource
    PositionService positionService;

    //page页码  limit页尺寸
    @GetMapping("/list")
    // Spring boot控制器方法的参数自动与表单提交的参数匹配，
    //当前表单字段名与方法的参数名一致时@Param可以不用
    LayuiPageInfo findAll(Integer page, Integer limit) {
        List<Positon> datas = positionService.findAll(page,limit);
        //使用PageHelper的分页功能获取网页的分页信息，以下语句与上一条之间不能有其他数据库操作
        PageInfo<Positon> pageInfo = new PageInfo<Positon>(datas);
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
        Positon positon = new Positon();
        positon.setDepId(1);
        positon.setPositionId("0000");
        positon.setPositionName("???");
        return positionService.insertNew(positon);
    }

    @PostMapping("/alter")
    int alterField(String pk,String field,String value) {
        AlterFieldInfo alterFieldInfo = new AlterFieldInfo();
        alterFieldInfo.setPk(pk);
        alterFieldInfo.setField(field);
        alterFieldInfo.setValue(value);
        return positionService.alterField(alterFieldInfo);
    }
}

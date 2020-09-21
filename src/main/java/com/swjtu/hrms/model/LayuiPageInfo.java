package com.swjtu.hrms.model;

import java.util.List;

public class LayuiPageInfo {
    private Integer code;   //错误代码，0表示正确
    private String msg;     //错误信息
    private Long count;     //记录总数
    private List data;      //返回的一页的数据

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List getData() {
        return data;
    }

    public void setData(List data) {
        this.data = data;
    }
}


layui.use(['table','element','layer'], function() {
    var table = layui.table,
        form = layui.form,
        $=layui.$,      //是Layui封装了的JQuery
        layer=layui.layer,      //弹出层的功能
        element=layui.element;  //一些动态效果

    //监听考勤状态操作
    form.on('switch(attenType)', function(obj){     //********
        var result;
        if(obj.elem.checked)
            result = '出勤';      //********
        else result = '缺勤';     //********
        //显示提示信息
        layer.tips('序号为: [' + this.value + '] 的考勤记录，考勤结果更改为：'+ result, obj.othis);  //********
        //反馈修改到数据库
        $.ajax({
            url: `/attendance_record/alter?pk=${this.value}&field=type&value=${result}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
    });
})
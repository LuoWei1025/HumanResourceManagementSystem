
layui.use(['table','element','layer'], function() {
    var table = layui.table,
        $=layui.$,      //是Layui封装了的JQuery
        layer=layui.layer;      //弹出层的功能

    //监听单元格编辑
    table.on('edit(tabtlm)', function(obj){     //********
        var field = obj.field, //得到字段
            value = obj.value, //得到修改后的值
            data = obj.data; //得到所在行所有键值
        //显示提示信息
        layer.msg('序号为: ['+ data.lvId +'] 的请假申请 审核状态更改为：'+ value);    //********
        //反馈修改到数据库
        $.ajax({
            url: `/leave_application/alter?pk=${data.lvId}&field=${field}&value=${value}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
    });
})
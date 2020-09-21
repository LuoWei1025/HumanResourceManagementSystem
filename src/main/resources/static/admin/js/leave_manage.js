
layui.use(['table','element','layer'], function() {
    var table = layui.table,
        form = layui.form,
        $=layui.$,      //是Layui封装了的JQuery
        layer=layui.layer,      //弹出层的功能
        element=layui.element;  //一些动态效果

    //监听审核状态操作
    form.on('switch(leaveStatus)', function(obj){       //********
        var result;
        if(obj.elem.checked)
            result = '通过';           //********
        else result = '审核中';         //********
        //显示提示信息
        layer.tips('序号为: [' + this.value + '] 的离职申请，审核状态更改为：'+ result, obj.othis);    //********
        //反馈修改到数据库
        $.ajax({
            url: `/quit_application/alter?pk=${this.value}&field=status&value=${result}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
    });
})
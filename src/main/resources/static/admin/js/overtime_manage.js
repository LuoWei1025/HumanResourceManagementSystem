layui.use(['table','element','layer'], function() {
    var table = layui.table,
        $=layui.$,      //是Layui封装了的JQuery
        layer=layui.layer,      //弹出层的功能
        element=layui.element;  //一些动态效果

    //监听单元格编辑
    table.on('edit(tabom)', function(obj){     //********
        var field = obj.field, //得到字段
            value = obj.value, //得到修改后的值
            data = obj.data; //得到所在行所有键值
        switch (field) {
            case 'stId':    field='st_id'; break;                       //********
            case 'overtimeDate':    field='overtime_date'; break;       //********
            case 'overtimeHours':   field='overtime_hours'; break;   //********
            default:break;
        }
        //显示提示信息
        layer.msg('加班序号: ['+ data.otId +'] 下 [' + field + '] 字段更改为：'+ value);    //********
        //反馈修改到数据库
        $.ajax({
            url: `/overtime_record/alter?pk=${data.otId}&field=${field}&value=${value}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
        //重新渲染表格到当前页
        table.reload('tabom', {
            page: {
                curr: $(".layui-laypage-em").next().html()
            }
        });
    });

    $("#addTable").click(function() {           //************
        //插入一行数据到数据库
        $.ajax({
            url: "/overtime_record/add",           //***********
            type: "post",
            async: false,
            dataType: "json",
        });
        //重新渲染表格到最后一页
        $.ajax({
            url: "/overtime_record/list?page=0&limit=0", // Hacked    //***********
            type: "get",
            async: false,
            dataType: "json",
            success: function(e) {
                let pageLimit = $(".layui-laypage-limits").find("select").val();
                table.reload('tabom', {page: {curr: Math.ceil(e.count / pageLimit) } });   //***********
            }
        })
    });

})
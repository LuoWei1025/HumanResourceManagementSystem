
layui.use(['table','element','layer'], function() {
    var table = layui.table,
        $=layui.$,      //是Layui封装了的JQuery
        layer=layui.layer,      //弹出层的功能
        element=layui.element;  //一些动态效果

    //监听单元格编辑
    table.on('edit(tabrm)', function(obj){     //********
        var field = obj.field, //得到字段
            value = obj.value, //得到修改后的值
            data = obj.data; //得到所在行所有键值
        switch (field) {
            case 'stId':    field='st_id'; break;                       //********
            case 'retirementDate':    field='retirement_date'; break;       //********
            case 'retirementAge':   field='retirement_age'; break;   //********
            case 'workYears':   field='work_years'; break;      //********
            default:break;
        }
        //显示提示信息
        layer.msg('退休序号: ['+ data.retId +'] 下 [' + field + '] 字段更改为：'+ value);    //********
        //反馈修改到数据库
        $.ajax({
            url: `/retirement_record/alter?pk=${data.retId}&field=${field}&value=${value}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
        //重新渲染表格到当前页
        table.reload('tabrm', {
            page: {
                curr: $(".layui-laypage-em").next().html()
            }
        });
    });

    $("#addTable").click(function() {           //************
        //插入一行数据到数据库
        $.ajax({
            url: "/retirement_record/add",           //***********
            type: "post",
            async: false,
            dataType: "json",
        });
        //重新渲染表格到最后一页
        $.ajax({
            url: "/retirement_record/list?page=0&limit=0", // Hacked    //***********
            type: "get",
            async: false,
            dataType: "json",
            success: function(e) {
                let pageLimit = $(".layui-laypage-limits").find("select").val();
                table.reload('tabrm', {page: {curr: Math.ceil(e.count / pageLimit) } });   //***********
            }
        })
    });

})
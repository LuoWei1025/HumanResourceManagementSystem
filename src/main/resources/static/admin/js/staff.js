layui.use('table', function(){
    var table = layui.table,
    $ = layui.$;

    table.render({
        elem: '#tabl'
        ,url:'/overtime_record/user'
        ,page:true
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'otId', title: '加班序号'}
            ,{field:'overtimeDate', title: '加班日期'}
            ,{field:'overtimeHours', title: '加班时长'}
        ]]
    });

    table.render({
        elem: '#tabr'
        ,url:'/attendance_record/user'
        ,page:true
        ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
        ,cols: [[
            {field:'attId', title: '考勤序号'}
            ,{field:'attendanceDate', title: '考勤时间'}
            ,{field:'type', title: '结果类型'} //width 支持：数字、百分比和不填写。你还可以通过 minWidth 参数局部定义当前单元格的最小宽度，layui 2.2.1 新增
        ]]
    });

    //监听薪酬计算表格单元格编辑
    table.on('edit(tabsc)', function(obj){
        var field = obj.field, //得到字段
            value = obj.value, //得到修改后的值
            data = obj.data; //得到所在行所有键值
        switch (field) {
            case 'posId':    field='pos_id'; break;           //********
            case 'overtimeStep':    field='overtime_step'; break;       //********
            case 'absenceStep':     field='absence_step'; break;        //********
            case 'salaryAmount':   field='salary_amount'; break;        //********
            default:break;
        }
        //显示提示信息
        layer.msg('薪酬序号: ['+ data.salId +'] 下 [' + field + '] 字段更改为: '+ value);    //********
        //反馈修改到数据库
        $.ajax({
            url: `/salary_calculate/alter?pk=${data.salId}&field=${field}&value=${value}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
    });

    //监听部门岗位编制表格单元格编辑
    table.on('edit(tabdpm)', function(obj){     //********
        var field = obj.field, //得到字段
            value = obj.value, //得到修改后的值
            data = obj.data; //得到所在行所有键值
        switch (field) {
            case 'depId':    field='dep_id'; break;                       //********
            case 'positionId':    field='position_id'; break;       //********
            case 'positionName':field='position_name'; break;   //********
            default:break;
        }
        //显示提示信息
        layer.msg('岗位序号: ['+ data.posId +'] 下 [' + field + '] 字段更改为：'+ value);    //********
        //反馈修改到数据库
        $.ajax({
            url: `/position/alter?pk=${data.posId}&field=${field}&value=${value}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
        //重新渲染表格到当前页
        table.reload('tabdpm', {
            page: {
                curr: $(".layui-laypage-em").next().html()
            }
        });
    });

    //监听单元格编辑
    table.on('edit(tabdtm)', function(obj){
        var value = obj.value //得到修改后的值
            ,data = obj.data //得到所在行所有键值
            ,field = obj.field; //得到字段
        layer.msg('[ID: '+ data.id +'] ' + field + ' 字段更改为：'+ value);
    });

    //薪酬计算方式表格添加一行数据
    $("#addTabsc").click(function(){
        //插入一行数据到数据库
        $.ajax({
            url: "/salary_calculate/add",       //***********
            type: "post",
            async: false,
            dataType: "json",
        });
        //重新渲染表格到第一页
        table.reload('tabsc', {page: {curr: 1 } });
    });

    //岗位编制表格添加一行数据
    $("#addTabdpm").click(function() {       //***********
        //插入一行数据到数据库
        $.ajax({
            url: "/position/add",           //***********
            type: "post",
            async: false,
            dataType: "json",
        });
        //重新渲染表格到最后一页
        $.ajax({
            url: "/position/list?page=0&limit=0", // Hacked    //***********
            type: "get",
            async: false,
            dataType: "json",
            success: function(e) {
                let pageLimit = $(".layui-laypage-limits").find("select").val();
                table.reload('tabdpm', {page: {curr: Math.ceil(e.count / pageLimit) } });   //***********
            }
        })
    });

    //部门培训表格添加一行数据
    $("#addTabdtm").click(function() {           //************
        //插入一行数据到数据库
        $.ajax({
            url: "/department_train/add",           //***********
            type: "post",
            async: false,
            dataType: "json",
        });
        //重新渲染表格到最后一页
        $.ajax({
            url: "/department_train/list?page=0&limit=0", // Hacked    //***********
            type: "get",
            async: false,
            dataType: "json",
            success: function(e) {
                let pageLimit = $(".layui-laypage-limits").find("select").val();
                table.reload('tabdtm', {page: {curr: Math.ceil(e.count / pageLimit) } });   //***********
            }
        })
    });

    //监听部门培训表格单元格编辑
    table.on('edit(tabdtm)', function(obj){     //********
        var field = obj.field, //得到字段
            value = obj.value, //得到修改后的值
            data = obj.data; //得到所在行所有键值
        switch (field) {
            case 'trainName':    field='train_name'; break;     //********
            case 'trainDate':    field='train_date'; break;       //********
            case 'trainAddress':field='train_address'; break;   //********
            case 'trainDays':   field='train_days'; break;      //********
            case 'lecturer':   field='lecturer'; break;      //********
            case 'staffNum':   field='staff_num'; break;      //********
            default:break;
        }
        //显示提示信息
        layer.msg('培训序号: ['+ data.trainId +'] 下 [' + field + '] 字段更改为：'+ value);    //********
        //反馈修改到数据库
        $.ajax({
            url: `/department_train/alter?pk=${data.trainId}&field=${field}&value=${value}`,//********
            type: "post",
            async: false,
            dataType: "json"
        });
    });

});


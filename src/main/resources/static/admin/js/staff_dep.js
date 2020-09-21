function updateTable() {
    $.ajax({
        url: "/staff_department/dep", // Hacked
        type: "get",
        async: false,
        dataType: "json",
        success: function(e) {
            layui.use('form', function(){
                let form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
                form.val("perinfo", {
                    departmentId: e.departmentId,
                    depName: e.depName,
                    address: e.address,
                    contactNum: e.contactNum
                });
                form.render();
            });
        }
    });
}
//Submit
layui.use('form',function ()
{
    var form = layui.form,
        $=layui.$
    form.on('submit(ls)', function(data)
    {
        console.log(data.field);

        if (data.field['contactNum'].search('[0-9]{11}') == -1)
        {
            alert("请输入11位数字");
            return;
        }
        $.ajax({
            url: "/staff_department/add",
            data:data.field,
            type:"post",
            dataType:"json",
            success: function(data) {
                updateTable();
            }
        });
        window.location.href ='dep_info_manage.html?success';
        return false;
    });
});

var url = document.URL;
if(url.search("success")!==-1) {
    layui.use('layer', function () {
        var layer = layui.layer;
        layer.open({
            title: '提交成功'
            ,content: '<div style="padding: 10px 60px;">'+'恭喜你提交成功'+'</div>'
            ,btn: '关闭'
            ,anim: 2
            ,btnAlign: 'c' //按钮居中
            ,shade: 0 //不显示遮罩
            ,yes: function(){
                layer.closeAll();
                updateTable();
            }
        });
    })
}
else{
    updateTable();
}
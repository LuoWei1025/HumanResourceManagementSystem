    $.ajax({
        url: "/staff_info/userid", // Hacked
        type: "get",
        async: false,
        dataType: "text",
        success: function (e) {
            console.log(e);
            layui.use('form', function () {
                let form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
                form.val("perinfo", {
                    staffId: e,
                });
                form.render();
            });
        }
    });
layui.use('form', function(){
    var form = layui.form,
        $=layui.$

    form.on('submit(ls)', function(data){
        console.log(data.field);

        var i;
        for( i in data.field){//检查是否有域为空
            if(data.field[i] == "")
            {
                alert("请完整填写每一项");
                return;
            }
        }

        if(data.field['staffId'].search("[0-9]{10}") == -1)
        {
            alert("请输入10位数字教职工账号");
            return ;
        }

        $.ajax({
            url: "/quit_application/add",
            data: data.field,
            type: "post",
            dataType: "json",
            success: function(data) {
            }
        });
        window.location.href ='leave_application.html?success';
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
            }
        });
    })
}
// Render table content
function updata() {
    $.ajax({
        url: "/staff_info", // Hacked
        type: "get",
        async: false,
        dataType: "json",
        success: function (e) {
            layui.use('form', function () {
                let form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
                form.val("perinfo", {
                    staffId: e.staffId,
                    name: e.name,
                    gender: e.gender,
                    nation: e.nation,
                    politicalStatus: e.politicalStatus,
                    birthDate: e.birthDate,
                    contactNum: e.contactNum,
                    depName: e.depName,
                    positionName: e.positionName,
                    fromDate: e.fromDate,
                    toDate: e.toDate,
                    accountType: e.accountType
                });
                form.render();
            });
        }
    });
}

// Submit
layui.use('form', function(){
    var form = layui.form,
        $=layui.$

    form.on('submit(ls)', function(data){
        console.log(data.field);
        var i;
        for( i in data.field){//检查是否有域为空
            if(data.field[i] == "")
            {
                alert("请完整填写每一项")
                return;
            }
        }
        console.log((data.field['gender'] == "F" || data.field['gender'] == "M"))
        if(!(data.field['gender'] == "F" || data.field['gender'] == "M"))
        {
            alert("只允许输入F或M")
            return
        }
        if(data.field['contactNum'].search('[0-9]{11}') == -1){
            alert("请输入11位数字");
            return;
        }
        $.ajax({
            url: "/staff_info/add",
            data: data.field,
            type: "post",
            dataType: "json",
            success: function(data) {
                updata();
            }
        });
        window.location.href ='staff_info_query.html?success';
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
                updata();
            }
        });
    })
}
else{
    updata();
}


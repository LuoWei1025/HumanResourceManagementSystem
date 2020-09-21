function updateTable() {
    $.ajax({
        url: "/salary_calculate/salary_info", // Hacked
        type: "get",
        async: false,
        dataType: "json",
        success: function(e) {
            layui.use('form', function(){
                let form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
                form.val("perinfo", {
                    salary_amount: e.salaryAmount,
                    overtime_step: e.overtimeStep,
                    abscence_step: e.absenceStep,
                    totalsalary: e.salaryAmount-e.absenceStep+e.overtimeStep
                });
                form.render();
            });
        }
    });
}
updateTable();
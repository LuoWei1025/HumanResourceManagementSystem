let menu = [
    {
        name: "首页",
        icon: "&#xe68e;",
        url: "index.html",
        hidden: false,
        list: [],
    },
    {
        name: "教职工管理",
        icon: "&#xe653;",
        url: "",
        hidden: false,
        list: [
            {
                name: "教职工基本信息查询",
                url: "staff_info_query.html",
            },
            {
                name: "教职工绩效查询",
                url: "staff_performance_query.html",
            },
            {
                name: "教职工离职申请",
                url: "leave_application.html",
            },
        ],
    },
    {
        name: "薪酬管理",
        icon: "&#xe612;",
        url: "",
        hidden: false,
        list: [
            {
                name: "薪酬计算方式管理",
                url: "salary_calculate.html",
            },
            {
                name: "薪酬自助查询",
                url: "salary_query.html",
            },
        ],
    },
    {
        name: "组织机构管理",
        icon: "&#xe609;",
        url: "",
        hidden: false,
        list: [
            {
                name: "部门基本信息管理",
                url: "dep_info_manage.html",
            },
            {
                name: "部门岗位编制管理",
                url: "dep_position_manage.html",
            },
            {
                name: "培训管理",
                url: "dep_train_manage.html",
            },
        ],
    },
    {
        name: "人员异动",
        icon: "&#xe620;",
        url: "",
        hidden: false,
        list: [
            {
                name: "教职工报到",
                url: "register_manage.html",
            },
            {
                name: "校内调动管理",
                url: "posi_transfor_manage.html",
            },
            {
                name: "离校管理",
                url: "leave_manage.html",
            },
            {
                name: "退休管理",
                url: "retire_manage.html",
            },
            {
                name: "返聘管理",
                url: "rehire_manage.html",
            },
        ],
    },
    {
        name: "考勤",
        icon: "&#xe857;",
        url: "",
        hidden: false,
        list: [
            {
                name: "请假申请",
                url: "temp_leave_application.html",
            },
            {
                name: "请假管理",
                url: "temp_leave_manage.html",
            },
            {
                name: "加班管理",
                url: "overtime_manage.html",
            },
            {
                name: "缺勤管理",
                url: "abscence_manage.html",
            },
        ],
    },
    {
        name: "退出登录",
        icon: "&#xe65c;",
        url: "logout",
        list: [],
    },
];

let config = {
    webName: "SWJTU-HRMS",
    menuList: menu,
    //layer全局提示层
    layerMsg: {
        offset: "t", //坐标 (详细说明 https://www.layui.com/doc/modules/layer.html#offset)
        shade: [0.4, "#000"], //遮罩 (详细说明 https://www.layui.com/doc/modules/layer.html#shade)
    },
};

var vue = new Vue({
    el: "#app",
    data: {
        webname: config.webName,
        menu: [],
        address: [],
    },
    created: function () {
        let data = JSON.stringify(config.menuList);
        this.menu = JSON.parse(data);
        this.thisActive();
        this.thisAttr();
    },
    methods: {
        //记住收展
        onActive: function (pid, id = false) {
            let data;
            if (id === false) {
                data = this.menu[pid];

                if (data.url.length > 0) {
                    this.menu.forEach((v, k) => {
                        v.active = false;
                        v.list.forEach((v2, k2) => {
                            v2.active = false;
                        });
                    });

                    data.active = true;
                }

                data.hidden = !data.hidden;
            } else {
                this.menu.forEach((v, k) => {
                    v.active = false;
                    v.list.forEach((v2, k2) => {
                        v2.active = false;
                    });
                });

                data = this.menu[pid].list[id];
            }
            this.updateStorage();
            if (data.url.length > 0) {
                if (data.target) {
                    if (data.target == "_blank") {
                        window.open(data.url);
                    } else {
                        window.location.href = data.url;
                    }
                } else {
                    window.location.href = data.url;
                }
            }
        },

        //更新菜单缓存
        updateStorage() {
            sessionStorage.menu = JSON.stringify(this.menu);
        },
        //菜单高亮
        thisActive: function () {
            let pathname = window.location.pathname;
            let host = window.location.host;
            let pid = false;
            let id = false;
            this.menu.forEach((v, k) => {
                let url = v.url;
                if (url.length > 0) {
                    if (url[0] != "/" && url.substr(0, 4) != "http") {
                        url = "/" + url;
                    }
                }
                if (pathname == url) {
                    pid = k;
                }
                v.list.forEach((v2, k2) => {
                    let url = v2.url;

                    if (url.length > 0) {
                        if (url[0] != "/" && url.substr(0, 4) != "http") {
                            url = "/" + url;
                        }
                    }
                    if (pathname == url) {
                        pid = k;
                        id = k2;
                    }
                });
            });

            if (id !== false) {
                this.menu[pid].list[id].active = true;
            } else {
                if (pid !== false) {
                    this.menu[pid].active = true;
                }
            }

            this.updateStorage();
        },
        //当前位置
        thisAttr: function () {
            //当前位置
            let address = [
                {
                    name: "首页",
                    url: "index.html",
                },
            ];
            this.menu.forEach((v, k) => {
                v.list.forEach((v2, k2) => {
                    if (v2.active) {
                        address.push({
                            name: v.name,
                            url: "javascript:;",
                        });
                        address.push({
                            name: v2.name,
                            url: v2.url,
                        });
                        this.address = address;
                    }
                });
            });
        },
    },
});

function updateTime() {
    var now = new Date();
    var hourStr = now.getHours() < 10 ? "0" + now.getHours() : now.getHours();
    var minuteStr = now.getMinutes() < 10 ? "0" + now.getMinutes() : now.getMinutes();
    var secStr = now.getSeconds() < 10 ? "0" + now.getSeconds() : now.getSeconds();
    $("#u-time")[0].innerHTML=`${now.getFullYear()}-${now.getMonth()+1}-${now.getDate()} ${hourStr}:${minuteStr}:${secStr}`;
}

function updateWelcome() {
    // Update welcome.
    $.ajax({
        url: "/staff_info/user",
        type: "get",
        async: false,
        dataType: "text",
        success: function(e) {
            $("#u-name")[0].innerHTML=" " + e;
        }
    });
    setInterval(updateTime,"1000");
}

updateWelcome();
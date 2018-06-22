$(".control li").on("click", function() {
    if($(".page div").hasClass("content")) {
        $(".content").addClass("hidden");
        $(".content").eq($(this).index() + 1).removeClass("hidden");
    }
});

var num1, num2_1, num2_2, num3, num4_1, num4_2;

$(document).ready(function() {//默认页面提示数字
    $.ajaxSettings.async = false;
    $.get('/admin/registerSum',function(data){//获得未通过审核企业表的长度
        num1 = data.result;
    });
    $(".notice").eq(0).append(num1);

    $.get('/admin/proSum',function(data){//获得未通过审核供应表的长度
        num2_1 = data.result;
    });
    $.get('/admin/demandSum',function(data){//获得未通过审核需求表的长度
        num2_2 = data.result;
    });
    var num2 = num2_1+num2_2;
    $(".notice").eq(1).append(num2);

    $.get('/admin/entSum',function(data){//获得企业表的长度
        console.log(data);
        num3 = data.result;
    });
    $(".notice").eq(2).append(num3);
    $.get('/admin/agreeProSum',function(data){//获得供应表的长度
        num4_1 = data.result;
    });
    $.get('/admin/agreeDemandSum',function(data){//获得需求表的长度
        num4_2 = data.result;
    });
    $.ajaxSettings.async = true;
    var num4 = num4_1+num4_2;
    $(".notice").eq(3).append(num4);
});

function check_ent(entID) {//查看详细企业信息
    $(".content").addClass("hidden");
    $("#register_content").removeClass("hidden");
    $.ajax({
        type: "get",
        url: "/admin/registerContent", //企业表(未审核企业详细信息)
        data: {
            entId: entID
        },
        async:false,
        success: function(data) {
            $("#register_content .box").empty(); //清空展示效果的部分
            $("#register_content .box").append('<nav><p class="entName"><b>企业名称: </b>' + data.entName + '</p>'+
                '<p class="entID"><b>企业ID: </b>' + entID + '</p>'+
                '<p class="entCategory"><b>企业类别：</b>' + data.entCategory + '</p>'+
                '<p class="entDate"><b>注册时间：</b>' + data.entDate + '</p>'+
                '<p class="entPerson"><b>企业法人：</b>' + data.entPerson + '</p>'+
                '<p class="entSize"><b>企业规模：</b>' + data.entSize + '</p>'+
                '<p class="entPhone"><b>联系电话：</b>' + data.entPhone + '</p>'+
                '<p class="entWebsite"><b>企业官网：</b>' + data.entWebsize + '</p>'+
                '<p class="entAddress"><b>地址：</b>' + data.entAddress + '</p>'+
                '<p class="entBrief"><b>简介：</b>' + data.entBrief + '</p>'+
                '<p class="entIntroduction"><b>详细介绍：</b>' + data.entIntroduction + '</p>'+
                '<textarea id="reason1" style="width: 100%;height: 100px;" placeholder="驳回请写明理由"></textarea>'+
                '<button onclick="pass_ent(\'' + entID + '\')">通过</button>'+
                '<button onclick="reject_ent(\'' + entID + '\')">驳回</button></nav>');
        },
        error: function(error) {
        }
    });
}
//查看详细企业信息，已经通过审核的
function check_ent_agree(entID) {
    $(".content").addClass("hidden");
    $("#register_content").removeClass("hidden");
    $.ajax({
        type: "get",
        url: "/user/check", //企业表(已通过企业的详细信息)
        dataType: "json",
        data: {
            entId: entID
        },
        async:false,
        success: function(data) {
            $("#register_content .box").empty(); //清空展示效果的部分
            $("#register_content .box").append('<nav><p class="entName"><b>企业名称: </b>' + data.entName + '</p>'+
                '<p class="entID"><b>企业ID: </b>' + entID + '</p>'+
                '<p class="entCategory"><b>企业类别：</b>' + data.entCategory + '</p>'+
                '<p class="entDate"><b>注册时间：</b>' + data.entDate + '</p>'+
                '<p class="entPerson"><b>企业法人：</b>' + data.entPerson + '</p>'+
                '<p class="entSize"><b>企业规模：</b>' + data.entSize + '</p>'+
                '<p class="entPhone"><b>联系电话：</b>' + data.entPhone + '</p>'+
                '<p class="entWebsite"><b>企业官网：</b>' + data.entWebsize + '</p>'+
                '<p class="entAddress"><b>地址：</b>' + data.entAddress + '</p>'+
                '<p class="entBrief"><b>简介：</b>' + data.entBrief + '</p>'+
                '<p class="entIntroduction"><b>详细介绍：</b>' + data.entIntroduction + '</p></nav>');
        },
        error: function(error) {
            console.log(error);
        }
    });
}
//审核注册用户通过
function pass_ent(entID) {
    $.ajax({
        type: "get",
        url: "/admin/agreeRegister", //企业表(通过审核企业表)
        data: {
            entId: entID,
            reason:'已通过审核'
        },
        success: function(data) {
            //获取未通过的审核的企业用户
            get_ent();
        },
        error: function(error) {
        }
    })
}
//驳回企业注册
function reject_ent(entID) {
    if($("#reason1").val()=="") {
        alert("驳回请写上理由！");
    } else {
        alert("驳回成功！");
    }
    $.ajax({
        type: "get",
        url: "/admin/deleteRegister",
        data: {
            entId: entID,
            reason:$("#reason1").val()
        },
        async: false,
        success: function(data) {
            get_ent();
        },
        error: function(error) {
        }
    })
}
//查看已通过详细供应信息
function check_s_agree(ID) {
    if($(".page div").hasClass("content")) {
        $(".content").addClass("hidden");
        $("#sr_content").removeClass("hidden");
    }
    $.get('/admin/proContentAgree', {
            proId: ID
        },
        function(data) {
            $("#sr_content").empty(); //清空展示部分
            $("#sr_content").append('<div class="box">'+
                '<p><b>标题：</b>' + data.proTitle + '</p>'+
                '<p><b>ID:</b>' + data.proId + '</p>'+
                '<p><b>供/需：</b>供应</p>'+
                '<p><b>发布类型：</b>' + data.proType + '</p>'+
                '<p><b>发布时间：</b>' + data.proDate + '</p>'+
                '<p><b>企业邮箱:</b>' + data.entId + '</p>'+
                '<p><b>摘要：</b>' + data.proDigest + '</p>'+
                '<p><b>详细内容：</b>' + data.proContent + '</p></div>	');
        }
    )
}
//查看未通过详细供应信息
function check_s(ID) {
    if($(".page div").hasClass("content")) {
        $(".content").addClass("hidden");
        $("#sr_content").removeClass("hidden");
    }
    $.get('/admin/proContent', {
            proId: ID
        },
        function(data) {
            $("#sr_content").empty(); //清空展示部分
            $("#sr_content").append('<div class="box">'+
                '<p><b>标题：</b>' + data.proTitle + '</p>'+
                '<p><b>ID:</b>' + data.proId + '</p>'+
                '<p><b>供/需：</b>供应</p>'+
                '<p><b>发布类型：</b>' + data.proType + '</p>'+
                '<p><b>发布时间：</b>' + data.proDate + '</p>'+
                '<p><b>企业邮箱:</b>' + data.entId + '</p>'+
                '<p><b>摘要：</b>' + data.proDigest + '</p>'+
                '<p><b>详细内容：</b>' + data.proContent + '</p>'+
                '<textarea id="reason1" style="width: 100%;height: 100px;" placeholder="驳回请写明理由"></textarea>'+
                '<button onclick="pass_s(\'' + data.proId +'\',\''+data.entId+ '\')">通过</button>   '+
                '<button onclick="reject_s(\'' + data.proId +'\',\''+data.entId+ '\')">驳回</button></div>');
        }
    )
}
//查看已通过详细需求信息
function check_r_agree(ID) {
    if($(".page div").hasClass("content")) {
        $(".content").addClass("hidden");
        $("#sr_content").removeClass("hidden");
    }
    $.get('/admin/demandContentAgree', {
            demandId: ID
        },
        function(data) {
            $("#sr_content").empty(); //清空展示部分
            $("#sr_content").append('<div class="box">'+
                '<p><b>标题：</b>' + data.demandTitle + '</p>'+
                '<p class="ID"><b>ID:</b>' + data.demandId + '</p>'+
                '<p><b>供/需：</b>需求</p>'+
                '<p><b>发布类型：</b>' + data.demandType + '</p>'+
                '<p><b>发布时间：</b>' + data.demandDate + '</p>'+
                '<p><b>企业邮箱:</b>' + data.entId + '</p>'+
                '<p><b>摘要：</b>' + data.demandDigest + '</p>'+
                '<p><b>详细内容：</b>' + data.demandContent + '</p></div>	');
        }
    )
}
//查看未通过详细需求信息
function check_r(ID) {
    if($(".page div").hasClass("content")) {
        $(".content").addClass("hidden");
        $("#sr_content").removeClass("hidden");
    }
    $.get('/admin/demandContent', {
            demandId: ID
        },
        function(data) {
            $("#sr_content").empty(); //清空展示部分
            $("#sr_content").append('<div class="box">'+
                '<p><b>标题：</b>' + data.demandTitle + '</p >'+
                '<p class="ID"><b>ID:</b>' + data.demandId + '</p >'+
                '<p><b>供/需：</b>需求</p >'+
                '<p><b>发布类型：</b>' + data.demandType + '</p >'+
                '<p><b>发布时间：</b>' + data.demandDate + '</p >'+
                '<p><b>企业邮箱:</b>' + data.entId + '</p >'+
                '<p><b>摘要：</b>' + data.demandDigest + '</p >'+
                '<p><b>详细内容：</b>' + data.demandContent + '</p >'+
                '<textarea id="reason1" style="width: 100%;height: 100px;" placeholder="驳回请写明理由"></textarea>'+
                '<button onclick="pass_r(\'' + data.demandId +'\',\''+data.entId+ '\')">通过</button>  '+
                '<button onclick="reject_r(\'' + data.demandId +'\',\''+data.entId+ '\')">驳回</button></div>	');
        }
    )
}

//管理企业，用于删除指定的企业
function del_ent(ID) {
	$.post('/admin/deleteEnt', {
		entId: ID
	},function (data) {
		manage_ent();
    })
}

function del_s(ID) {
    $.post('/admin/deleteProvideAgree', {
        proId:ID
    },function (data) {
        manage_support();
    })
}

function del_r(ID) {
    $.post('/admin/deleteDemandAgree', {
        demandId: ID
    },function (data) {
        manage_require();
    })
}
//管理员通过需求
function pass_r(ID,entId) {
    $.ajax({
        type: "post",
        url: "/admin/agreeDemand",
        data: {
            entId:entId,
            demandId: ID,
            reason:'您的需求已经通过审核！！！'
        },
        async: false,
        success: function() {},
        error: function(error) {}
    });
}
//驳回需求
function reject_r(ID,entId) {
    if($("#reason1").val() == "") {
        alert("驳回请写上理由！");
    } else {
        $.ajax({
            type: "post",
            url: "/admin/deleteDemand",
            data: {
                entId:entId,
                demandId: ID,
                reason:$("#reason1").val()
            },
            async: false,
            success: function() {
                alert("驳回成功！")
            },
            error: function(error) {
            }
        })
    }
}
//通过供应审核
function pass_s(ID,entId) {
    $.ajax({
        type: "post",
        url: "/admin/agreeProvide",
        data: {
            entId:entId,
            proId: ID,
            reason:'您的供应已经通过审核！！！'
        },
        async: false,
        success: function() {},
        error: function(error) {}
    });
}

//驳回供应
function reject_s(ID,entId) {
    if($("#reason1").val()=="") {
        alert("驳回请写上理由！");
    } else {
        $.ajax({
            type: "post",
            url: "/admin/deleteProvide",
            data: {
                entId:entId,
                proId: ID,
                reason:$("#reason1").val()
            },
            async: false,
            success: alert("驳回成功！"),
            error: function(error) {}
        })

    }
}
var no_ent = 0; //全局变量
var no_support = 0; //全局变量
var no_require = 0;
var ma_ent = 0; //全局变量
var ma_support = 0; //全局变量
var ma_require = 0;

function get_ent() {
    $.ajax({
        type: "get",
        url: "/admin/register_admin", //未审核企业表
        data:{
            index:no_ent,
            length:8
        },
        dataType: "json",
        async: false,
        success: function(data) {
            console.log(data);
            $("#r_l").empty(); //清空展示效果的部分
            for(var i = 0; i < data.ent.length && i < 7 ; i++) {
                $("#r_l").append('<li><nav><span name="entID">' + data.ent[i].entId + '</span>'+
                    '<span class="entName">' + data.ent[i].entName + '</span>'+
                    '<span class="entType">' + data.ent[i].entCategory + '</span>'+
                    '<span class="time">' + data.ent[i].entDate + '</span>'+
                    '<span style="float: right;margin-right: 10px;"><button onclick="check_ent(\'' + data.ent[i].entId + '\')">查看</button></span></nav></li>');
            }
            $(".pre_ent").removeClass("hidden");
            $(".next_ent").removeClass("hidden");
            if(data.ent.length <= 7) { //根据页码（长度）选择隐藏上下页按钮
                $(".next_ent").addClass("hidden");
            }
            if(no_ent == 0) {
                $(".pre_ent").addClass("hidden");
            }
          },
        error: function(error) {
            console.log(error);
        }
    });
}
//获取未审核的供应
function get_support() {
    $.ajax({
        type: "get",
        url: "/admin/provide_admin", //未审核供应表
        data:{
            index:no_ent,
            length:8
        },
        dataType: "json",
        async: false,
        success: function(data) {
            console.log(data);
            $("#support").empty(); //清空展示效果的部分
            for(var i = 0; i < data.pro.length && i < 7 ; i++) {
                $("#support").append('<li><nav><span class="ID">' + data.pro[i].proId + '</span>'+
                    '<span class="title">' + data.pro[i].proTitle + '</span>'+
                    '<span class="entType">' + data.pro[i].proType + '</span>'+
                    '<span class="time">' + data.pro[i].proDate + '</span>'+
                    '<span style="float: right;"><button onclick="check_s(' + data.pro[i].proId + ')">查看</button></span></nav></li>');
            }
            $(".pre_support").removeClass("hidden");
            $(".next_support").removeClass("hidden");
            if(data.pro.length <= 7) { //根据页码（长度）选择隐藏上下页按钮
                $(".next_support").addClass("hidden");
            }
            if(no_support == 0) {
                $(".pre_support").addClass("hidden");
            }
        },
        error: function(error) {
        }
    });
}
//未审核的需求
function get_require() {
    $.ajax({
        type: "get",
        url: "/admin/demand_admin", //未审核需求表
        data:{
            index:no_ent,
            length:8
        },
        dataType: "json",
        async: false,
        success: function(data) {
            console.log(data);
            $("#request").empty(); //清空展示效果的部分
            for(var i = 0; i < data.demand.length && i < 7 ; i++) {
                $("#request").append('<li><nav><span class="ID">' + data.demand[i].demandId + '</span>'+
                    '<span class="title">' + data.demand[i].demandTitle + '</span>'+
                    '<span class="entType">' + data.demand[i].demandType + '</span>'+
                    '<span class="time">' + data.demand[i].demandDate + '</span>'+
                    '<span style="float: right;"><button onclick="check_r(' + data.demand[i].demandId + ')">查看</button></span></nav></li>');
            }
            $(".pre_require").removeClass("hidden");
            $(".next_require").removeClass("hidden");
            if(data.demand.length <= 7) { //根据页码（长度）选择隐藏上下页按钮
                $(".next_require").addClass("hidden");
            }
            if(no_require == 0) {
                $(".pre_require").addClass("hidden");
            }
        },
        error: function(error) {
        }
    });
}
//获取已经注册成功的企业
function manage_ent() {
    $.ajax({
        type: "get",
        url: "/admin/register", //已通过审核企业表
        data:{
            index:no_ent,
            length:8
        },
        dataType: "json",
        async: false,
        success: function(data) {
            $("#ent").empty(); //清空展示效果的部分
            for(var i = 0; i < data.ent.length && i < 7 ; i++) {
                $("#ent").append('<li><nav><span class="entID">' + data.ent[i].entId + '</span>'+
                    '<span class="entName">' + data.ent[i].entName + '</span>'+
                    '<span class="entType">' + data.ent[i].entCategory + '</span>'+
                    '<span class="time">' + data.ent[i].entDate + '</span>'+
                    '<span style="float: right;"><button onclick="del_ent(\'' + data.ent[i].entId + '\')">删除</button></span>'+
                    '<span style="float: right;"><button onclick="check_ent_agree(\'' + data.ent[i].entId + '\')">查看</button></span></nav></li>');
            }
            $(".pre_e").removeClass("hidden");
            $(".next_e").removeClass("hidden");
            if(data.ent.length <= 7) { //根据页码（长度）选择隐藏上下页按钮
                $(".next_e").addClass("hidden");
            }
            if(ma_ent == 0) {
                $(".pre_e").addClass("hidden");
            }
        },
        error: function(error) {
        }
    });
}
//获取已经通过审核的供应
function manage_support() {
    $.ajax({
        type: "get",
        url: "/admin/provide", //已通过审核供应表
        data:{
            index:no_ent,
            length:8
        },
        dataType: "json",
        async: false,
        success: function(data) {
            $("#as").empty(); //清空展示效果的部分
            for(var i = 0; i < data.pro.length && i < 7 ; i++) {
                $("#as").append('<li><nav><span class="ID">' + data.pro[i].proId + '</span>'+
                    '<span class="title">' + data.pro[i].proTitle + '</span>'+
                    '<span class="entType">' + data.pro[i].proType + '</span>'+
                    '<span class="time">' + data.pro[i].proDate + '</span>'+
                    '<span style="float: right;"><button onclick="del_s(' + data.pro[i].proId + ')">删除</button></span>'+
                    '<span style="float: right;"><button onclick="check_s_agree(' + data.pro[i].proId + ')">查看</button></span></nav></li>');
            }
            $(".pre_su").removeClass("hidden");
            $(".next_su").removeClass("hidden");
            if(data.pro.length <= 7) { //根据页码（长度）选择隐藏上下页按钮
                $(".next_su").addClass("hidden");
            }
            if(ma_support == 0) {
                $(".pre_su").addClass("hidden");
            }
        },
        error: function(error) {
        }
    });
}
//已通过审核需求
function manage_require() {
    $.ajax({
        type: "get",
        url: "/admin/demand",
        data:{
            index:no_ent,
            length:8
        },
        dataType: "json",
        async: false,
        success: function(data) {
            console.log(data);
            $("#ar").empty(); //清空展示效果的部分
            for(var i = 0; i < data.demand.length && i < 7 ; i++) {
                $("#ar").append('<li><nav><span class="ID">' + data.demand[i].demandId + '</span>'+
                    '<span class="title">' + data.demand[i].demandTitle + '</span>'+
                    '<span class="entType">' + data.demand[i].demandType + '</span>'+
                    '<span class="time">' + data.demand[i].demandDate + '</span>'+
                    '<span style="float: right;"><button onclick="del_r(' + data.demand[i].demandId + ')">删除</button></span>'+
                    '<span style="float: right;"><button onclick="check_r_agree(' + data.demand[i].demandId + ')">查看</button></span></nav></li>');
            }
            $(".pre_re").removeClass("hidden");
            $(".next_re").removeClass("hidden");
            if(data.demand.length <= 7) { //根据页码（长度）选择隐藏上下页按钮
                $(".next_re").addClass("hidden");
            }
            if(ma_require == 0) {
                $(".pre_re").addClass("hidden");
            }
        },
        error: function(error) {
            console.log(error);
        }
    });
}

function next_ent() {
    get_ent();
    no_ent += 7;
}

function pre_ent() {
    no_ent -= 7;
    get_ent();
}

function next_support() {
    get_support();
    no_ent += 7;
}

function pre_support() {
    no_ent -= 7;
    get_support();
}

function next_require() {
    get_require();
    no_ent += 7;
}

function pre_require() {
    no_ent -= 7;
    get_require();
}

function next_e() {
    manage_ent();
    ma_ent += 7;
}

function pre_e() {
    ma_ent -= 7;
    manage_ent();
}

function next_su() {
    manage_support();
    ma_support += 7;
}

function pre_su() {
    ma_support -= 7;
    manage_support();
}

function next_re() {
    manage_require();
    ma_require += 7;
}

function pre_re() {
    ma_require -= 7;
    manage_require();
}
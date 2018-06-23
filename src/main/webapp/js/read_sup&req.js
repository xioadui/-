//供需详情页
var id;
$(document).ready(function() {
	$(".title").slideToggle("slow");
	$(".basic").slideToggle("slow");
	if(window.location.search.match("supID")){
        id = $.query.get("supID");//获得ID
        loadSup(id);
    }
    else{
        id = $.query.get("demID");//获得ID
		loadDemand(id);
	}

});
//加载供应
function loadSup(Id){
    var entId;
    $.get('/provide/searchById', {
        id: Id
    }, function(data) { //供应表
        var result = data.pro[0];
        entId = result.entId;
        $(".content").empty();
        $(".content").append('<h1 class="title">' + result.proTitle +
            '</h1><div class="basic"><span id="one">供</span>' +
            ' <span id="two">' + result.proType + '</span>' +
            '<span id="three">' + result.proDate + '</span></div>' +
            '<div class="text" id="text">	<div style="float: left;margin-right: 10px;"><img src="img/左引号.png" align="bottom"></div>' + result.proContent +
            '<div style="float: right;margin-left: 10px;"><img src="img/右引号.png"></div></div>');
        loadEntInfo(entId);
        //加载评论
        loadComment(Id);
    });

}
//加载评论
function loadComment(Id) {
    $.ajax({
        type: "get",
        url: "/comment/searchCommentById", //留言表
        data: {
            id: Id
        },
        success: function (data) {
            $(".comment_message").empty();
            var result = data.result;
            var len = result.length;
            $('.comment_message').append('<h2>留言板</h2>');
            for (var i = 0; i < len; i++) {
                $('.comment_message').append('<nav class="someone"><p class="some_name">' + result[i].entName + '</p>' /*获得评论者名称*/ +
                    '<span class="some_time">' + result[i].commentDate + '</span>' /*获得留言时间*/ +
                    '<p class="some_message">' + result[i].commentContent + '</p>	</nav>');
            }
        }
    });
}
//加载企业信息
function loadEntInfo(entId){
    $.ajax({
        type: "get",
        url: "/user/queryEntById",
        data: {
            entId: entId
        },
        success: function(data) {
            var result = data.result[0];
            $('.name').empty();
            $('.phone').empty();
            $('.mail').empty();
            $('.address').empty();
            $('.link').empty();
            $('.synopsis').empty();
            $('.check').empty();
            $('.name').append(result.entName);
            /*获得企业名称*/
            $('.phone').append(result.entPhone);
            /*获得电话*/
            $('.mail').append(result.entID);
            /*获得企业邮箱*/
            $('.address').append(result.entAddress);
            /*获得企业地址*/
            $('.link').append(result.entWebsize);
            /*获得企业网址*/
            /*Website？*/
            $('.synopsis').append(result.entBreif);
            /*获得企业简介*/
            /*Website？*/
            $('.check').append('<a href="partner.html?entId=' + entId + '">查看企业</a>'); //跳转至寻找合作伙伴页面，页
            }
    });
}

//加载需求
function loadDemand(Id) {
    	$.get("/demand/searchDemandById", {
		demandId: Id
	}, function(data) { //需求表
    		var result = data.demand[0];
		$(".content").empty();
		$(".content").append('<h1 class="title">' + result.demandTitle +
			'</h1><div class="basic"><span id="one">供</span>' +
			' <span id="two">' + result.demandType + '</span>' +
			'<span id="three">' + result.demandDate + '</span></div>' +
			'<div class="text" id="text">	<div style="float: left;margin-right: 10px;"><img src="img/左引号.png" align="bottom"></div>' + result.demandContent +
			'<div style="float: right;margin-left: 10px;"><img src="img/右引号.png"></div></div>');
		loadComment(Id);
		loadEntInfo(result.entId);

	});
}


function fasong(){
    var jsonStr = sessionStorage.getItem("loginId");
    var userInfo = JSON.parse(jsonStr);
    var entId = userInfo.id;
    var entName = userInfo.name;
    var myinput=$('#con').val();
    if(myinput==""){
        alert("留言不能为空,请重新输入!");
        return;
    }
    var date=new Date();
    var year=date.getFullYear();
    var mon=date.getMonth()+1;
    var da=date.getDate();
    var h=date.getHours();
    var m=date.getMinutes();
    var mytime=year+"-"+mon+"-"+da+" "+h+":"+m;
    var src=
        '<nav class="someone">'+
        '<p class="some_name">'+
        entName+
        '</p>'+
        '<span class="some_time">'+
        mytime+
        '</span>'+
        '<p class="some_message">'+

        myinput+
        '</p>'+
        '</nav>';

    $('.comment_message').append(src);<!--插入div-->
    $.ajax({
        type: "get",
        url: "/comment/publishComment" ,
        data: {
        	id :id,
            entId:entId,
            commentDate:mytime,
            commentContent:myinput
        },
        success:function (result) {
			alert("发表评论成功！！！");
        },
        error : function(error) {
        }
    });
}

			
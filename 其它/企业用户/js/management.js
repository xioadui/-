var no_ent = 0; //全局变量
var no_support = 0; //全局变量
var no_require = 0;
var ma_ent = 0; //全局变量
var ma_support = 0; //全局变量
var ma_require = 0;


$(".control li").on("click", function() {
	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$(".content").eq($(this).index() + 1).removeClass("hidden");
	}
})

var num1,num2_1,num2_2,num2,num3,num4_1,num4_2,num4;
$(document).ready(function() {//默认页面提示数字

//	var num1 = document.getElementById("r_l").getElementsByTagName("li").length;
//	$(".notice").eq(0).append(num1);
//	var num2 = document.getElementById("support").getElementsByTagName("li").length + document.getElementById("request").getElementsByTagName("li").length;
//	$(".notice").eq(1).append(num2);
//	var num3 = document.getElementById("ent").getElementsByTagName("li").length;
//	$(".notice").eq(2).append(num3);
//	var num4 = document.getElementById("as").getElementsByTagName("li").length + document.getElementById("ar").getElementsByTagName("li").length;
//	$(".notice").eq(3).append(num4);
    num1 = 20;
	$.get(url,function(data){//获得未通过审核企业表的长度
		num1= data.length;
	});
	$(".notice").eq(0).append(num1);
	
	$.get(url,function(data){//获得未通过审核供应表的长度
		num2_1 = data.length;
	});
	$.get(url,function(data){//获得未通过审核需求表的长度
		num2_2 = data.length;
	});
	num2 = num2_1+num2_2;
	$(".notice").eq(1).append(num2);
	
	$.get(url,function(data){//获得企业表的长度
		num3 = data.length;
	});
	$(".notice").eq(2).append(num3);
	
	$.get(url,function(data){//获得供应表的长度
		num4_1 = data.length;
	});
	$.get(url,function(data){//获得需求表的长度
		num4_2 = data.length;
	});
	num4 = num4_1+num4_2;
	$(".notice").eq(3).append(num4);
})

function check_ent(entID) {//查看详细企业信息
//	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$("#register_content").removeClass("hidden");
		//		$("#register_content .box nav").remove();
//	}

	//	alert(entID);
	$.ajax({
		type: "get",
		url: "", //企业表(未审核企业表)
		dataType: "json",
		data: {
			entID: entID,
		},
		async: false,
		success: function(data) {
			$("#register_content .box").empty(); //清空展示效果的部分
			$("#register_content .box").append('<nav><p class="entName"><b>企业名称: </b>' + data.entName + '</p>');
			$("#register_content .box").append('<p class="entID"><b>企业ID: </b>' + data.entID + '</p>');
			$("#register_content .box").append('<p class="entCategory"><b>企业类别：</b>' + data.entCategory + '</p>');
			$("#register_content .box").append('<p class="entDate"><b>注册时间：</b>' + data.entDate + '</p>');
			$("#register_content .box").append('<p class="entPerson"><b>企业法人：</b>' + data.entPerson + '</p>');
			$("#register_content .box").append('<p class="entSize"><b>企业规模：</b>' + data.entSize + '</p>');
			$("#register_content .box").append('<p class="entPhone"><b>联系电话：</b>' + data.entPhone + '</p>');
			$("#register_content .box").append('<p class="entWebsite"><b>企业官网：</b>' + data.entWebsite + '</p>');
			$("#register_content .box").append('<p class="entAddress"><b>地址：</b>' + data.entAddress + '</p>');
			$("#register_content .box").append('<p class="entBrief"><b>简介：</b>' + data.entBrief + '</p>');
			$("#register_content .box").append('<p class="entIntroduction"><b>详细介绍：</b>' + data.entIntroduction + '</p>');
			$("#register_content .box").append('<button onclick="pass_ent(' + data.entID + ')">通过</button>');
			$("#register_content .box").append('<button onclick="reject_ent(' + data.entID + ')">驳回</button></nav>');
		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});
}

function pass_ent(entID) {
	$ajax({
		type: "post",
		url: "", //企业表(通过审核企业表)
		dataType: "json",
		data: {
			entID: entID,
			del: pass //这里不知道应该提交什么数据表示通过这个企业
		},
		async: false,
		success: function(data) {},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	})
}

function reject_ent(entID) {
	if($("#reason").val() == "") {
		alert("驳回请写上理由！");
	} else {

		alert("驳回成功！");
	}

	$ajax({
		type: "post",
		url: "", //
		dataType: "json",
		data: {
			entID: entID,
			del: reject //这里不知道应该提交什么数据拒绝通过这个企业
		},
		async: false,
		success: function(data) {},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	})
}

function check_s(ID) {//查看详细供应信息
	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$("#sr_content").removeClass("hidden");
		//		$("#sr_content .box").remove();
	}
	$.get(URL, {
			ID: ID,
		},
		function(data) {
			$("#sr_content").empty(); //清空展示部分
			$("#sr_content").append('<div class="box">');
			$("#sr_content").append('<p><b>标题：</b>' + data.proTitle + '</p>');
			$("#sr_content").append('<p><b>ID:</b>' + data.proId + '</p>');
			$("#sr_content").append('<p><b>供/需：</b>供应</p>');
			$("#sr_content").append('<p><b>发布类型：</b>' + data.proType + '</p>');
			$("#sr_content").append('<p><b>发布时间：</b>' + data.demandDate + '</p>');
			$("#sr_content").append('<p><b>企业邮箱:</b>' + data.entId + '</p>');
			$("#sr_content").append('<p><b>摘要：</b>' + data.demandDigest + '</p>');
			$("#sr_content").append('<p><b>详细内容：</b>' + data.demandContent + '</p>	');
			$("#sr_content").append('<button onclick="pass_s(' + data.proId + ')">通过</button>  ');
			$("#sr_content").append('<button onclick="reject_s(' + data.proId + ')">驳回</button></div>	');
		}
	)
}

function check_r(ID) {//查看详细需求信息
	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$("#sr_content").removeClass("hidden");
		//		$("#sr_content .box").remove();
	}
	$.get(URL, {
			ID: ID,
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
			'<p><b>详细内容：</b>' + data.demandContent + '</p>'+
			'<textarea id="reason1" style="width: 100%;height: 100px;" placeholder="驳回请写明理由"></textarea>'+
			'<button onclick="pass_r(' + data.demandId + ')">通过</button>  '+
			'<button onclick="reject_r(' + data.demandId + ')">驳回</button></div>	');
		}
	)
}

function del_ent(ID) {
	$.post(URL, {
		entID: ID,
		//		提交删除的企业ID
	})
}
function del_s(ID) {
	$.post(URL, {
		proId:ID,
		//		提交删除的供应ID
	})
}
function del_r(ID) {
	$.post(URL, {
		demandId: ID,
		//		提交删除的需求ID
	})
}

function pass_r(ID) {
	$.post(URL, {
		demandId: $("#sr_content .ID"),
		//		提交通过的需求ID
	})
}

function pass_s(ID) {
	$.post(URL, {
		proId: $("#sr_content .ID"),
		//		提交通过的供应ID
	})
}

function reject_r(ID) {//驳回需求
	if($("#reason1").val() == "") {
		alert("驳回请写上理由！");
	} else {
		$ajax({
			type: "post",
			url: "", //
			dataType: "json",
			data: {
				demandId: $("#sr_content .ID"),
			},
			async: false,
			success: alert("驳回成功！"),
			error: function(error) {
				console.log(error);
				//			alert("异常！");
			}
		})

	}

}

function reject_s(ID) {//驳回供应
	if($("#reason1").val() == "") {
		alert("驳回请写上理由！");
	} else {
		$ajax({
			type: "post",
			url: "", //
			dataType: "json",
			data: {
				proId: $("#sr_content .ID"),
			},
			async: false,
			success: alert("驳回成功！"),
			error: function(error) {
				console.log(error);
				//			alert("异常！");
			}
		})

	}
}


function get_ent() {
	$.ajax({
		type: "get",
		url: "", //未审核企业表
		dataType: "json",
		data:{
			index: no_ent,
			len: 8,//每次只获取8条数据
		},
		async: false,
		success: function(data) {
			$("#r_l").empty(); //清空展示效果的部分
			//只显示7条数据
			for(var i = 0; i < 7 &&i<data.length; i++) {
				$("#r_l").append('<li><nav><span class="entID" title=" '+data.entId[i]+'">' + data.entId[i] + '</span>'+
				'<span class="entName" title=" '+data.entName[i]+'">' + data.entName[i] + '</span>'+
				'<span class="entType">' + data.entCategory[i] + '</span>'+
				'<span class="time">' + data.entDate[i] + '</span>'  +
				'<span style="float: right;"><button onclick="check_ent(' + data.entId[i] + ')">查看</button></span></nav></li>');
			}
			$(".pre_ent").removeClass("hidden");
			$(".next_ent").removeClass("hidden");
			if(data.length<= 7) { //根据页码（长度）选择隐藏上下页按钮
				$(".next_ent").addClass("hidden");
			}
			if(no_ent == 0) {
				$(".pre_ent").addClass("hidden");
			}

		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});
}

function get_support() {
	$.ajax({
		type: "get",
		url: "", //未审核供应表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#support").empty(); //清空展示效果的部分
			var len = no_support + 7;
			for(var i = no_support; i < len && len <= data.length; i++) {
				$("#support").append('<li><nav><span class="ID">' + data.proId[i] + '</span>');
				$("#support").append('<span class="title">' + data.proTitle[i] + '</span>');
				$("#support").append('<span class="entType">' + data.proType[i] + '</span>');
				$("#support").append('<span class="time">' + data.proDate[i] + '</span>');
				$("#support").append('<span style="float: right;"><button onclick="check_s(' + data.proId[i] + ')">查看</button></span></nav></li>');
			}
			$(".pre_support").removeClass("hidden");
			$(".next_support").removeClass("hidden");
			if(len >= data.length) { //根据页码（长度）选择隐藏上下页按钮
				$(".next_support").addClass("hidden");
			}
			if(no_support == 0) {
				$(".pre_support").addClass("hidden");
			}
		},
		error: function(error) {
			console.log(error);
			//		alert("异常！");
		}
	});
}

function get_require() {
	$.ajax({
		type: "get",
		url: "", //未审核需求表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#request").empty(); //清空展示效果的部分
			var len = no_require + 7;
			for(var i = no_require; i < len && len <= data.length; i++) {
				$("#request").append('<li><nav><span class="ID">' + data.demandId[i] + '</span>');
				$("#request").append('<span class="title">' + data.demandTitle[i] + '</span>');
				$("#request").append('<span class="entType">' + data.demandType[i] + '</span>');
				$("#request").append('<span class="time">' + data.demandDate[i] + '</span>');
				$("#request").append('<span style="float: right;"><button onclick="check_r(' + data.demandId[i] + ')">查看</button></span></nav></li>');
			}
			$(".pre_require").removeClass("hidden");
			$(".next_require").removeClass("hidden");
			if(len >= data.length) { //根据页码（长度）选择隐藏上下页按钮
				$(".next_require").addClass("hidden");
			}
			if(no_require == 0) {
				$(".pre_require").addClass("hidden");
			}

		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});
}

function manage_ent() {
	$.ajax({
		type: "get",
		url: "", //已通过审核企业表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#ent").empty(); //清空展示效果的部分
			var len = ma_ent + 7;
			for(var i = ma_ent; i < len && len <= data.length; i++) {
				$("#ent").append('<li><nav><span class="entID">' + data.entId[i] + '</span>');
				$("#ent").append('<span class="entName">' + data.entName[i] + '</span>');
				$("#ent").append('<span class="entType">' + data.entCategory[i] + '</span>');
				$("#ent").append('<span class="time">' + data.entDate[i] + '</span>');
				$("#ent").append('<span style="float: right;margin-right: 10px;"><button onclick="del_ent(' + data.entId[i] + ')">删除</button></span>');
				$("#ent").append('<span style="float: right;margin-right: 10px;"><button onclick="check_ent(' + data.entId[i] + ')">查看</button></span></nav></li>');
			}
			$(".pre_e").removeClass("hidden");
			$(".next_e").removeClass("hidden");
			if(len >= data.length) { //根据页码（长度）选择隐藏上下页按钮
				$(".next_e").addClass("hidden");
			}
			if(ma_ent == 0) {
				$(".pre_e").addClass("hidden");
			}
		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});
}

function manage_support() {
	$.ajax({
		type: "get",
		url: "", //已通过审核供应表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#as").empty(); //清空展示效果的部分
			var len = ma_support + 7;
			for(var i = ma_support; i < len && len <= data.length; i++) {
				$("#as").append('<li><nav><span class="ID">' + data.proId[i] + '</span>');
				$("#as").append('<span class="title">' + data.proTitle[i] + '</span>');
				$("#as").append('<span class="entType">' + data.proType[i] + '</span>');
				$("#as").append('<span class="time">' + data.proDate[i] + '</span>');
				$("#as").append('<span style="float: right;"><button onclick="del_s(' + data.proId[i] + ')">删除</button></span></nav></li>');
				$("#as").append('<span style="float: right;"><button onclick="check_s(' + data.proId[i] + ')">查看</button></span></nav></li>');
			}
			$(".pre_su").removeClass("hidden");
			$(".next_su").removeClass("hidden");
			if(len >= data.length) { //根据页码（长度）选择隐藏上下页按钮
				$(".next_su").addClass("hidden");
			}
			if(ma_support == 0) {
				$(".pre_su").addClass("hidden");
			}
		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});
}

function manage_require() {
	$.ajax({
		type: "get",
		url: "", //已通过审核需求表
		dataType: "json",
		async: false,
		data:{
			index: ma_require,
			len: len = 7,
		},
		success: function(data) {
			$("#ar").empty(); //清空展示效果的部分
			var len = ma_require + 7;
			for(var i = ma_require; i < len && len <= data.length; i++) {
				$("#ar").append('<li><nav><span class="ID">' + data.demandId[i] + '</span>');
				$("#ar").append('<span class="title">' + data.demandTitle[i] + '</span>');
				$("#ar").append('<span class="entType">' + data.demandType[i] + '</span>');
				$("#ar").append('<span class="time">' + data.demandDate[i] + '</span>');
				$("#ar").append('<span style="float: right;"><button onclick="del_r(' + data.demandId[i] + ')">删除</button></span></nav></li>');
				$("#ar").append('<span style="float: right;"><button onclick="check_r(' + data.demandId[i] + ')">查看</button></span></nav></li>');
			}
			$(".pre_re").removeClass("hidden");
			$(".next_re").removeClass("hidden");
			if(len >= data.length) { //根据页码（长度）选择隐藏上下页按钮
				$(".next_re").addClass("hidden");
			}
			if(ma_require == 0) {
				$(".pre_re").addClass("hidden");
			}
		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
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

$(document).ready(function() {
	//	$(".pre_ent").addClass("hidden");
	get_ent();
	get_support();
	get_require();
	manage_ent();
	manage_support();
	manage_require();
})
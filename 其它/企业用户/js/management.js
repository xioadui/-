$(".control li").on("click", function() {
	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$(".content").eq($(this).index() + 1).removeClass("hidden");
	}
})

$(document).ready(function() {
	

	$.ajax({
		type: "get",
		url: "", //未审核企业表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#r_l").empty();//清空展示效果的部分
			var len = data.length;
			for(var i = 0; i < len ; i++){
				$("#r_l").append('<li><nav><span name="entID">' + data.entId[i] + '</span>');
				$("#r_l").append('<span class="entName">' + data.entName[i] + '</span>');
				$("#r_l").append('<span class="entType">' + data.entCategory[i] + '</span>');
				$("#r_l").append('<span class="time">' + data.entDate[i] + '</span>');
				$("#r_l").append('<span style="float: right;"><button onclick="check_ent(' +  data.entId[i] + ')">查看</button></span></nav></li>');
			}
			
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	});
	$.ajax({
		type: "get",
		url: "", //未审核供应表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#support").empty();//清空展示效果的部分
			var len = data.length;
			for(var i = 0; i < len ; i++){
				$("#support").append('<li><nav><span class="ID">' + data.proId[i] + '</span>');
				$("#support").append('<span class="title">' + data.proTitle[i] + '</span>');
				$("#support").append('<span class="entType">' + data.proType[i] + '</span>');
				$("#support").append('<span class="time">' + data.proDate[i] + '</span>');
				$("#support").append('<span style="float: right;"><button onclick="check_s(' +  data.proId[i]  + ')">查看</button></span></nav></li>');
			}
			
		},
		error: function(error) {
				console.log(error);
//		alert("异常！");
		}
	});
	$.ajax({
		type: "get",
		url: "", //未审核需求表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#request").empty();//清空展示效果的部分
			var len = data.length;
			for(var i = 0; i < len ; i++){
				$("#request").append('<li><nav><span class="ID">' + data.demandId[i] + '</span>');
				$("#request").append('<span class="title">' + data.demandTitle[i] + '</span>');
				$("#request").append('<span class="entType">' + data.demandType[i] + '</span>');
				$("#request").append('<span class="time">' + data.demandDate[i] + '</span>');
				$("#request").append('<span style="float: right;"><button onclick="check_r(' + data.demandId[i] + ')">查看</button></span></nav></li>');
			}
			
			
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	});
	$.ajax({
		type: "get",
		url: "", //已通过审核企业表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#ent").empty();//清空展示效果的部分
			var len = data.length;
			for(var i = 0 ; i < len ; i++){
				$("#ent").append('<li><nav><span class="entID">' + data.entId[i] + '</span>');
				$("#ent").append('<span class="entName">' + data.entName[i] + '</span>');
				$("#ent").append('<span class="entType">' + data.entCategory[i] + '</span>');
				$("#ent").append('<span class="time">' + data.entDate[i] + '</span>');
				$("#ent").append('<span style="float: right;"><button onclick="del_ent(' + data.entId[i] + ')">删除</button></span></nav></li>');
				$("#ent").append('<span style="float: right;"><button onclick="check_ent(' + data.entId[i] + ')">查看</button></span></nav></li>');
			}
			
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	});
	$.ajax({
		type: "get",
		url: "", //已通过审核供应表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#as").empty();//清空展示效果的部分
			var len = data.length;
			for(var i = 0 ; i < len ; i++){
				$("#as").append('<li><nav><span class="ID">' + data.proId[i] + '</span>');
				$("#as").append('<span class="title">' + data.proTitle[i] + '</span>');
				$("#as").append('<span class="entType">' + data.proType[i] + '</span>');
				$("#as").append('<span class="time">' + data.proDate[i] + '</span>');
				$("#as").append('<span style="float: right;"><button onclick="del(' + data.proId[i] + ')">删除</button></span></nav></li>');
				$("#as").append('<span style="float: right;"><button onclick="check_s(' + data.proId[i] + ')">查看</button></span></nav></li>');
			}
			
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	});
	$.ajax({
		type: "get",
		url: "", //已通过审核需求表
		dataType: "json",
		async: false,
		success: function(data) {
			$("#ar").empty();//清空展示效果的部分
			var len = data.length;
			for(var i = 0 ; i < len ; i++){
				$("#ar").append('<li><nav><span class="ID">' + data.demandId[i] + '</span>');
				$("#ar").append('<span class="title">' + data.demandTitle[i] + '</span>');
				$("#ar").append('<span class="entType">' + data.demandType[i] + '</span>');
				$("#ar").append('<span class="time">' + data.demandDate[i] + '</span>');
				$("#ar").append('<span style="float: right;"><button onclick="del(' + data.demandId[i] + ')">删除</button></span></nav></li>');
				$("#ar").append('<span style="float: right;"><button onclick="check_r(' + data.demandId[i] + ')">查看</button></span></nav></li>');
			}
			
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	});
	var num1 = document.getElementById("r_l").getElementsByTagName("li").length;
	$(".notice").eq(0).append(num1);
	var num2 = document.getElementById("support").getElementsByTagName("li").length + document.getElementById("request").getElementsByTagName("li").length;
	$(".notice").eq(1).append(num2);
	var num3 = document.getElementById("ent").getElementsByTagName("li").length;
	$(".notice").eq(2).append(num3);
	var num4 = document.getElementById("as").getElementsByTagName("li").length + document.getElementById("ar").getElementsByTagName("li").length;
	$(".notice").eq(3).append(num4);
})

function check_ent(entID) {
	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$("#register_content").removeClass("hidden");
		//		$("#register_content .box nav").remove();
	}

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
			$("#register_content .box").empty();//清空展示效果的部分
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
			$("#register_content .box").append('<button onclick="pass_ent('+data.entID+')">通过</button>');
			$("#register_content .box").append('<button onclick="reject_ent('+data.entID+')">驳回</button></nav>');
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	});
}
function pass_ent(entID){
	$ajax({
		type: "post",
		url: "", //企业表(通过审核企业表)
		dataType: "json",
		data: {
			entID: entID,
			del: pass//这里不知道应该提交什么数据表示通过这个企业
		},
		async: false,
		success: function(data) {
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	})
}
function reject_ent(entID){
	$ajax({
		type: "post",
		url: "", //
		dataType: "json",
		data: {
			entID: entID,
			del: reject//这里不知道应该提交什么数据表示通过这个企业
		},
		async: false,
		success: function(data) {
		},
		error: function(error) {
			console.log(error);
//			alert("异常！");
		}
	})
}


function check_s(ID) {
	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$("#sr_content").removeClass("hidden");
		//		$("#sr_content .box").remove();
	}
	$.get(URL, {
			ID: ID,
		},
		function(data) {
			$("#sr_content").empty();//清空展示部分
			$("#sr_content").append('<div class="box">');
			$("#sr_content").append('<p><b>标题：</b>' + data.proTitle + '</p>');
			$("#sr_content").append('<p><b>ID:</b>' + data.proId + '</p>');
			$("#sr_content").append('<p><b>供/需：</b>供应</p>'); 
			$("#sr_content").append('<p><b>发布类型：</b>' + data.proType + '</p>');
			$("#sr_content").append('<p><b>发布时间：</b>' + data.demandDate + '</p>');
			$("#sr_content").append('<p><b>企业邮箱:</b>' + data.entId + '</p>');
			$("#sr_content").append('<p><b>摘要：</b>' + data.demandDigest + '</p>');
			$("#sr_content").append('<p><b>详细内容：</b>' + data.demandContent + '</p></div>	');
			$("#sr_content").append('<button onclick="pass_s(' +data.proId+')">通过</button>  ');
			$("#sr_content").append('<button onclick="reject_s('  +data.proId+')">驳回</button>	');
		}
	)
}

function check_r(ID) {
	if($(".page div").hasClass("content")) {
		$(".content").addClass("hidden");
		$("#sr_content").removeClass("hidden");
		//		$("#sr_content .box").remove();
	}
	$.get(URL, {
			ID: ID,
		},
		function(data) {
			$("#sr_content").empty();//清空展示部分
			$("#sr_content").append('<div class="box">');
			$("#sr_content").append('<p><b>标题：</b>' + data.demandTitle + '</p>');
			$("#sr_content").append('<p class="ID"><b>ID:</b>' + data.demandId + '</p>');
			$("#sr_content").append('<p><b>供/需：</b>需求</p>'); 
			$("#sr_content").append('<p><b>发布类型：</b>' + data.demandType + '</p>');
			$("#sr_content").append('<p><b>发布时间：</b>' + data.demandDate + '</p>');
			$("#sr_content").append('<p><b>企业邮箱:</b>' + data.entId + '</p>');
			$("#sr_content").append('<p><b>摘要：</b>' + data.demandDigest + '</p>');
			$("#sr_content").append('<p><b>详细内容：</b>' + data.demandContent + '</p></div>	');
			$("#sr_content").append('<button onclick="pass_r(' +data.demandId+')">通过</button>  ');
			$("#sr_content").append('<button onclick="reject_r('  +data.demandId+')">驳回</button>	');
		}
	)
}

function del_ent(ID) {
	$.post(URL, {
		entID: $("#sr_content .entID"),
		//		提交删除的企业ID
	})
}
function pass_r(ID) {
	$.post(URL, {
		entID: $("#sr_content .ID"),
		//		提交通过的需求ID
	})
}
function pass_s(ID) {
	$.post(URL, {
		entID: $("#sr_content .ID"),
		//		提交通过的供应ID
	})
}
function reject_r(ID) {
	$.post(URL, {
		entID: $("#sr_content .ID"),
		//		提交不通过的需求ID
	})
}
function reject_s(ID) {
	$.post(URL, {
		entID: $("#sr_content .ID"),
		//		提交不通过的供应ID
	})
}

//$(document).ready(function() {
//	var div = $(".guide ul li");
//	div.animate({
//		fontSize: '17px'
//	}, "slow");
//});
//
//$(document).ready(function() {
//	$(".title").slideToggle("slow");
//	$(".basic").slideToggle("slow");
//});
//
//$(document).ready(function() {
//	$.get(URL, function(data) {/*查询需求表*/
//		                $('.content').empty();
//						$('.content h1').append('<h1>'+data.demandTitle+'</h1>');/*获得需求信息名称*/
//						$('.content h1').append('<nav><span>'+data.demandType+'</span><span>' +data.demandDate+'</span><span>' +data.entName+'</span></nav>');/*获得供需类型，时间，公司名称*/
//						$(".content h1").append('<div>'+data.demandDigest+'</div>');/*需求摘要*/
//						
//					})
//	$.get(URL, function(data) {/*查询供应表*/
//		                $('.content').empty();
//						$('.content h1').append('<h1>'+data.proTitle+'</h1>');/*获得供需信息名称*/
//						$('.content h1').append('<nav><span>'+data.proType+'</span><span>' +data.proDate+'</span><span>' +data.entName+'</span></nav>');/*获得供需类型，时间，公司名称*/
//						$(".content h1").append('<div>'+data.proDigest+'</div>');/*供应摘要*/
//						
//					})
//});
//
//$(".submit").on("click", function() {
//	$.post('url', {
//			comment: $("#con").val(),
//	});
//})
//
////
////$(document).ready(function() {
////	$(".title").slideToggle("slow");
////	$(".basic").slideToggle("slow");
////});

$(document).ready(function() {
	$.get(URL, function(data) {
		$('.content h1').append(title); /*获得供需信息标题*/
	})
});

$(".sub").on("click", function() {
	$.post('url', {
		comment: $("#input").val(),
	});
})

//页面加载完成后，显示供需信息
$(document).ready(function() {
	search();
});

//填充数据
function appendSup&Req( id,title, type, date, entName,  digest,content) {
	var sr = '<div class="sup&req">' +
		'<a href="sup&req.html?id=' + id + '"><h1>' + title + '</h1></a>' +
		'<nav><span>' + type + '</span><span>' + date + '</span></nav>' +
		'</span><span>' + entName + '</span></nav>' + '<div>' + digest + '</div>' 
		+'</div>';
	
	$('.content').append(sr);
}

//			<!--点击上一页的调用的方法-->
function last() {
	if(index >= 10)
		index = index - length;
	search();
}

<!--点击下一页调用的方法-->
function next() {
	index = index + length;
	search();
}
//起始的索引
var index = 0;
//获取数据的长度
var length = 10;

var condition = "";
<!--点击搜索调用的方法-->
function search() {
	var type = $('#type').val().trim();
	var condition1 = $('#condition').val().trim();
	if(condition != condition1) {
		//					<!--对起始的索引置0-->
		index = 0;
		condition = condition1;
	}
	if(condition1.length <= 0 && condition.length > 0) {
		alert("请输入查询条件");
		return;
	}
	$('#content').html("")
	var requestUrl = "";
	if(condition.length <= 0) {
		//没有输入任何查询条件时
		requestUrl = "/inf/getAllInfo";
	}else if(type == "供应") {
		requestUrl = "/inf/queryByproType";
	}else if(type == "需求") {
		requestUrl = "/inf/queryBydemandType";
	}
	var htmlObj = $.ajax({
		type: "POST",
		url: requestUrl,
		data: {
			condition: condition1,
			index: index,
			length: length
		},
		success: function(data) {
			var result = data.inf;
			for(i = 0; i < result.length; i++) {
				appendNews(result[i].id, result[i].title, result[i].type, result[i].content, result[i].date, result[i].digest);
			}
		},
		error: function() {}
	});
}

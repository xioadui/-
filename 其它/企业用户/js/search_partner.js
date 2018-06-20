$(document).ready(function() {
	$.get(URL, function(data) {
		$('.content h1').append(title); /*获得企业名称*/
	})
});

$(".sub").on("click", function() {
	$.post('url', {
		comment: $("#input").val(),
	});
})

//页面加载完成后，显示资讯
$(document).ready(function() {
	search();
});

//填充数据
function appendPartner(entId, entName, entCategory, entPhone, digest) {
	var sr = '<div class="new">' +
		'<a href="enterpriseinf.html?id=' + entId + '"><h1>' + entName + '</h1></a>' +
		'<nav><span>' + entCategory + '</span><span>' + entPhone + '</span></nav>' +
		'<div>' + digest + '</div>' +
		'</div>';
	
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

	var htmlObj = $.ajax({
		type: "POST",
		url: requestUrl,
		data: {
			condition: condition1,
			index: index,
			length: length
		},
		success: function(data) {
			var result = ent.inf;
			for(i = 0; i < result.length; i++) {
				appendNews(result[i].entId, result[i].entName, result[i].entCategory, result[i].entPhone, result[i].entBrief);
			}
		},
		error: function() {}
	});
}

//起始的索引
var index = 0;
$(document).ready(function() {
	search();
});

//<!--点击搜索调用的方法-->
function search() {
    $('.content').empty();
	$.ajax({
		type: "post",
		url: "/user/searchEnt", //企业表(通过审核企业表)
		dataType: "json",
		data: {
			condition:$("#input").val(),
			index:index,
			length:5
		},
		async: false,
		success: function(data) {
			var result = data.result;
			for(var i=0;i<result.length;i++){
				var sr = '<div class="new">' +
		'<a href="/partner.html?entId=' + result[i].entId + '"><h1>' + result[i].entName + '</h1></a>' +
		'<nav><span>' + result[i].entCategory + '</span><span>' + result[i].entPhone + '</span></nav>' +
		'<div>' + result[i].entBrief + '</div>' +
		'</div>';
	$('.content').append(sr);
	}
	}, error: function(error) {}
	})
}

$("#pre_page").on("click",function(){
	index = index-5;
	search();
	
});

$("#next_page").on("click",function(){
    index = index+5;
	search();
});

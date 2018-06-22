$(document).ready(function(){
	var name = $.query.get("indTitle");//获得行业数据标题
	$.ajax({
			type: "get",
			url: "", //行业数据表
			dataType: "json",
			data:{
				infTitle: name,
			},
			async: false,
			success: function(data) {
				$(".news_content").empty();
				$(".news_content h1").append('<h1>'+data.indTitle+'</h1>');
				$(".news_content h1").append('<nav><span>'+data.indType+'</span><span>' +data.indDate+'</span></nav>');
				$(".news_content h1").append('<div>'+data.indContent+'</div>');
			},
			error: function(error) {
				console.log(error);
				//			alert("异常！");
			}
		});
});

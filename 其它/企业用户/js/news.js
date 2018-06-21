$(document).ready(function(){
	var name = $.query.get("infTitle");//获得资讯标题
	$.ajax({
			type: "get",
			url: "", //资讯表
			dataType: "json",
			data:{
				infTitle: name
			},
			async: false,
			success: function(data) {
				$(".news_content").empty();
				$(".news_content").append('<h1>'+data.infTitle+'</h1>');
				$(".news_content").append('<nav><span>'+data.infType+'</span><span>' +data.infDate+'</span></nav>');
				$(".news_content").append('<div>'+data.infContent+'</div>');
			},
			error: function(error) {
				console.log(error);
				//			alert("异常！");
			}
		});
})




$(document).ready(function(){
	var name = $.query.get("infTitle");//获得企业名称
	$.ajax({
			type: "get",
			url: "", //企业表
			dataType: "json",
			data:{
				infTitle: name
			},
			async: false,
			success: function(data) {
				$(".news_content").empty();
				$(".news_content h1").append('<h1>'+data.entName+'</h1>');
				$(".news_content h1").append('<div>'+data.entCategory+'</div>');
				$(".news_content h1").append('<div>'+data.entPerson+'</div>');
				$(".news_content h1").append('<div>'+data.entSize+'</div>');
				$(".news_content h1").append('<div>'+data.entAddress+'</div>');
				$(".news_content h1").append('<div>'+data.entPhone+'</div>');
				$(".news_content h1").append('<div>'+data.entWebsize+'</div>');
				$(".news_content h1").append('<div>'+data.entDate+'</div>');
				$(".news_content h1").append('<div>'+data.entIntroduction+'</div>');
			},
			error: function(error) {
				console.log(error);
				//			alert("异常！");
			}
		});
})


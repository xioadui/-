$(document).ready(function() {
	var div = $(".guide ul li");
	div.animate({
		fontSize: '17px'
	}, "slow");
});

$(document).ready(function() {
	$(".title").slideToggle("slow");
	$(".basic").slideToggle("slow");
});

$(document).ready(function() {
	$.get(URL, function(data) {
		$('.content h1').empty();
		$('.basic #one').empty();
		$('.basic #two').empty();
		$('.basic #three').empty(); 
		$('.text').empty(); 
		$('.content h1').append(title); /*获得供需标题*/
		$('.basic #one').append(s_r); /*获得供/需*/
		$('.basic #two').append(type); /*获得类别*/
		$('.basic #three').append(time); /*获得发布时间*/
		$('.text').append(text); /*获得供需详细描述*/
	})
});

$(document).ready(function() {

	$.ajax({
		type: "get",
		url: "", //留言表
		dataType: "json",
		async: false,
		success: function(data) {
			$(".comment_message").empty();
			var len = data.length;
			$('.comment_message').append('<h2>留言板</h2>');
			for(var i = 0; i < len; i++) {
				$('.comment_message').append('<nav class="someone"><p class="some_name">' + data.entName[i] + '</p>'); /*获得评论者名称*/
				$('.comment_message').append('<span class="some_time">' + data.commentDate[i] + '</span>'); /*获得留言时间*/
				$('.comment_message').append('<p class="some_message">' + data.commentContent[i] + '</p>	</nav>'); /*获得留言内容*/
			}
		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});

	$(document).ready(function() {
		var entId = $.query.get("entId");
		$.get(URL, {entId: entId}, function(data){
			$('.name').empty();
			$('.phone').empty();
			$('.mail').empty();
			$('.address').empty();
			$('.link').empty();
			$('.synopsis').empty();
			$('.check').empty();
			$('.name').append(data.entName); /*获得企业名称*/
			$('.phone').append(data.entPhone); /*获得电话*/
			$('.mail').append(data.entID); /*获得企业邮箱*/
			$('.address').append(data.entAddress); /*获得企业地址*/
			$('.link').append(data.entWebsize); /*获得企业网址*/ /*Website？*/
			$('.synopsis').append(data.entBreif); /*获得企业简介*/ /*Website？*/
			$('.check').append('<a href="find_partner.html?entId=' + entId + '">查看企业</a>');//跳转至寻找合作伙伴页面，页内跳转至此企业
		});
	});

	$(".sub").on("click", function() {
		$.post('url', {
			comment: $("#con").val(),
			location.href = "read_sup&req.html",
		});
	})
})
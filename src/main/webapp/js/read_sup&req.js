//20180622修改-未整合

$(document).ready(function() {
	$(".title").slideToggle("slow");
	$(".basic").slideToggle("slow");
});

$(document).ready(function() {
	var Id = $.query.get("supID");//获得供应ID
	var entId = $.query.get("entId");
	$.get(URL, {
		proId: Id
	}, function(data) { //供应表
		$(".content").empty();
		$(".content").append('<h1 class="title">' + data.proTitle +
			'</h1><div class="basic"><span id="one">供</span>' +
			' <span id="two">' + data.proType + '</span>' +
			'<span id="three">' + data.proDate + '</span></div>' +
			'<div class="text" id="text">	<div style="float: left;margin-right: 10px;"><img src="img/左引号.png" align="bottom"></div>' + data.proContent +
			'<div style="float: right;margin-left: 10px;"><img src="img/右引号.png"></div></div>');
	});

	$.ajax({
		type: "get",
		url: "", //留言表
		data: {
			proId: Id
		},
		dataType: "json",
		async: false,
		success: function(data) {
			$(".comment_message").empty();
			var len = data.length;
			$('.comment_message').append('<h2>留言板</h2>');
			for(var i = 0; i < len; i++) {
				$('.comment_message').append('<nav class="someone"><p class="some_name">' + data.entName[i] + '</p>' /*获得评论者名称*/ +
					'<span class="some_time">' + data.commentDate[i] + '</span>' /*获得留言时间*/ +
					'<p class="some_message">' + data.commentContent[i] + '</p>	</nav>'); /*获得留言内容*/

			}
		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});
	
	
	$.get(URL, {
				entId: entId
			}, function(data) {
				$('.name').empty();
				$('.phone').empty();
				$('.mail').empty();
				$('.address').empty();
				$('.link').empty();
				$('.synopsis').empty();
				$('.check').empty();
				$('.name').append(data.entName);
				/*获得企业名称*/
				$('.phone').append(data.entPhone);
				/*获得电话*/
				$('.mail').append(data.entID);
				/*获得企业邮箱*/
				$('.address').append(data.entAddress);
				/*获得企业地址*/
				$('.link').append(data.entWebsize);
				/*获得企业网址*/
				/*Website？*/
				$('.synopsis').append(data.entBreif);
				/*获得企业简介*/
				/*Website？*/
				$('.check').append('<a href="find_partner.html?entId=' + entId + '">查看企业</a>'); //跳转至寻找合作伙伴页面，页内跳转至此企业
			});
			
			
	$(".sub").on("click", function() {
				$.post('url', {//留言表
					comment: $("#con").val(),
					location: href = "read_sup&req.html？supID="+Id+" '&entId=' "+entId+" ' "
				})
			});
			
})

$(document).ready(function() {
	var Id = $.query.get("reqID");//获得需求ID
	var entId = $.query.get("entId");
	$.get(URL, {
		proId: Id
	}, function(data) { //需求表
		$(".content").empty();
		$(".content").append('<h1 class="title">' + data.demandTitle +
			'</h1><div class="basic"><span id="one">供</span>' +
			' <span id="two">' + data.demandType + '</span>' +
			'<span id="three">' + data.demandDate + '</span></div>' +
			'<div class="text" id="text">	<div style="float: left;margin-right: 10px;"><img src="img/左引号.png" align="bottom"></div>' + data.demandContent +
			'<div style="float: right;margin-left: 10px;"><img src="img/右引号.png"></div></div>');
	})

	$.ajax({
		type: "get",
		url: "", //留言表
		data: {
			proId: Id
		},
		dataType: "json",
		async: false,
		success: function(data) {
			$(".comment_message").empty();
			var len = data.length;
			$('.comment_message').append('<h2>留言板</h2>');
			for(var i = 0; i < len; i++) {
				$('.comment_message').append('<nav class="someone"><p class="some_name">' + data.entName[i] + '</p>' /*获得评论者名称*/ +
					'<span class="some_time">' + data.commentDate[i] + '</span>' /*获得留言时间*/ +
					'<p class="some_message">' + data.commentContent[i] + '</p>	</nav>'); /*获得留言内容*/

			}
		},
		error: function(error) {
			console.log(error);
			//			alert("异常！");
		}
	});
	
	$.get(URL, {
				entId: entId
			}, function(data) {
				$('.name').empty();
				$('.phone').empty();
				$('.mail').empty();
				$('.address').empty();
				$('.link').empty();
				$('.synopsis').empty();
				$('.check').empty();
				$('.name').append(data.entName);
				/*获得企业名称*/
				$('.phone').append(data.entPhone);
				/*获得电话*/
				$('.mail').append(data.entID);
				/*获得企业邮箱*/
				$('.address').append(data.entAddress);
				/*获得企业地址*/
				$('.link').append(data.entWebsize);
				/*获得企业网址*/
				/*Website？*/
				$('.synopsis').append(data.entBreif);
				/*获得企业简介*/
				/*Website？*/
				$('.check').append('<a href="find_partner.html?entId=' + entId + '">查看企业</a>'); //跳转至寻找合作伙伴页面，页内跳转至此企业
			});
	
	$(".sub").on("click", function() {
				$.post('url', {//留言表
					comment: $("#con").val(),
					location: href = "read_sup&req.html？reqID="+Id+" '&entId=' "+entId+" ' "
				})
			});
})



			
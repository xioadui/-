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
						$('.content h1').append(title);/*获得供需标题*/
						$('.basic #one').append(s_r);/*获得供/需*/
						$('.basic #two').append(type);/*获得类别*/
						$('.basic #three').append(time);/*获得发布时间*/
						$('.text').append(text);/*获得供需详细描述*/
					})
});

$(document).ready(function() {
	$.get(URL, function(data) {
						$('.comment_message').append('<nav class="someone"><p class="some_name">' + entName+'</p>');/*获得评论者名称*/
						$('.comment_message').append('<span class="some_time">'+commentDate+'</span>');/*获得留言时间*/
						$('.comment_message').append('<p class="some_message">'+commentContent+'</p>	</nav>');/*获得留言内容*/
					})
});

$(document).ready(function() {
	$.get(URL, function(data) {
						$('.name').append(entName);/*获得企业名称*/
						$('.phone').append(entPhone);/*获得电话*/
						$('.mail').append(entID);/*获得企业邮箱*/
						$('.address').append(entAddress);/*获得企业地址*/
						$('.link').append(entWebsize);/*获得企业网址*//*Website？*/
						$('.synopsis').append(entBreif);/*获得企业简介*//*Website？*/
						$('.check').append('<a href="'+lll +'>查看企业</a>' );
					})
});

$(".sub").on("click", function() {
	$.post('url', {
			comment: $("#con").val(),
	});
})
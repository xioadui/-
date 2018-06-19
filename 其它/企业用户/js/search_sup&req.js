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
						$('.basic #one').append(type);/*获得供需类别*/
						$('.basic #two').append(time);/*获得发布时间*/
						$('.text').append(text);/*获得供需详细描述*/
					})
});

$(".sub").on("click", function() {
	$.post('url', {
			comment: $("#con").val(),
	});
})

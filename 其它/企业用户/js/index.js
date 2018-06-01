$(".guide li").mouseenter(function() {
			if(!$(this).hasClass(".active")) {
				$(".active").removeClass("active");
				$(this).addClass("active");
			}
		})

$(".fun_list li").mouseenter(function() {
			if(!$(this).hasClass(".active")) {
				$(".active").removeClass("active");
				$(this).addClass("active");
				$(".cont div").removeClass("showed");
				$(".cont div").eq($(this).index()).addClass("showed");
				
			}
		})

$(document).ready(function(){
    var div=$(".guide li");   
    div.animate({fontSize:'17px'},"slow");
});

$(".info").hover(function() {
	$(".info h3").animate({fontSize:'5vw'},"fast");
});
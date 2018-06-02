$(".guide li").mouseenter(function() {
			if(!$(this).hasClass(".active")) {
				$(".active").removeClass("active");
				$(this).addClass("active");
			}
		})

$(".func1 li").mouseenter(function() {
			if(!$(this).hasClass(".active")) {
				$(".active").removeClass("active");
				$(this).addClass("active");
				$("#cont1 div").removeClass("showed");
				$("#cont1 div").eq($(this).index()).addClass("showed");
				
			}
		})

$(".func2 li").mouseenter(function() {
			if(!$(this).hasClass(".active")) {
				$(".active").removeClass("active");
				$(this).addClass("active");
				$("#cont2 div").removeClass("showed");
				$("#cont2 div").eq($(this).index()).addClass("showed");
				
			}
		})

$(document).ready(function(){
    var div=$(".guide li");   
    div.animate({fontSize:'17px'},"slow");
});

$(document).ready(function() {
	$.get(URL,  {
					category: '医疗医药保健',
				},
				function(data) {
						$('#cont1 #tab1 h4').append(infTitle);/*获得资讯名称*/
						$('#cont1 #tab1 p').append(infDigeat+'...');/*获得资讯摘要*/
						$('#cont2 #tab1 h4').append(indTitle);/*获得行业数据名称*/
						$('#cont2 #tab1 p').append(infDigeat+'...');/*获得行业数据摘要*/
					})
	$.get(URL,  {
					category: 'IT与通讯',
				},
				function(data) {
						$('#cont1 #tab2 h4').append(infTitle);/*获得资讯名称*/
						$('#cont1 #tab2 p').append(infDigeat+'...');/*获得资讯摘要*/
						$('#cont2 #tab2 h4').append(indTitle);/*获得行业数据名称*/
						$('#cont2 #tab2 p').append(infDigeat+'...');/*获得行业数据摘要*/
					})
	$.get(URL,  {
					category: '机械电子',
				},
				function(data) {
						$('#cont1 #tab3 h4').append(infTitle);/*获得资讯名称*/
						$('#cont1 #tab3 p').append(infDigeat+'...');/*获得资讯摘要*/
						$('#cont2 #tab3 h4').append(indTitle);/*获得行业数据名称*/
						$('#cont2 #tab3 p').append(infDigeat+'...');/*获得行业数据摘要*/
					})
	$.get(URL,  {
					category: '车辆交通',
				},
				function(data) {
						$('#cont1 #tab4 h4').append(infTitle);/*获得资讯名称*/
						$('#cont1 #tab4 p').append(infDigeat+'...');/*获得资讯摘要*/
						$('#cont2 #tab4 h4').append(indTitle);/*获得行业数据名称*/
						$('#cont2 #tab4 p').append(infDigeat+'...');/*获得行业数据摘要*/
					})
	$.get(URL,  {
					category: '能源矿产',
				},
				function(data) {
						$('#cont1 #tab5 h4').append(infTitle);/*获得资讯名称*/
						$('#cont1 #tab5 p').append(infDigeat+'...');/*获得资讯摘要*/
						$('#cont2 #tab5 h4').append(indTitle);/*获得行业数据名称*/
						$('#cont2 #tab5 p').append(infDigeat+'...');/*获得行业数据摘要*/
					})
});

$(document).ready(function(){
//	如果用户已登录,将span标签加入welcome类
//隐藏登陆/注册按钮
//显示欢迎信息
//	浏览供需/发布供需/合作伙伴可正常跳转至相应的页面
//	否则跳转至登录页
   if($(".guide span").hasClass("welcome")) {	
   	$("#login").addClass("hidden");
	$("#register").addClass("hidden");
	$("#findsr").append('<a href="search_sup&req.html">浏览供需</a>');
	$("#sr").append('<a href="sup&req.html">发布供需</a>');
	$("#partner").append('<a href="find_partner.html">合作伙伴</a>');
   	$.get(URL, function(data) {
					$(".guide span").append(entName+'，欢迎您！');
				})
			}
   else{
   	$("#findsr").append('<a href="login.html">浏览供需</a>');
	$("#sr").append('<a href="login.html">发布供需</a>');
   	$("#partner").append('<a href="login.html">合作伙伴</a>');
   }
});

$(".guide span").mouseenter(function() {
			if(!$(this).hasClass(".active")) {
				$(".active").removeClass("active");
				$(this).addClass("active");
			}
		})
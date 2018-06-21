$(document).ready(function(){
	$(".header").append('<div><ul class="guide"><li id="home" class=""><a href="index.html">主页</a>	</li>'+
	'<li id="news" class="">'+
						'<a href="">资讯</a>'+
					'</li>'+
					'<li id="data" style="margin-left: 10px;" class="">'+
						'<a href="">行业数据</a>'+
					'</li>'+
					'<li id="findsr" style="margin-left: 20px;" class="">'+
					
					'</li>'+
					'<li id="sr" style="margin-left: 20px;" class="">'+
						
					'</li>'+
					'<li id="partner" style="margin-left: 20px;" class="">'+
						
					'</li>'+
					'<li id="login" style="margin-left: 10px;" class="">'+
						'<a href="login.html">登陆</a>'+
					'</li>'+
					'<li id="register" class="">'+
						'<a href="register.html">注册</a>'+
					'</li>'+
					'<li id="manage" style="margin-left: 20px;" class="hidden">'+
						'<a href="management.html">进入管理</a>'+
					'</li>'+
					'<span class=""></span>'+
				'</ul>'+
			'</div>'
	);
	
})

$(".guide li").mouseenter(function() {
	if(!$(this).hasClass(".active")) {
		$(".active").removeClass("active");
		$(this).addClass("active");
	}
})

$(document).ready(function() {
	var div = $(".guide li");
	div.animate({
		fontSize: '17px'
	}, "slow");
}); 

$(".guide span").mouseenter(function() {
	if(!$(this).hasClass(".active")) {
		$(".active").removeClass("active");
		$(this).addClass("active");
	}
})

//更改导航栏权限
$(document).ready(function() {

//	saveLoginId("12345","广财");
//	saveLoginId("admin","admin");
	aut = sessionStorage.getItem("loginId");
	authority  = JSON.parse(aut);
	if(authority) { 
		userId = authority.id;
		entName = authority.name;
		$(".guide span").addClass("welcome");
		if(userId == "admin") {
			$("#manage").removeClass("hidden");
		}
	} 

	//	如果用户已登录,在span标签加入welcome类
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
		$(".guide span").append(entName + '，欢迎您！');
		
//		$.ajax({
//			type: "get",
//			url: "", //企业表
//			dataType: "json",
//			async: false,
//			success: function(data) {
//				$(".guide span").append(data.entName + '，欢迎您！');
//			},
//			error: function(error) {
//				console.log(error);
//				//			alert("异常！");
//			}
//		});
	} else {
		$("#findsr").append('<a href="login.html">浏览供需</a>');
		$("#sr").append('<a href="login.html">发布供需</a>');
		$("#partner").append('<a href="login.html">合作伙伴</a>');
	}
	
	
	
})

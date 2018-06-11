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
	$.get('/inf/index',  {
					category: '医疗医药保健',
				},
				function(data1) {
		 				console.log(data1);
						$('#tab1_h4').append(data1.inf[0].title);/*获得资讯名称*/
						$('#tab1_p').append(data1.inf[0].digest+'...');/*获得资讯摘要*/
						$.get('/inf/index',  {
								category: 'IT与通讯',
							},
							function(data2) {
								console.log(data2);
								$('#tab2_h4').append(data2.inf[0].title);/*获得资讯名称*/
								$('#tab2_p').append(data2.inf[0].digest+'...');/*获得资讯摘要*/
                                $.get('/inf/index',  {
                                        category: '机械电子',
                                    },
                                    function(data3) {
                                        console.log(data3);
                                        $('#tab3_h4').append(data3.inf[0].title);/*获得资讯名称*/
                                        $('#tab3_p').append(data3.inf[0].digest+'...');/*获得资讯摘要*/
                                        $.get('/inf/index',  {
                                                category: '车辆交通',
                                            },
                                            function(data4) {
                                                console.log(data4);
                                                $('#tab4_h4').append(data4.inf[0].title);/*获得资讯名称*/
                                                $('#tab4_p').append(data4.inf[0].digest+'...');/*获得资讯摘要*/
                                                $.get('/inf/index',  {
                                                        category: '能源矿产',
                                                    },
                                                    function(data5) {
                                                        console.log(data5);
                                                        $('#tab5_h4').append(data5.inf[0].title);/*获得资讯名称*/
                                                        $('#tab5_p').append(data5.inf[0].digest+'...');/*获得资讯摘要*/
                                                    });
                                            });
                                    });
							});
					});

    $.get('/ind/index',  {
            category: '医疗医药保健',
        },
        function(data1) {
            $('#tab6_h4').append(data1.ind[0].title);/*获得行业数据名称*/
            $('#tab6_p').append(data1.ind[0].digest+'...');/*获得行业数据摘要*/
            $.get('/ind/index',  {
                    category: 'IT与通讯',
                },
                function(data2) {
                    $('#tab7_h4').append(data2.ind[0].title);/*获得行业数据名称*/
                    $('#tab7_p').append(data2.ind[0].digest+'...');/*获得行业数据摘要*/
                    $.get('/ind/index',  {
                            category: '机械电子',
                        },
                        function(data3) {
                            $('#tab8_h4').append(data3.ind[0].title);/*获得行业数据名称*/
                            $('#tab8_p').append(data3.ind[0].digest+'...');/*获得行业数据摘要*/
                            $.get('/ind/index',  {
                                    category: '车辆交通',
                                },
                                function(data4) {
                                    $('#tab9_h4').append(data4.ind[0].title);/*获得行业数据名称*/
                                    $('#tab9_p').append(data4.ind[0].digest+'...');/*获得行业数据摘要*/
                                    $.get('/ind/index',  {
                                            category: '能源矿产',
                                        },
                                        function(data5) {
                                            $('#tab10_h4').append(data5.ind[0].title);/*获得行业数据名称*/
                                            $('#tab10_p').append(data5.ind[0].digest+'...');/*获得行业数据摘要*/
                                        })
                                });
                        });
                });
        });
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
$(document).ready(function() {
			var entId = $.query.get("entId"); //获得企业名称
			$.ajax({
				type: "get",
				url: "", //企业表
				dataType: "json",
				data: {
					entId: entId
				},
				async: false,
				success: function(data) {
					$(".entInfo").empty();
					$(".entInfo h1").append('<h1>' + data.entName + '</h1>' +
						'<p>企业类别：' + data.entCategory + '</p>' +
						'<p>企业法人：' + data.entPerson + '</p>' +
						'<p>企业规模：' + data.entSize + '</p>' +
						'<p>企业地址：' + data.entAddress + '</p>' +
						'<p>联系电话：' + data.entPhone + '</p>' +
						'<p>企业邮箱：' + data.entId + '</p>' +
						'<p>企业官网：' + data.entWebsize + '</p>' +
						'<p>注册时间：' + data.entDate + '</p>' +
						'<p>企业介绍：' + data.entIntroduction + '</p>');
				},
				error: function(error) {
				}
			});

			$.ajax({
					type: "get",
					url: "", //已通过审核供应表
					data: {
						index: 0,
						length: 8,
						entId: entId
					},
					dataType: "json",
					async: false,
					success: function(data) {
						$("#support").empty(); //清空展示效果的部分
						for(var i = 0; i < data.pro.length && i < 7; i++) {
							$("#support").append('<li><nav><span class="ID">' + data.pro[i].proId + '</span>' +
								'<span class="title">' + data.pro[i].proTitle + '</span>' +
								'<span class="entType">' + data.pro[i].proType + '</span>' +
								'<span class="time">' + data.pro[i].proDate + '</span>' +
								'<span style="float: right;"><a href="read_sup&req.html?supID=' + data.pro[i].proId +' &entId='  +data.pro[i].entId +' "><button>查看</button></a></span></nav></li>');
							}
							if(data.pro.length > 7) {
								$(".mysup").append('<a href="find_partner.html?entId=' + entId + '" style="float: right;">more>>></a>');
							}
						},
						error: function(error) {}
					});

				$.ajax({
						type: "get",
						url: "/admin/demand",
						data: {
							index: no_ent,
							length: 8,
							entId: entId
						},
						dataType: "json",
						async: false,
						success: function(data) {
							console.log(data);
							$("#require").empty(); //清空展示效果的部分
							for(var i = 0; i < data.demand.length && i < 7; i++) {
								$("#require").append('<li><nav><span class="ID">' + data.demand[i].demandId + '</span>' +
									'<span class="title">' + data.demand[i].demandTitle + '</span>' +
									'<span class="entType">' + data.demand[i].demandType + '</span>' +
									'<span class="time">' + data.demand[i].demandDate + '</span>' +
									'<span style="float: right;"><a href="read_sup&req.html?reqID=' + data.demand[i].demandId +' &entId='  +data.demand[i].entId +'"><button>查看</button></a></span></nav></li>');
								}
								if(data.demand.length > 7) {
									$(".mysup").append('<a href="find_partner.html?entId=' + entId + '" style="float: right;">more>>></a>');
								}
							},
							error: function(error) {
								console.log(error);
							}
						});

				});
//页面加载完成后，显示资讯
			$(document).ready(function() {
				search();
			});
			//填充数据
			function appendDatas(id, title, type, content, date, digest) {
				var sr = '<div class="new">' +
					'<a href="industry_data.html?id=' + id + '"><h1>' + title + '</h1></a>' +
					'<nav><span>' + type + '</span><span>' + date + '</span></nav>' +
					'<div>' + digest + '</div>' +
					'</div>';
				$('.content').append(sr);
			}

//			<!--点击上一页的调用的方法-->
			function last() {
				if(index >= 10)
					index = index - length;
				search();
			}

//			<!--点击下一页调用的方法-->
			function next() {
				index = index + length;
				search();
			}
			//起始的索引
			var index = 0;
			//获取数据的长度
			var length = 10;

			var condition = "";
//			<!--点击搜索调用的方法-->
			function search() {
				var type = $('#type').val().trim();
				var condition1 = $('#input').val().trim();
				if(condition != condition1) {
//					<!--对起始的索引置0-->
					index = 0;
					condition = condition1;
				}
				if(condition1.length <= 0 && condition.length > 0) {
					alert("请输入查询条件");
					return;
				}
				$('.content').html("");
				var requestUrl = "";
				if(condition.length <= 0) {
					requestUrl = "/ind/getAllInd";
				} else if(type == "综合查询") {
					requestUrl = "/ind/searchIndustryData";
				} else if(type == "行业类型") {
					requestUrl = "/ind/queryByType";
				} else if(type == "数据标题") {
					requestUrl = "/ind/queryByTitle";
				}
				var htmlObj = $.ajax({
					type: "POST",
					url: requestUrl,
					data: {
						condition: condition1,
						index: index,
						length: length
					},
					success: function(data) {
						var result = data.ind;
						for(i = 0; i < result.length; i++) {
                            appendDatas(result[i].id, result[i].title, result[i].type, result[i].content, result[i].date, result[i].digest);
						}
					},
					error: function() {}
				});
			}

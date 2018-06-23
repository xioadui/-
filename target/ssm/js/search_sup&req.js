//起始的索引
var index = 0;

$(document).ready(function() {
	$('.content').empty();
	appendSup_Req();
});

//查找5条供需
function appendSup_Req() {
	$.ajax({
		type: "get",
		url: "/provide/getAllPro", //已通过供应表，默认显示5条供应
		dataType: "json",
		data: {
			index: 0,
			length: 6
		},
		async: false,
		success: function(data) {
			$(".content").empty();
			var result = data.pro;
			for(var i = 0; i < result.length; i++) {
                $('.content').append('<div class="new">' + '<a href="read_sup&req.html?supID=' + result[i].proId + '\">' +
                    '<h1>' + result[i].proTitle + '</h1></a>' +
                    '<nav><span>' + result[i].proType + '</span>  <span>' + result[i].proDate + '</span>  <span>' + '</span></nav>' +
                    '<div>' + result[i].proDigest + '</div></div>');
			}
		},
		error: function(error) {
		}
	})
}

function search(){
    var type = $('#type').val().trim();
    index=0;//每次点击查询索引置0
    var condition = $('#input').val().trim();
    $(".content").empty();
	if(type == "供应") {
		search_sup(condition);
	} else {
		search_req(condition);
	}
}

function search_sup(condition) {
	$.ajax({
		type: "get",
		url: "/provide/search", //供应表
		dataType: "json",
		data: {
            condition: condition,
			index: index,
			length: 6
		},
		async: false,
		success: function(data) {
			var result = data.pro;
			$(".content").empty();
            // var name="";
			for(var i = 0; i < result.length; i++) {
				// $.post("/user/queryEntById", { //企业表，查找企业名称，因为供需表里没有企业名称
				// 		entId: result[i].entId
				// 	},
				// 	function(getdata) {
				// 		name = getdata.result[0].entName;
				// 		alert(getdata.length);
				// 	});
				$('.content').append('<div class="new">' + '<a href="read_sup&req.html?supID=' + result[i].proId + '\">' +
					'<h1>' + result[i].proTitle + '</h1></a>' +
					'<nav><span>' + result[i].proType + '</span>  <span>' + result[i].proDate + '</span>  <span>' + '</span></nav>' +
					'<div>' + result[i].proDigest + '</div></div>');

			}
			$("#next_page").removeClass("hidden");
			$("#pre_page").removeClass("hidden");
			if(result.length<6){
				$("#next_page").addClass("hidden");
			}
			if(index==0){
				$("#pre_page").addClass("hidden");
			}
		},
		error: function(error) {
		}
	})
}

function search_req(condition) {
	$.ajax({
		type: "get",
		url: "/demand/search", //需求表
		dataType: "json",
		data: {
            condition: condition,
			index: index,
			length: 6
		},
		async: false,
		success: function(data) {
			var result = data.result;
			$(".content").empty();
			for(var i = 0; i < result.length; i++) {
                // var name;
				// $.get("/user/queryEntById", { //企业表，查找企业名称，因为供需表里没有企业名称
				// 		entId: result[i].entId
				// 	},
				// 	function(getdata) {
				// 		name = getdata.entName;
				// 	});
				$('.content').append('<div class="new">' + '<a href="read_sup&req.html?supID=' + result[i].demandId + '\">' +
					'<h1>' + result[i].demandTitle + '</h1></a>' +
					'<nav><span>' + result[i].demandType + '</span>  <span>' + result[i].demandDate + '</span>  <span>' + '</span></nav>' +
					'<div>' + result[i].demandDigest + '</div></div>');
			}
			$("#next_page").removeClass("hidden");
			$("#pre_page").removeClass("hidden");
			if(data.length<6){
				$("#next_page").addClass("hidden");
			}
			if(index==0){
				$("#pre_page").addClass("hidden");
			}
		},
		error: function(error) {
		}
	})
}

$("#pre_page").on("click", function() {
	index -= 5;
	search();
});

$("#next_page").on("click", function() {
    index += 5;
    search();
});
$(document).ready(function(){
    var p = window.location.search;
    p = p.split("?")[1].split("=")[1];
    $.ajax({
        type: "POST",
        url: "/inf/queryById", //资讯表
        data:{
            id: p
        },
        success: function(data) {
            var result = data.inf[0];
            $(".news_content").append('<h1>'+result.title+'</h1>');
            $(".news_content").append('<nav><span>'+result.type+'</span><span>' +result.date+'</span></nav>');
            $(".news_content").append('<div>'+result.content+'</div>');
        },
        error: function(error) {
        }
    });
});




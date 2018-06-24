var socket;
if(!window.WebSocket){
    window.WebSocket = window.MozWebSocket;
}
if(window.WebSocket){
    socket = new WebSocket("ws://localhost:8080/message");
    socket.onmessage = function(event){
    };
    socket.onopen = function(event){
        alert("支持")
    };
    socket.onclose = function(event){
        alert("关闭")
    };
}
function sendMessage(message){
    alert(message);
    if(socket.readyState==WebSocket.OPEN){
        socket.send(message);
    }else{
        alert('连接还没有建立');
    }
}

function yincang(){
    $('#chatbox').css('display','none');
}

<!--初始界面的设置-->
$(function(){
    $('#chatliebiaobox').css('display','none');
    $('#chatbox').css('display','none');
    $('#zhu').css('display','block');
});
<!--在聊天列表点击关闭-->
function chatliebiaoyincang(){
    $('#chatliebiaobox').css('display','none');
}

header = new Object();
header.id;
header.name;

chatData=new Object();
chatData.id1;
chatData.id2;
chatData.isLeft;
chatData.name1;
chatData.name2;
chatData.time;
chatData.content;

document.onkeydown=function(event){
    var e = event;
    if(e.keyCode==13){ // enter 键
        if($('#chatbox').css('display')=='block'){
            mysend(key);
        }
    }
};

//列表跳转聊天页面
function mychat(key){
    for (var i=localStorage.length-1; i  >=0; i--){<!--倒序输出-->
        if( key == localStorage.key(i)){
            chat(key);
        }
    }
}

//显示用户列表
function appendInLi(){
    $('#chatliebiaobox').css('display','block');<!--将页面进行合适的隐藏和显示-->
    $('#chatbox').css('display','none');
    document.getElementById("chatshow").innerHTML="";<!--清空页面-->
    document.getElementById("chatliebiaoshow").innerHTML="";
    for (var i=0; i  <localStorage.length; i++){
        var key = localStorage.key(i);
        var value = localStorage.getItem(key);
        a = JSON.parse(value)[0]; //转为JSON

        var sr=
            '<div id="'+key+'" class="chatliebiao" onclick="mychat('+key+')">'+
            '<div class="chatliebiaotouxiang">'+
            '<img src="img/chat2.png" />'+
            "</div>"+
            '<div class="chatliebiaoname">'+
            a.name.slice(0,15)+
            '<label>'+
            '</label>'+
            '</div>'+
            '</div>';
        $('#chatliebiaoshow').append(sr);
    }
}

//聊天界面
function chat(mykey){
    key=mykey;
    $('#chatliebiaobox').css('display','none');<!--将页面进行合适的隐藏和显示-->
    $('#chatbox').css('display','block');
    var str = localStorage.getItem(mykey);
    jsonArray = JSON.parse(str);
    for(var i=1;i<jsonArray.length;i++){
        if(jsonArray[i].isLeft!="zuo"){<!--判断输出的位置是在左边还是在右边-->
            var sr=
                '<div class="youwenzi">'+ '<div class="shijian">'+
                jsonArray[i].time+ "</div>"+
                '<div class="youshuchukuang">'+ jsonArray[i].content+ "</div>"+
                '<div class="youtouxiang">'+
                '<img src="img/chat2.png" />'+ "</div>"+ "</div >";
            $('#chatshow').append(sr);
            var div = document.getElementById('chatshow');
            div.scrollTop = div.scrollHeight;
        }else<!--位置在左边-->
        {
            var sr=
                '<div class="zuowenzi">'+
                '<div class="shijian">'+
                jsonArray[i].time+
                "</div>"+
                '<div class="zuoshuchukuang">'+
                jsonArray[i].content+
                "</div>"+
                '<div class="zuotouxiang">'+
                '<img src="img/chat2.png" />'+
                "</div>"+
                "</div >";

            $('#chatshow').append(sr);
            var div = document.getElementById('chatshow');
            div.scrollTop = div.scrollHeight;
        }
    }
}

var key;
//创建聊天
function startChat(userId,name){
    document.getElementById("chatshow").innerHTML="";<!--清空页面-->
    var date=new Date();<!--读取系统时间-->
    var year=date.getFullYear();
    var mon=date.getMonth()+1;
    var da=date.getDate();
    var h=date.getHours();
    var m=date.getMinutes();
    var s=date.getSeconds();
    var mytime=year+"-"+mon+"-"+da+" "+h+":"+m+":"+s;<!--时间格式，存入字符串-->
    var sr=
        '<div class="zuowenzi">'+
        '<div class="shijian">'+
        mytime+
        "</div>"+
        '<div class="zuoshuchukuang">'+
        '您好，我是'+name+'的客服，请问有什么要帮忙的吗？'+
        "</div>"+
        '<div class="zuotouxiang">'+
        '<img src="img/chat3.png" />'+
        "</div>"+
        "</div >";<!--在左边插入一个div-->

    $('#chatshow').append(sr);<!--插入div-->

    var div = document.getElementById('chatshow');<!--设置每次输出div后都显示最下面的那个-->
    div.scrollTop = div.scrollHeight;

    key = date.getTime();
    header.id = userId;
    header.name = name;
    var he ="[";
    he = he + JSON.stringify(header);
    he = he +"]";
    localStorage.setItem(key,he);

    var str = localStorage.getItem(key);
    json = JSON.parse(str)[0];
    chat(key);
    chatData.id1="asd";
    chatData.id2 = json.id;
    chatData.isLeft = "zuo";
    chatData.name1="asd" ;
    chatData.name2 = json.name;
    chatData.time = mytime;
    chatData.content = '您好，我是'+name+'的客服，请问有什么要帮忙的吗？';
    chatDataJson = JSON.stringify(chatData);
    add(key,chatDataJson);
}

//添加到localStroge中
function add(key,jsonStr){
    var str = localStorage.getItem(key);
    str = str.split("]")[0];
    str = str+ ","+jsonStr +"]";
    localStorage.setItem(key,str);
}

//发送按钮的监听
function mysend(){
    var input=$('#chatsendinput').val();<!--获取发送内容-->
    send(key,input);
}


//发送消息
function send(key,content){
    var str = localStorage.getItem(key);
    alert("---"+str+"---");
    json = JSON.parse(str)[0];
    var date=new Date();<!--获取时间-->
    var year=date.getFullYear();
    var mon=date.getMonth()+1;
    var da=date.getDate();
    var h=date.getHours();
    var m=date.getMinutes();
    var s=date.getSeconds();
    var mytime=year+"-"+mon+"-"+da+" "+h+":"+m+":"+s;
    //发送消息
    if(content==""){
        alert("输入内容不能为空");
        return;
    }
    var sr=
        '<div class="youwenzi">'+
        '<div class="shijian">'+
        mytime+
        "</div>"+
        '<div class="youshuchukuang">'+
        content+
        "</div>"+
        '<div class="youtouxiang">'+
        '<img src="img/chat2.png" />'+
        "</div>"+
        "</div >";

    $('#chatshow').append(sr);<!--将发送内容输出到右边-->

    var div = document.getElementById('chatshow');
    div.scrollTop = div.scrollHeight;
    chatData.id1="asd";
    chatData.id2 = json.id;
    chatData.isLeft = "you";
    chatData.name1="asd" ;
    chatData.name2 = json.name;
    chatData.time = mytime;
    chatData.content = content;
    chatDataJson = JSON.stringify(chatData);
    add(key,chatDataJson);

    $(".chatsendinput").val("");
    sendMessage(chatDataJson);
}
//接收
function receive(jsonStr){
}
<!--红点的显示方式-->
function red(display){
    var oDiv=document.getElementById('red');
    oDiv.style.display=display;
}
<!--列表提示-->
function liebiaored(){
    $("#1529461202508 label").html('<div class="liebiaored"></div>');
}
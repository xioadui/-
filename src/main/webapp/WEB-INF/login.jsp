<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE HTML>
<html>
<head>
    <link href="../css/style.css" rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800' rel='stylesheet' type='text/css'>
    <title>登陆</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Hexagon Sign in Form Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, Smartphone Compatible web template, free web designs for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <script type="text/javascript">

        function login(){
            var entId = $('#userId').val().trim();
            var entPassword = $('#password').val().trim();
                var htmlObj = $.ajax({
                type: "POST",
                url: "/loginHandler",
                data: {
                    entId:entId,
                    entPassword:entPassword
                },
                success:function () {
                    if (htmlObj.responseText == "success") {
                        alert("登陆成功");
                        window.location.href="/index.html";
                    }else {
                        alert("登陆失败");
                    }
                },
                error : function() {
                    alert("异常！");
                }
            });

        }


    </script>
</head>
<body>
<!--main-->
<div class="main">
    <div class="login hexagon_box">
        <h1>Login Form</h1>
        <form id="form1">
            <input id="userId" type="text" class="text" value="请输入账号" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入账号';}" >
            <input id="password" type="text" class="text" value="请输入密码" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = '请输入密码';}" >
            <input type="submit" onclick="login()" value="Login" >
            <div class="new">
                <p><a href="#">忘记密码 ?</a></p>
                <p class="sign">新用户 ? <a href="#"> 注册</a></p>
                <div class="clear"></div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
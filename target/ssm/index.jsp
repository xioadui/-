<!DOCTYPE HTML>
<html>
<head>
    <link href="css/style.css" rel='stylesheet' type='text/css' />
    <link href='http://fonts.googleapis.com/css?family=Raleway:400,500,600,700,800' rel='stylesheet' type='text/css'>
    <title>Login Form</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Hexagon Sign in Form Responsive, Login form web template, Sign up Web Templates, Flat Web Templates, Login sign up Responsive web template, Smartphone Compatible web template, free web designs for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="text/javascript">
        function login(){
            var userId = $('#userId').val().trim();
            var password = $('#password').val().trim();
            $.ajax({
                type: "POST",
                url: "/user/login" ,
                data: {
                    userId:userId,
                    password:password
                },
                success:function (result) {
                    console.log(result);//打印服务端返回的数据(调试用)
                    if (result.resultCode == 200) {
                        alert("SUCCESS");
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
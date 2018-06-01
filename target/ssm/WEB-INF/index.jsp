<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<title>主页</title>

<head>
    <style type="text/css">
        * {
            padding: 0;
            margin: 0;
            list-style-type: none;
        }

        body {
            background-color: #FFFFFF
        }

        a,
        img {
            border: 0;
        }

        body { font: 12px/180% Arial, Helvetica, sans-serif, "新宋体"; }
        /* demo */
        /*五张图片在缩略图时所显示的位置调整*/

        #demo li:nth-of-type(1) img {
            transform: translate(-210px);
        }

        #demo li:nth-of-type(2) img {
            transform: translate(-180px);
        }

        #demo li:nth-of-type(3) img {
            transform: translate(-380px);
        }

        #demo li:nth-of-type(4) img {
            transform: translate(-450px);
        }

        #demo li:nth-of-type(5) img {
            transform: translate(-320px);
        }

        #demo {
            width: 1160px;
            height: 400px;
            margin: 60px auto 0 auto;
        }
        #demo img {
            width: 820px;
            height: 512px;
            max-width: 820px;
        }
        #demo li {
            float: left;
            position: relative;
            width: 82px;
            height: 100%;
            overflow: hidden;
            cursor: pointer;
            transition: 0.5s;
            transform-origin: bottom;
            filter: alpha(opacity=50);
            opacity: 0.5;
        }
        #demo li img {
            transition: 1.2s;
        }
        #demo li a {
            display: block;
        }
        #demo li div {
            position: absolute;
            bottom: 0;
            left: 0;
            width: 100%;
            background: #000;
            line-height: 32px;
            filter: alpha(opacity=70);
            opacity: 0.7;
            text-indent: 2em;
        }
        #demo li div a {
            color: #FFF;
            text-decoration: none;
        }
        #demo li div a:hover {
            color: #F00;
            text-decoration: none;
        }
        #demo li.active {
            cursor: pointer;
            transform: scale(1.02, 1.08);
            z-index: 3;
            width: 820px;
            filter: alpha(opacity=100);
            opacity: 1;
        }
        #demo li.active img {
            transform: translate(0px);
        }
        #demo li:nth-of-type(1) {
            transform-origin: bottom left;
        }
        #demo li:nth-of-type(5) {
            transform-origin: bottom right;
        }
    </style>

    <script src="../js/jquery-1.8.2.min.js"></script>
    <script type="text/javascript" src="../js/jquery.indexSlidePattern.js"></script>
    <script language="javascript">
        $(document).ready(function() {
            var opt = {
                "speed": "fast", //变换速度,三速度可选 slow,normal,fast;
                "by": "mouseover", //触发事件,click或者mouseover;
                "auto": true, //是否自动播放;
                "sec": 3000 //自动播放间隔;
            };
            $("#demo").IMGDEMO(opt);
        });
    </script>
    <style>
        #nav ul {
            Width: 1500px;
            /*导航栏宽*/
            height: 60px;
            /*导航栏高*/
            margin: auto;
            /*内边距*/
            padding: 0;
            list-style-type: none;
            /*删除圆点*/
            background: rgb(1, 25, 53);
            /*设置导航条背景*/
        }
        #nav ul li {
            /*块的属性*/
            width: 100px;
            height: 60px;
            margin-top: 20px;
            float: left;
            text-align: center;
        }
        #nav ul li a {
            text-decoration: none;
            color: rgb(255, 255, 255);
        }

        #nav ul li a:visited {
            display: block;
            background-color: rgb(1, 25, 53);
            text-align: center;
            padding: 4px;
            /*内边距*/
            text-decoration: none;
        }
        #nav ul li a:hover {
            display: block;
            color: rgb(208, 233, 255);
            background: rgb(1, 25, 53);
        }
        #news {
            /*资讯板块的属性*/
            background: rgb(255, 255, 255);
            position: absolute;
            width: 750px;
            /*height: 300px;*/
            left: 180px;
            top: 586px;
            margin-bottom: auto;
            overflow: hidden;
        }
        #board {
            /*公告板属性*/
            background: rgb(255, 255, 255);
            position: relative;
            width: 350px;
            height: 300px;
            right: 180px;
            top: 65px;
            margin-bottom: auto;
            overflow: hidden;
        }

        #foot {
            width: 1460px;
            /*玄学，明明上面1500可以对齐的这里1500对不齐*/
            margin: auto;
            margin-top:90%;
            padding: 20px;
            background: rgb(1, 25, 53);
        }
    </style>

</head>

<body>

<div id="nav">
    <ul>
        <li>
            <a href="#home">主页</a>
        </li>
        <li>
            <a href="#news">资讯</a>
        </li>
        <li>
            <a href="/login.html">登陆</a>
        </li>
        <li>
            <a href="/registerForm.html">注册</a>
        </li>
        <li>
            <a href="#read">浏览行业数据</a>
        </li>
    </ul>
</div>

<ul id="demo">
    <li class="active">
        <a href="#"><img src="http://eduppp.cn/images/0/1.jpg"></a>
        <div>
            <a href="#">天安门</a>
        </div>
    </li>
    <li>
        <a href="#"><img src="http://eduppp.cn/images/0/2.jpg"></a>
        <div>
            <a href="#">天坛</a>
        </div>
    </li>
    <li>
        <a href="#"><img src="http://eduppp.cn/images/0/3.jpg" /></a>
        <div>
            <a href="#">>东方明珠</a>
        </div>
    </li>
    <li>
        <a href="#"><img src="http://eduppp.cn/images/0/4.jpg"></a>
        <div>
            <a href="#">布达拉宫</a>
        </div>
    </li>
    <li>
        <a href="#"><img src="http://eduppp.cn/images/0/5.jpg"></a>
        <div>
            <a href="#">长城</a>
        </div>
    </li>
</ul>

<div style="width: 100%">
    <div id="news" style="float:left;width: 55%;">
        <!--    这里是资讯栏   -->
            <div>
                <img src="../images/arrow.png" width="15" height="15">
                <span style="font-size: large">资讯/News</span>
                <a href="#" title="更多" target="_blank" rel="external nofollow">
                    <span style=" float:right"><span>●</span><span>●</span><span>●</span> </span>
                </a>
            </div>
            <div style="padding-top: 10px;">
                <ul>
                    <c:forEach items="${informationList}" var="infomation">
                        <div style="margin-top: 50px;">

                            ${infomation.type}<br/>
                            ${infomation.title}<br/>
                            ${infomation.digest}<br/>
                        </div>
                    </c:forEach>
                </ul>
            </div>
    </div>

    <div id="board" style="float:right;width: 15%;">
        <!--    这里是公告栏   -->
        <div style="margin-left: 0px;">

            <div style="width: 100%;"> <img src="../images/arrow.png" width="15" height="15">
                <span style="font-size: large">公告/Boards</span>
                <a href="#" title="更多" target="_blank" rel="external nofollow">
                    <span style="float:right"><span>●</span><span>●</span><span>●</span> </span>
                </a>
            </div>
            <div style="width: 100%; padding-top: 10px;">
                <!-- 这里放公告链接 -->
                <ul>
                    <div style="margin: 20px;">
                        <div title="第1条公告">
                            <a href="#" target="_blank">公告1 </a>
                            <div style="position: relative;float:right;"> 2018-05-14 </div>
                        </div>
                        <div title="第2条公告">
                            <a href="#" target="_blank" margin-top: 10px>公告2</a>
                            <div style="position: relative; float:right; "> 2018-05-14 </div>
                        </div>
                        <div title="第3条公告">
                            <a href="#" target="_blank" margin-top: 10px>公告3 </a>
                            <div style="position: relative; float:right;"> 2018-05-14 </div>
                        </div>
                        <div title="第4条公告">
                            <a href="#" target="_blank" margin-top: 10px>公告4 </a>
                            <div style="position: relative; float:right;"> 2018-05-14 </div>
                        </div>
                        <div title="第5条公告">
                            <a href="#" target="_blank" margin-top: 10px>公告5</a>
                            <div style="position: relative; float:right;"> 2018-05-14 </div>
                        </div>
                    </div>
                </ul>
            </div>
        </div>
    </div>
</div>

<div id="foot">
    <!--页脚-->
</div>

</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: 陈康勇
  Date: 2018/5/23
  Time: 11:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="js/validation.js"></script>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>


    <script type="text/javascript">
        $(document).on('click','#submit',function (){
                var entId = $('#field1').val().trim();//企业ID
                var entName = $('#field2').val().trim();//企业名称
                var entPerson= $('#field3').val().trim();//企业法人
                var entCategory= $('#field4').val().trim();//企业类型
                var entBrief = $('#field5').val().trim();//企业简介
                var entIntroduction = $('#field6').val().trim();//企业介绍
                var entAddress = $('#field7').val().trim();//企业地址
                var entSize = $('#field8').val().trim();//企业规模
                var entPhone = $('#field9').val().trim();//企业电话
                var entPassword = $('#field10').val().trim();//密码
                var entWebsize = $('#field11').val().trim();//官网
                $.ajax({
                    type: "POST",
                    url: "/register",
                    data: {
                        entId:entId,
                        entName:entName,
                        entPerson:entPerson,
                        entCategory:entCategory,
                        entBrief:entBrief,
                        entIntroduction:entIntroduction,
                        entAddress:entAddress,
                        entSize:entSize,
                        entPhone:entPhone,
                        entPassword:entPassword,
                        entWebsize:entWebsize
                    },
                    success:function () {
                        alert("注册成功");
                        window.location.href="/index.html";//需要跳转的地址
                    },
                    error : function() {
                    }
                });
            }
        )

    </script>


    <link title="style1" rel="stylesheet" href="css/register.css" type="text/css" />
</head>
<body>
<div class="form_content">
    <form id="form1" method="post">
        <fieldset>
            <legend>注册</legend>
            <div class="form-row">
                <div class="field-label">企业邮箱:</div>
                <div class="field-widget"><input name="field1" id="field1" class="required" title="企业邮箱" /></div>
            </div>

            <div class="form-row">
                <div class="field-label">企业名称:</div>
                <div class="field-widget"><input name="field2" id="field2" class="required" title="企业名称" /></div>
            </div>

            <div class="form-row">
                <div class="field-label">企业法人:</div>
                <div class="field-widget"><input name="field3" id="field3" class="required" title="企业法人" /></div>
            </div>

            <div class="form-row">
                <div class="field-label"><label fo="field">企业类别</label>:</div>
                <div class="field-widget">
                    <select  name="field4" id="field4" class="validate-selection" title="企业类别" >
                        <option>Select one...</option>
                        <option>医疗医药保健</option>
                        <option>IT与通讯</option>
                        <option>机械电子</option>
                        <option>车辆交通</option>
                        <option>能源矿产</option>
                        <option>建筑房地产</option>
                        <option>家用电器</option>
                        <option>金融保险投资</option>
                    </select>
                </div>
            </div>

            <div class="form-row">
                <div class="field-label"><label for="field5">企业简介</label>:</div>
                <div class="field-widget"><textarea name="field5" id="field5" class="required"></textarea></div>
            </div>

            <div class="form-row">
                <div class="field-label"><label for="field6">企业介绍</label>:</div>
                <div class="field-widget"><textarea name="field6" id="field6" class="required"></textarea></div>
            </div>

            <div class="form-row">
                <div class="field-label">企业地址:</div>
                <div class="field-widget"><input name="field7" id="field7" class="required" title="企业地址" /></div>
            </div>

            <div class="form-row">
                <div class="field-label">企业规模:</div>
                <div class="field-widget"><input name="field8" id="field8" class="required" title="企业规模" /></div>
            </div>

            <div class="form-row">
                <div class="field-label">联系电话:</div>
                <div class="field-widget"><input name="field9" id="field9" class="required" title="联系电话" /></div>
            </div>

            <div class="form-row">
                <div class="field-label">登陆密码:</div>
                <div class="field-widget"><input name="field10" id="field10" class="required" title="登陆密码" /></div>
            </div>

            <div class="form-row">
                <div class="field-label">企业官网:</div>
                <div class="field-widget"><input name="field11" id="field11" class="required" title="企业官网" /></div>
            </div>


            <div class="form-row">
                <div class="field-label">提交</div>
                <input type="submit" class="submit" id="submit" value="submit" />
            </div>
        </fieldset>
    </form>
</div>
</body>
</html>

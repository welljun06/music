<%--
  Created by IntelliJ IDEA.
  User: welljun06
  Date: 2017/12/15
  Time: 21:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" href="css/style.css">
<head>
    <title>登录界面</title>
</head>
<body>
<div class="htmleaf-container">
    <div class="wrapper">
        <div class="container">
            <h1>云音乐系统管理员登录</h1>
            <form name="loginForm" id="form" align="center" action="${pageContext.request.contextPath}/ManagerLoginServlet" method="post">
                <input type="text" placeholder="Username" name="mname">
                <input type="password" placeholder="Password" name="mpw">
                <button type="submit" id="login-button">Login</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
<script language="javascript">
    //窗体改变大小时触发事件
    window.onresize = setViewSize;
    var marginLeft=0;
    var marginTop=0;
    //设置画布大小，登录页面显示在屏幕最中间
    function setViewSize() {
        //计算屏幕大小
        var w=window.innerWidth
            || document.documentElement.clientWidth
            || document.body.clientWidth;
        var h=window.innerHeight
            || document.documentElement.clientHeight
            || document.body.clientHeight;
        //设置登陆div的位置
        marginLeft = (w-468)/2;
        marginTop = (h-262)/2;
        document.getElementById("loginFormMain").style.marginLeft=marginLeft;
        document.getElementById("loginFormMain").style.marginTop=marginTop;
    }

    //默认聚焦在用户名输入框上
    function focusOnUsername() {
        //调整画布大小和登陆框位置
        setViewSize();
        //默认聚焦在输入框上
        if (document.loginForm) {
            var usernameInput = document.loginForm.name;
            if (usernameInput) {
                usernameInput.focus();
            }
        }
        return;
    }

    //检查用户输入
    function checkLogin(){
        if(checkUsername() && checkPassword()){
            return true;
        }
        return false;
    }
    //检查登录用户名
    function checkUsername(){
        var username = document.loginForm.name;
        if(username.value.length!=0){
            return true;
        }else{
            alert("请输入用户名");
            return false;
        }
    }
    //检查登录密码
    function checkPassword(){
        var password = document.loginForm.id;
        if(password.value.length!=0){
            return true;
        }else{
            alert("请输入密码");
            return false;
        }
    }
</script>

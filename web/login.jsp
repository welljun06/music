<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>

    <!-- CSS -->
    <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
    <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="assets/css/form-elements.css">
    <link rel="stylesheet" href="assets/css/style.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <!-- Favicon and touch icons -->
    <link rel="shortcut icon" href="assets/ico/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
    <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">

</head>

<body>
<div class="container-fluid" style="position:relative">
    <div class="container-fluid" style="padding: 0em;position:absolute;left:0;top:0">
    <video src="img/1.mp4" class="img-responsive" alt="Four slide"  autoplay="autoplay" loop="loop"></video>
    </div>
<!-- Top content -->
    <div class="top-content">

    <div class="inner-bg">
        <div class="container">
            <div class="row">
                <div class="col-sm-8 col-sm-offset-2 text">
                    <h1><strong>云音乐</strong>管理系统</h1>
                    <div class="description">
                        <p>
                            开启音乐之旅
                        </p>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-sm-4 col-sm-offset-4 form-box">
                    <div class="form-top">
                        <div class="form-top-left">
                            <h2 style="color: white;">欢迎</h2>
                        </div>
                        <div class="form-top-right">
                            <h3><span class="glyphicon glyphicon-music"></span></h3>
                        </div>
                    </div>
                    <div class="form-bottom">
                        <form name="loginForm" id="form" align="center" action="${pageContext.request.contextPath}/LoginServlet" method="post" onsubmit="return checkLogin()">
                            <div class="form-group">
                                <label class="sr-only" for="form-username">账号</label>
                                <input type="text" name="cname"  class="form-username form-control" id="form-username">
                            </div>
                            <div class="form-group">
                                <label class="sr-only" for="form-password">密码</label>
                                <input type="password" name="cpw"  class="form-password form-control" id="form-password">
                            </div>
                            <button type="submit" class="btn">登录！</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</div>

<!-- Javascript -->
<script src="assets/js/jquery-1.11.1.min.js"></script>
<script src="assets/bootstrap/js/bootstrap.min.js"></script>
<script src="assets/js/jquery.backstretch.min.js"></script>
<script src="assets/js/scripts.js"></script>

<!--[if lt IE 10]>
    <script src="assets/js/placeholder.js"></script>
<![endif]-->

</body>

</html>
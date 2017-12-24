<%@ page import="domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>云音乐</title>
    <link rel='stylesheet' href='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css'>
    <link rel='stylesheet' href='css/style.css'>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <script src="http://cdn.bootcss.com/jquery/1.11.0/jquery.min.js" type="text/javascript"></script>
    <script src='http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js'></script>
</head>
<body>
<div class="container-fluid" style="position:relative">

    <div class="container-fluid" style="padding: 0em;position:absolute;left:0;top:0">
        <div id="myCarousel" class="carousel slide " style="margin-top: 0em">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                <li data-target="#myCarousel" data-slide-to="1"></li>
                <li data-target="#myCarousel" data-slide-to="2"></li>

            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <a href="${pageContext.request.contextPath}/AlbumInfoServlet?cid=${user.cid}&aid=18">
                    <img src="img/11.jpg" class="img-responsive" alt="First slide">
                    </a>
                </div>
                <div class="item">
                    <a href="${pageContext.request.contextPath}/AlbumInfoServlet?cid=${user.cid}&aid=3">
                    <img src="img/9.jpg" class="img-responsive" alt="Second slide">
                    </a>
                </div>
                <div class="item">
                    <a href="${pageContext.request.contextPath}/AlbumInfoServlet?cid=${user.cid}&aid=4">
                    <img src="img/10.jpg" class="img-responsive" alt="Third slide">
                    </a>
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="carousel-control left" href="#myCarousel"
               data-slide="prev">&lsaquo;
            </a>
            <a class="carousel-control right" href="#myCarousel"
               data-slide="next">&rsaquo;
            </a>
        </div>
    </div>

    <div>
        <nav class="navbar navbar-default navbar-fixed-top navbar-transparent" role="navigation" style="opacity: 0.8;">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse"
                            data-target="#example-navbar-collapse">
                        <span class="sr-only">切换导航</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="${pageContext.request.contextPath}/IndexServlet?cid=${user.cid}"><span class="glyphicon glyphicon-headphones"></span> 音乐云平台</a>
                </div>
                <div class="collapse navbar-collapse" id="example-navbar-collapse">
                    <ul class="nav navbar-nav">

                        <li><a href="${pageContext.request.contextPath}/HotSongServlet?cid=${user.cid}"><span class="glyphicon glyphicon-cd"></span> 发现音乐</a></li>
                        <li><a href="${pageContext.request.contextPath}/MyMusicServlet?cid=${user.cid}"><span class="glyphicon glyphicon-user"></span> 我的音乐</a></li>
                        <li><a href="${pageContext.request.contextPath}/CommendServlet?cid=${user.cid}"><span class="glyphicon glyphicon-heart"></span> 为你推荐</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                <span class="glyphicon glyphicon-list"></span> 排行榜
                                <b class="caret"></b>
                            </a>
                            <ul class="dropdown-menu">
                                <li><a href="${pageContext.request.contextPath}/RankSongServlet?cid=${user.cid}">热门歌曲排行</a></li>
                                <li><a href="${pageContext.request.contextPath}/RankAlbumServlet?cid=${user.cid}">热门专辑排行</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form  class="navbar-right" action="${pageContext.request.contextPath}/SearchServlet" role="search" style="width: 15em; margin-top: 0.6em ;" >
                        <div class="input-group">
                            <input type="text" class="form-control" placeholder="搜索歌曲、歌手、专辑" name="search">
                            <input type="hidden" name="cid" value=${user.cid}>
                            <div class="input-group-btn">
                                <button type="submit" class="btn btn-default">
                                    <span class="glyphicon glyphicon-search"></span>
                                </button>
                            </div>
                        </div>
                    </form>
                    <div class="navbar-right">
                        <ul class="nav navbar-nav">
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                                    <img style="width: 20px;height: 20px;margin: 0em" src="img/users/${user.cid}.jpg" class="img-circle">
                                    ${ user.cname }
                                    <b class="caret"></b>
                                </a>
                                <ul class="dropdown-menu">
                                    <li><a href="${pageContext.request.contextPath}/UserInfoServlet?cid=${user.cid}"><span class="glyphicon glyphicon-cog"></span> 个人信息</a></li>
                                    <li><a href="/login.jsp"><span class="glyphicon glyphicon-off"></span> 退出</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
    </div>
</div>
</body>
</html>

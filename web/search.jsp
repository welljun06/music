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
<nav class="navbar navbar-inverse" role="navigation" style="margin-bottom: 0em">
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

<div class="container">
    <div class="row">
        <h3 class="text-center">歌曲搜索结果</h3>
    </div>
    <div class="row table-responsive">
        <table class="table table-condensed table-striped">
            <tr  class="success">
                <td>歌曲</td>
                <td>专辑</td>
                <td>歌手</td>
                <td>歌曲时间</td>
                <td>歌曲类型</td>
                <td>播放次数</td>
                <td>喜爱</td>
            </tr>
            <c:forEach var="c" items="${requestScope.songs }" varStatus="status">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/PlayServlet?cid=${user.cid}&sid=${c.sid}">${c.sname}</a></td>
                    <td>${c.aname}</td>
                    <td><a href="${pageContext.request.contextPath}/SingerInfoServlet?cid=${user.cid}&sid=${c.sid}&pname=${c.pname}">${c.pname}</a></td>
                    <td>${c.stime}</td>
                    <td>${c.stype}</td>
                    <td>${c.scount}</td>
                    <td><a href="${pageContext.request.contextPath}/AddFavSongServlet?cid=${user.cid}&sid=${c.sid}"><span class="glyphicon glyphicon-plus"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <h3 class="text-center">歌手搜索结果</h3>
    </div>
    <div class="row table-responsive">
        <table class="table table-condensed table-striped">
            <tr  class="success">
                <td>歌手</td>
                <td>歌手类型</td>
                <td>歌曲信息</td>
            </tr>
            <c:forEach var="c" items="${requestScope.singers }" varStatus="status">
                <tr>
                    <td>${c.pname}</td>
                    <td>${c.ptype}</td>
                    <td>${c.pinfo}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <h3 class="text-center">专辑搜索结果</h3>
    </div>
    <div class="row table-responsive">
        <table class="table table-condensed table-striped">
            <tr  class="success">
                <td>专辑</td>
                <td>歌手</td>
                <td>专辑年份</td>
                <td>专辑信息</td>
            </tr>
            <c:forEach var="c" items="${requestScope.albums }" varStatus="status">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/AlbumInfoServlet?cid=${user.cid}&aid=${c.aid}">${c.aname}</a></td>
                    <td>${c.pname}</td>
                    <td>${c.ayear}</td>
                    <td>${c.ainfo}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

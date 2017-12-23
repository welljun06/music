<%@ page import="domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <title>网易云音乐</title>
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
            <a class="navbar-brand"><span class="glyphicon glyphicon-headphones"></span> 音乐云平台</a>
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
                        <li><a href="#">jmeter</a></li>
                        <li><a href="#">EJB</a></li>
                        <li><a href="#">Jasper Report</a></li>
                        <li class="divider"></li>
                        <li><a href="#">分离的链接</a></li>
                        <li class="divider"></li>
                        <li><a href="#">另一个分离的链接</a></li>
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
<form action="${pageContext.request.contextPath}/AddListSongServlet" method="post">
歌单名字：<input type="text" name="lname"><br>
歌单类型：<input type="text" name="ltype"><br>
    歌单信息：<input type="text" name="linfo"><br>
    <div class="row table-responsive">
        <table class="table table-condensed table-striped">
            <tr class="info">
                <td>选中</td>
                <td>歌曲</td>
                <td>专辑</td>
                <td>歌手</td>
                <td>歌曲时间</td>
                <td>歌曲类型</td>
                <td>删除</td>
            </tr>
            <c:forEach var="c" items="${requestScope.songs }" varStatus="status">
                <tr>
                    <td><input type="checkbox" name="checkDelete" value="${c.sid}"></td>
                    <td><a href="${pageContext.request.contextPath}/PlayServlet?cid=${user.cid}&sid=${c.sid}">${c.sname}</a></td>
                    <td><a href="${pageContext.request.contextPath}/AlbumInfoServlet?cid=${user.cid}&aid=${c.aid}">${c.aname}</a></td>
                    <td><a href="${pageContext.request.contextPath}/SingerInfoServlet?cid=${user.cid}&sid=${c.sid}&pname=${c.pname}">${c.pname}</a></td>
                    <td>${c.stime}</td>
                    <td>${c.stype}</td>
                    <td><a href="${pageContext.request.contextPath}/DelFavSongServlet?cid=${user.cid}&sid=${c.sid}">
                        <span class="glyphicon glyphicon-remove"></span></a></td>
                </tr>
            </c:forEach>
            <input type="hidden" name="cid" value=${user.cid}>
        </table>
        <br>
        <%response.setCharacterEncoding("UTF-8");%>
        <input type="submit" value="ok">
    </div>
</form>
</div>
</body>
</html>
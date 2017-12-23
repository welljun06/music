<%@ page import="domain.User" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li class="active"><a href="${pageContext.request.contextPath}/MyMusicServlet?cid=${user.cid}"><span class="glyphicon glyphicon-user"></span> 我的音乐</a></li>
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
    <div class="row">
        <h3 class="text-center">${user.cname}的资料库</h3>
    </div>
    <div class="row table-responsive">
        <table class="table table-condensed table-striped">
            <tr class="info">
                <td>图片</td>
                <td>歌曲</td>
                <td>专辑</td>
                <td>歌手</td>
                <td>歌曲时间</td>
                <td>歌曲类型</td>
                <td>删除</td>
            </tr>
            <c:forEach var="c" items="${requestScope.songs }" varStatus="status">
                <tr>
                    <td style="width: 60px;height: 60px""><div style="width: 60px;height: 60px"><img style="width: 60px;height: 60px" src="img/albums/${c.aid}.jpg" class="img-rounded img-responsive" alt="Responsive image"></div></td>
                    <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/PlayServlet?cid=${user.cid}&sid=${c.sid}">${c.sname}</a></td>
                    <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/AlbumInfoServlet?cid=${user.cid}&aid=${c.aid}">${c.aname}</a></td>
                    <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/SingerInfoServlet?cid=${user.cid}&sid=${c.sid}&pname=${c.pname}">${c.pname}</a></td>
                    <td style="vertical-align: middle;">${c.stime}</td>
                    <td style="vertical-align: middle;">${c.stype}</td>
                    <td style="vertical-align: middle;"><a href="${pageContext.request.contextPath}/DelFavSongServlet?cid=${user.cid}&sid=${c.sid}">
                        <span class="glyphicon glyphicon-remove"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <span class="col-md-4"></span>
        <h3 class="text-center col-md-4">${user.cname}的创建歌单</h3>
        <a class="col-md-4  text-right" href="${pageContext.request.contextPath}/AddListServlet?cid=${user.cid}" style="margin-bottom: 0px"><p>创建歌单</p></a>
    </div>
    <div class="row table-responsive">
        <table class="table table-condensed table-striped">
            <tr class="info">
                <td>歌单</td>
                <td>歌单类型</td>
                <td>播放次数</td>
                <td>创建时间</td>
                <td>歌单信息</td>
                <td>删除歌单</td>
            </tr>
            <c:forEach var="c" items="${requestScope.songList }" varStatus="status">
            <tr>
                <td><a href="${pageContext.request.contextPath}/SongListInfoServlet?cid=${user.cid}&lid=${c.lid}&lname=${c.lname}">${c.lname}</a></td>
                <td>${c.ltype}</td>
                <td>${c.lcount}</td>
                <td>${c.ltime}</td>
                <td>${c.linfo}</td>
                <td><a href="${pageContext.request.contextPath}/DelListServlet?cid=${user.cid}&lid=${c.lid}"><span class="glyphicon glyphicon-remove"></span></a></td>
            </tr>
            </c:forEach>
        </table>
    </div>
    <div class="row">
        <h3 class="text-center">${user.cname}的收藏歌单</h3>
    </div>
    <div class="row table-responsive">
        <table class="table table-condensed table-striped">
            <tr class="info">
                <td>歌单</td>
                <td>歌单类型</td>
                <td>播放次数</td>
                <td>创建时间</td>
                <td>歌单信息</td>
                <td>取消收藏</td>
            </tr>
            <c:forEach var="c" items="${requestScope.favSongList }" varStatus="status">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/SongListInfoServlet?cid=${user.cid}&lid=${c.lid}&lname=${c.lname}">${c.lname}</a></td>
                    <td>${c.ltype}</td>
                    <td>${c.lcount}</td>
                    <td>${c.ltime}</td>
                    <td>${c.linfo}</td>
                    <td><a href="${pageContext.request.contextPath}/TakeOffListServlet?cid=${user.cid}&lid=${c.lid}"><span class="glyphicon glyphicon-remove"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>

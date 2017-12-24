<%--
  Created by IntelliJ IDEA.
  User: welljun06
  Date: 2017/12/16
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${manager.mname}
<div>
    <a href="${pageContext.request.contextPath}/AllLogServlet">显示日志</a>
<form name="form" id="form" align="center" action="${pageContext.request.contextPath}/AddServlet" method="post">
    <div  id="loginFormMain">
        <table  style="width:468px;height:262px;background-color:rgba(203,74,188,0.57);text-align: center;">
            <tr>
                <th colspan="2" align="center" ><h1>添加很多信息</h1></th>
            </tr>
            <tr>
                <td>歌手姓名: <input type="text" style="width: 200px;height: 30px;"  name="pname"></td>
            </tr>
            <tr>
                <td>歌手类型: <input type="text"  style="width: 200px;height: 30px;"  name="ptype"></td>
            </tr>
            <tr>
                <td>歌手图片: <input type="text"  style="width: 200px;height: 30px;"  name="pjpg"></td>
            </tr>
            <tr>
                <td>歌手简介: <input type="text"  style="width: 200px;height: 30px;"  name="pinfo"></td>
            </tr>
            <tr>
                <td>专辑名称: <input type="text"  style="width: 200px;height: 30px;"  name="aname"></td>
            </tr>
            <tr>
                <td>专辑年份: <input type="text"  style="width: 200px;height: 30px;"  name="ayear"></td>
            </tr>
            <tr>
                <td>专辑简介: <input type="text"  style="width: 200px;height: 30px;"  name="ainfo"></td>
            </tr>
            <tr>
                <td>歌曲名称: <input type="text"  style="width: 200px;height: 30px;"  name="sname"></td>
            </tr>
            <tr>
                <td>歌曲时长: <input type="text"  style="width: 200px;height: 30px;"  name="stime"></td>
            </tr>
            <tr>
                <td>歌曲播放量: <input type="text"  style="width: 200px;height: 30px;"  name="scount"></td>
            </tr>
            <tr>
                <td>歌曲类型: <input type="text"  style="width: 200px;height: 30px;"  name="stype"></td>
            </tr>
            <tr>
                <td align="center" ><input  formmethod="post" type="submit" style="cursor: pointer;font-style: inherit;" name="submit" value="确认添加" >
            </tr>
        </table>
    </div>
</form>
</div>
<div>
    <form name="dform"  align="center" action="${pageContext.request.contextPath}/DeleteServlet" method="post">
        <div  id="loginForformmMain">
            <table  style="width:468px;height:262px;background-color:rgba(203,74,188,0.57);text-align: center;">
                <tr>
                    <th colspan="2" align="center" ><h1>添加很多信息</h1></th>
                </tr>
                <tr>
                    <td>歌曲id: <input type="text" style="width: 200px;height: 30px;"  name="sid"></td>
                </tr>
                <tr>
                    <td align="center" ><input  formmethod="post" type="submit" style="cursor: pointer;font-style: inherit;" name="submit" value="确认添加" >
                </tr>
            </table>
        </div>
    </form>
</div>
</body>
</html>

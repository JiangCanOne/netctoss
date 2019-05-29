<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2019/5/28
  Time: 20:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="account/findAll">查询所有</a><br>

    <h1>保存用户</h1>
    <form action="account/save" method="get">
        姓名：<input name="name"><br>
        金额：<input name="money"><br>
        <button type="submit">提交</button>
    </form>
    <br>
    <h1>更新用户</h1>
    <form action="account/update" method="get">
        姓名：<input name="name"><br>
        金额：<input name="money"><br>
        <button type="submit">提交</button>
    </form>
    <br>


</body>
</html>

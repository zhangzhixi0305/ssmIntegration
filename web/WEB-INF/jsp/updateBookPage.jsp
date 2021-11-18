<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改书籍页面</title>
</head>
<body>
<form style="text-align: center" action="${pageContext.request.contextPath}/books/toUpdate" method="post">
    <%--
        出现的问题:我们提交了修改的SQL请求，但是修改失败，初次考虑，是事务问题，配置完毕事务，依旧失败!
        看一下SQL语句，能否执行成功: SQL执行失败，修改未完成
        前端传递隐藏域
    --%>
    <input type="hidden" name="bookID" value="${QUpdate.bookID}">

    <div>书籍名称：<input type="text" name="bookName" value="${QUpdate.bookName}" required/></div>
    <div>书籍数量：<input type="text" name="bookCounts" value="${QUpdate.bookCounts}" required/></div>
    <div>书籍描述：<input type="text" name="detail" value="${QUpdate.detail}" required/></div>
    <div><input type="submit" value="修改"/></div>
</form>
</body>
</html>

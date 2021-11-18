<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>书籍展示页面</title>
</head>
<body>
<center><h1>欢迎来到书籍展示页面</h1></center>

<div style="text-align: center">

    <div>
        <%--跳转到添加书籍的页面--%>
        <a href="${pageContext.request.contextPath}/books/toBookPage">添加书籍</a>
        &nbsp;&nbsp;&nbsp;
        <a href="${pageContext.request.contextPath}/books/allBook">查询全部书籍</a>
    </div>

    <div>
        <%--根据id查询书籍--%>
        <form method="post" action="${pageContext.request.contextPath}/books/queryById">
            <input type="text" name="bookById" placeholder="输入id查询书籍">
            <input type="submit" value="查询"/><span style="color: #ff6659">${errorById}</span>
        </form>
    </div>

    <div>
        <%--根据书名查询书籍--%>
        <form method="post" action="${pageContext.request.contextPath}/books/queryByName">
            <input type="text" name="bookName" placeholder="输入书名查询书籍">
            <input type="submit" value="查询"><span style="color: red">${errorByName}</span>
        </form>
    </div>

    <table border="1" align="center" style="text-align: center">
        <tr>
            <th>书籍编号</th>
            <th>书籍名称</th>
            <th>书籍数量</th>
            <th>书籍详情</th>
            <th>操作</th>
        </tr>

        <c:forEach var="books" items="${list}">
            <tr>
                <td>${books.bookID}</td>
                <td>${books.bookName}</td>
                <td>${books.bookCounts}</td>
                <td>${books.detail}</td>
                <td>
                    <a href="${pageContext.request.contextPath}/books/updateBookPage?id=${books.bookID}">修改</a>
                    &nbsp; | &nbsp;
                    <a href="${pageContext.request.contextPath}/books/delBook?id=${books.bookID}">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>

</div>


</body>
</html>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加书籍页面</title>
</head>
<body>
<form style="text-align: center" action="${pageContext.request.contextPath}/books/addBook" method="post">
    <div>书籍名称：<input type="text" name="bookName" required/></div>
    <div>书籍数量：<input type="text" name="bookCounts" required/></div>
    <div>书籍描述：<input type="text" name="detail" required/></div>
    <div><input type="submit" value="提交"></div>
</form>
</body>
</html>

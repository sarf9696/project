<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Message</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<!-- indclude directive -->
<%@ include file="header.jsp" %>

<br>


<div align="center">
    <h2 class="error">${message2}</h2>
</div>


<br><br><br><br>
<form method="get" action="${pageContext.request.contextPath}" style="text-align: center">
    <input type="submit" value="Go To Index">
</form>
</body>
</html>

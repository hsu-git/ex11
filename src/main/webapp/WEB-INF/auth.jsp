<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <meta charset="UTF-8">
<head>
    <title>세션과 쿠키</title>
</head>
<body>
  <p>세션 좋아! 쿠키 좋아!</p>
    <p>세션이 전하는 행운의 숫자 : <%= session.getAttribute("lucky_number")%></p>
</body>
</html>




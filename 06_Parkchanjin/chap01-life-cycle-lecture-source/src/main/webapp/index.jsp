<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
    <h1>라이플 사이클(생명 주기) 테스트</h1>
    <a href="/xml-lifecycle">xml 설정 방법</a>
    <br>
    <a href="/annotaion-lifecycle">annotaion 설정 방법</a>

    <h2>Service Method의 역할</h2>
    <h3>a 태그의 href 속성 값 요청</h3>
    <a href="request-service">서비스 메서드 요청</a>
    <h3>form 태그의 method 속성을 get으로 설정해서 요청</h3>
    <form action="request-service" method="get">
        <input type="submit" value="get 방식 요청">
    </form>
    <h3>form 태그의 method 속성을 post로 설정해서 요청</h3>
    <form action="request-service" method="post">
        <input type="submit" value="post 방식 요청">
    </form>
</body>
</html>
<%-- 1. JSP 주석 : 해석 시 사라지는 주석--%>
<!-- HTML 주석 : 해석은 안되지만 남아있음 -->

<%-- 2. 페이지 지시자 태그 : 페이지의 설정을 지시하는 태그
contentType 속성 : response header에 응답 형식을 지정하는 속성
language 속성 : <% %> 태그 내에 작성하는 코드 문법을 명시하는 속성
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP 태그 종류 확인</title>
</head>
<body>
    <%-- 3. 선언 태그 :
    서블릿으로 변환 시 필드로 선언할 내용을 작성하는 태그--%>
    <%!
        private String name;
        private int age;
    %>

    <%-- 4. 스크립틀릿(scriptlet) 태그
        간단한 자바 코드를 작성하는 태그
     --%>
    <%
        name = "홍길동";
        age = 20;

        System.out.println("name = " + name);
        System.out.println("age = " + age);

        /* 간단한 로직도 작성 가능 */
        for (int i = 0; i < 10; i++) {
    %>
        <%-- 5. expression 태그
            PrintWriter를 이용해 브라우저로 출력하는 태그
        --%>
        <h5><%= i + " 반복 중..."%></h5>
    <%
        }
    %>


</body>
</html>

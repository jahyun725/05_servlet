package com.ohgiraffers.chap04forwardredirectlecturesource.section01.forward;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/print")
public class PrintLoginSuccess extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /* forward 된 servlet 에서도 요청 방식이 그대로 유지 된다. post -> post
     * 또한 전달 된 req, resp 의 모든 정보를 이용해
     * 새로운 req, resp를 깊은 복사를 통해 만들어
     * 전달하므로 데이터가 그대로 유지 된다. */

    String userId = request.getParameter("userId");
    String password = request.getParameter("password");

    StringBuilder sb = new StringBuilder();

    sb.append("<html>")
        .append("<head><title>로그인 성공페이지</title></head>")
        .append("<body>")
        .append("<h3>userId : ").append(userId).append("</h3>")
        .append("<h3>password : ").append(password).append("</h3>")
        .append("</body>")
        .append("</html>");

    response.setContentType("text/html");

    PrintWriter out = response.getWriter();
    out.print(sb.toString());
    out.flush();
    out.close();

  }

}
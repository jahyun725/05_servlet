package com.ohgiraffers.chap01lifecyclelecturesource.section03.servicemethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(value="/request-service")
public class ServiceMethodTest extends HttpServlet {

  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // HttpServletRequest
    // - HTTP로 전달되어진 요청과 관련된 정보를 모두 담고 있는 객체
    // - 요청방식(method), 전달 값(parameter), 클라리언트 정보(ip)

    String httpMethod = req.getMethod();
    System.out.println("httpMethod = " + httpMethod);

    if ("GET".equals(httpMethod)) {
      doGet(req, resp);
    } else if ("POST".equals(httpMethod)) {
      doPost(req, resp);
    }

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("GET 방식의 요청 처리 메서드");
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("POST 방식의 요청 처리 메서드");
  }
}

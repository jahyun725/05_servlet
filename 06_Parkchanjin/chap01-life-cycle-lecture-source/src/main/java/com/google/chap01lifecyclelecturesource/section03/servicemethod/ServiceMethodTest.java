package com.google.chap01lifecyclelecturesource.section03.servicemethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/request-service")
public class ServiceMethodTest extends HttpServlet {


  @Override
  protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{

    // HttpServletRequest
    // - HTTP로 전달된 요청과 관련
    // - 요청 방식(method), 전달 값(parameter), 클라이언트 정보(ip) 등...
    String httpMethod = req.getMethod();
    System.out.println("httpMethod = " + httpMethod);

    if("GET".equals(httpMethod)){
      doGet(req, resp);
    }else if("POST".equals(httpMethod)){
      doPost(req, resp);
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("POST 방식의 요청 처리 메서드 ");

  }

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("GET 방식의 요청 처리 메서드");
  }
}

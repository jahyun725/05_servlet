package com.google.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Date;

@WebServlet(value = "/headers")
public class ResponseHeaderPrint extends HttpServlet {

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    // tomcat 10부터 mime type이 기재되면 자동으로 UTF-8로 문자셋이 설정됨
    resp.setContentType("text/html");

    long currentTime = System.currentTimeMillis();
    LocalDateTime now = LocalDateTime.now();


    StringBuilder sb = new StringBuilder();
    sb.append("<html>")
        .append("<head>")
        .append("<title>응답페이지</title>")
        .append("</head>")
        .append("<body>")
        .append("<h3>").append(currentTime).append("ms</h3>")
        .append("<h3>").append(now).append("</h3>")
        .append("</body>")
        .append("</html>");

    PrintWriter printWriter = resp.getWriter();
    printWriter.println(sb.toString());
    printWriter.flush();
    printWriter.close();


    /* response header 정보 (응답 완료 후에 출력 가능)*/
    Collection<String> responseHeaders = resp.getHeaderNames();
    for(String name : responseHeaders){

      System.out.println(name + " : " + resp.getHeader(name));
    }


  }
}
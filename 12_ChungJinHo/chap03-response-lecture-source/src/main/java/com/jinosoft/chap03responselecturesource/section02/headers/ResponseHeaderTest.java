package com.jinosoft.chap03responselecturesource.section02.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collection;

@WebServlet(value = "/headers")
public class ResponseHeaderTest extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    /* tomcat 10부터 mime type이 기재돠면 자동으로 UTF-8로 문자셋 설정 */
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

    PrintWriter pw = resp.getWriter();
    pw.write(sb.toString());
    pw.flush();
    pw.close();
    /* response header 정보 */
    Collection<String> responseHeaders = resp.getHeaderNames();
    for (String name : responseHeaders) {
      System.out.println(name + ": " + resp.getHeader(name));
    }




  }
}

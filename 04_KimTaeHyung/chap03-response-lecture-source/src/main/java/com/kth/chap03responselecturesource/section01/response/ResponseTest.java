package com.kth.chap03responselecturesource.section01.response;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value="/response")
public class ResponseTest extends HttpServlet {
  /* 기본적인 요청-응답 순서
  * 1. 요청을 받아 처리한다 => 파라미터 꺼내기(req.getParameter())
  * 2. 비즈니스 로직을 처리한다 => DB 접속 및 CRUD 수행
  * 3. 응답을 처리한다
  *  => resp을 이용해서 결과 웹을 만들고(동적 웹, HTML 코드)
  *    스트림을 통해서 클라이언트에게 출력
  * */


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    /* 문자열을 이용해 사용자에게 응답 보낼 HTML 페이지 작성 */
    StringBuilder sb = new StringBuilder();

    sb.append("<html>")
        .append("<head>")
        .append("<title>응답페이지</title>")
        .append("</head>")
        .append("<body>")
        .append("<h1>안녕 Servlet Response</h1>");

    // 요청 파라미터(쿼리스트링) 중 message가 있을 경우
    if(req.getParameter("message") != null){
      sb.append("<h3 style='color:red'>")
          .append(req.getParameter("message"))
          .append("</h3>");
    }

    sb.append("</body>")
        .append("</html>");

//    resp.setContentType("text/html");    // 응답 데이터의 MINE typee 설정
//    resp.setCharacterEncoding("UTF-8");  // 응답 데이터의 문자 셋 설정

    // 위 두개 하나로 합칠 경우 코드
    resp.setContentType("text/html; charset=UTF-8");

    // 클라이언트 브라우저와 연결된 출력 스트림 얻어오기
    PrintWriter printWriter = resp.getWriter();
    printWriter.print(sb.toString()); // html 코드 출력하기
    printWriter.flush();
    printWriter.close();


  }
}

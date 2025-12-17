package com.ohgiraffers.chap05cookiesessionlecturesource.section01.cookie;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/cookie")
public class CookieHandler extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /* 전달 받은 데이터(파라미터) 얻어오기 */
    String firstName = request.getParameter("firstName");
    String lastName  = request.getParameter("lastName");

    /* 1. 쿠키 생성 */
    Cookie cookie1 = new Cookie("firstName", firstName);
    Cookie cookie2 = new Cookie("lastName", lastName);

    /* 2. 쿠키 만료 시간 설정 */
    cookie1.setMaxAge(60 * 60 * 24); // 초 단위로 입력
    cookie2.setMaxAge(60 * 60 * 24); // (만약 0 입력 -> 0초짜리 쿠키로 덮어쓰기 == 삭제)

    /* 3. 응답 헤더에 쿠키를 담아서 클라이언트에게 전달 */
    response.addCookie(cookie1);
    response.addCookie(cookie2);

    response.sendRedirect("/cookie-redirect");

  }
}
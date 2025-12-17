package com.ohgiraffers.chap04forwardredirectlecturesource.section02.redirect;

import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/othersite")
public class OtherSiteRedirect extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    System.out.println("Get 요청 후 naver로 redirect");
    response.sendRedirect("https://www.naver.com");
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }
}
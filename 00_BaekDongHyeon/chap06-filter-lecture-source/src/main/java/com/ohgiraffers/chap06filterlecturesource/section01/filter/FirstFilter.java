package com.ohgiraffers.chap06filterlecturesource.section01.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;


/* @WebFilter("url패턴")
* - 해당 클래스를 필터로 등록하고
*   url 패턴에 맞는 요청 또는 응답을 필터링 하는 어노테이션
* */
@WebFilter("/first/*")
public class FirstFilter implements Filter {

  /* 필터가 처음 만들어 졌을 때 수행되는 메서드
  * - 한 번 만들어진 필터는 서버가 꺼질 때 까지 계속 유지됨
  * */
  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    System.out.println("First Filter init 메서드 호출");
  }

  /* 실제 필터링 코드를 작성하고
  * 다음 필터 또는 Servlet으로 연결해주는 메서드
  * */
  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
    System.out.println("First Filter doFilter 메서드 호출");

    // 현재 필터에서 다음 필터를 호출하는 코드
    // 다음 필터가 없다면 Servlet을 호출
    filterChain.doFilter(servletRequest, servletResponse);

    System.out.println("***** 서블릿 요청 수행 완료 *****");
  }

   /* 필터가 제거될 때 수행되는 메서드
   * - 서버 종료 시 수행
   * */
  @Override
  public void destroy() {
    System.out.println("First Filter destroy 메서드 호출");
  }
}

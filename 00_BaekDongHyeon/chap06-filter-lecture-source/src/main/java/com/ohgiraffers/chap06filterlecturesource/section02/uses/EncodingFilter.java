package com.ohgiraffers.chap06filterlecturesource.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/* web.xml로 등록 하기 */
public class EncodingFilter implements Filter {

  // web.xml에 등록된 문자 인코딩 파라미터 얻어와 저장할 변수
  private String encodingType;

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
    encodingType = filterConfig.getInitParameter("encoding-type");
  }

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    System.out.println("Encoding 필터 동작!!!");

    /* POST 방식 요청이 오면 문자 셋을 설정하는 전처리 작업 */
    HttpServletRequest req = (HttpServletRequest)servletRequest;
    if("POST".equals(req.getMethod())){
      servletRequest.setCharacterEncoding(encodingType);
    }

    filterChain.doFilter(servletRequest,servletResponse);

  }

  @Override
  public void destroy() {}
}

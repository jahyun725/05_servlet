package com.ohgiraffers.chap06filterlecturesource.section02.uses;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

@WebFilter("/member/*")
public class PasswordEncryptFilter implements Filter {

  @Override
  public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

    HttpServletRequest request = (HttpServletRequest) servletRequest;

    /* Servlet Wrapper 상속 받은 객체를 생성 */
    RequestWrapper requestWrapper = new RequestWrapper(request);

    filterChain.doFilter(requestWrapper, servletResponse);

  }

}

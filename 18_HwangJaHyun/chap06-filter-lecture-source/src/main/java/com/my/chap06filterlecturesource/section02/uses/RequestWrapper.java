package com.my.chap06filterlecturesource.section02.uses;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class RequestWrapper extends HttpServletRequestWrapper {

  /* Servlet Wrapper를 이용하려면
  * HttpServletRequest/HttpServletResponse를
  * 매개변수로 전달 받는 생성자가 필요하다.*/
  public RequestWrapper(HttpServletRequest request) {
    super(request);
  }

  /* 요청 시 전달된 값을 얻어오게하는 메서드를 오버라이딩 */
  @Override
  public String getParameter(String name) {
    if("password".equals(name)) {
      BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
      return encoder.encode(super.getParameter(name));
    }
    else return super.getParameter(name); // 원본 기능
  }
}

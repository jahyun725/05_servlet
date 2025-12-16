package com.jinosoft.chap01lifecyclelecturesource.section02.annotation;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;


/* 어노테이션 방식으로 Servlet 등록 + 매핑
*
* @WebServlet(value="url") : 해당 Servlet Class를 Servlet 컨테이너에 등록
* value 속성 : Servlet 매핑
* */

@WebServlet(value = "/annotation-lifecycle", loadOnStartup = 1)
public class LifeCycleTest extends HttpServlet {

  @Override
  public void init() throws ServletException {
    System.out.println("***** Annotation 매핑 init() method called *****");
  }

  @Override
  public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
    System.out.println(" @@@@@ Annotation 매핑 service() method called @@@@@");
  }

  @Override
  public void destroy() {
    System.out.println("xxxxx Annotation 매핑 destroy() method called xxxxx");
  }

  public LifeCycleTest(){
    System.out.println("LifeCycleTest");

  }
}

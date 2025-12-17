package com.ohgiraffers.chap01lifecyclelecturesource.section01.xml;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;

/* Servlet Class : 자바를 이용해서 요청, 응답 처리를 할 수 있게 만든 클래스
*
* - Servlet Class를 만 드는 방법
*  HttpServlet Class를 상속 받ㅇ아서 필요한 메서드를 오버라이딩
*
* - Servlet의 생명 주기
* - init() : Servlet 최초 호출 또는 서버 배포시
*           해당 클래스를 인스턴스화 하면서 실행됨
*
* - service() : 클라이언트 요청에 대한 서비슿를 제공하는 메서드
*
* - destory() : 서버 재시작 또는 종료 시점에 서블릿 인스턴스 소멸하면서
*               실행되는 메서드
*
*  - Sevlet 등록
*       HttpServlet을 상속 받은 클래스를 등록해서
*        Servlet Container가 관리하고, 요청/응답 처리를 할 수 있게 만드는 과정
* - xml방식, 어노테이션 방식 두 가지가 있음
* */
public class LifeCycleTest extends HttpServlet {
    public LifeCycleTest(){
        System.out.println("=========== xml 매핑 호출자 호출 =============");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("***********  XML 매핑 init() 메서드 호출************");

    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        System.out.println("***********  XML 매핑 service() 메서드 호출************");

    }

    @Override
    public void destroy() {

        System.out.println("***********  XML 매핑 destory() 메서드 호출************");

    }


}

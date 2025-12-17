package com.ohgiraffers.chap01lifecyclelecturesource.section03.servicemethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(value = "/request-service") // 클래스 위에 적기
public class ServiceMethodTest extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);

        /* HttpServletRequest
        * - HTTP로 전달되어진 요철과 관련된 정보를 모두 담고 있는 객체
        * - 요청 방식(Method),  전달 값 (parameter), 클라이언트 정보(ip) 등등...*/

        String httpMethod = req.getMethod();
        System.out.println("httpMethod = " + httpMethod);

        if("GET".equals(httpMethod)){
            doGet(req,resp);
        }else if ("POST".equals(httpMethod)){
            doPost(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("GET방식의 요청처리 메서드");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("POST방식의 요청처리 메서드");
    }
}

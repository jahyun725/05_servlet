package com.ohgiraffers.chap02requestlecturesource.section03.headers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet(value="/headers")
public class RequestHeaderPrint extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        /* 요청 헤더(브라우저 → 서버): 클라이언트의 "선호/환경/요청 맥락" 정보
         * accept : 요청을 보낼 때 서버에게 요청할 응답 타입 명시 (예: text/html, application/json)
         * accept-encoding : 응답 시 선호하는 인코딩 방식 (예: gzip, br)  ※문자 인코딩과 다름
         * accept-language : 응답 시 선호하는 언어/지역(예: ko-KR, en-US)
         * connection : HTTP 통신이 완료된 후에 네트워크 접속을 유지할지 결정 (기본값: keep-alive = 연결을 열린 상태로 유지)
         * host : 서버의 도메인 네임과 서버가 현재 Listening 중인 TCP포트 지정 (반드시 하나가 존재. 없거나 둘 이상이면 404)
         * referer : 이 페이지 이전에 대한 주소
         * sec-fetch-dest : 어떤 리소스를 받는 요청인지(document/image/script 등)
         * sec-fetch-mode : 요청 모드(navigate/cors/no-cors 등)
         * sec-fetch-site : 출처 관계(same-origin/same-site/cross-site/none)
         * sec-fetch-user : 사용자 동작으로 시작된 내비게이션이면 ?1
         * cache-control : 캐시 정책(no-cache/no-store/max-age 등)
         * upgrade-insecure-requests : 가능하면 HTTPS로 업그레이드 요청(보통 1)
         * user-agent : 현재 사용자가 어떤 클라이언트(OS, browser 포함)을 이용해 보낸 요청인지 명시
         * */
        Enumeration<String> headerNames = req.getHeaderNames();
        String name;
        while (headerNames.hasMoreElements()) {
            name = headerNames.nextElement();
            System.out.print(name + ", ");
            //System.out.println(name + " : " + req.getHeader(name));

            System.out.println("\n--------------------------------------------------------------------\n");

            System.out.println("accept : " + req.getHeader("accept"));
            System.out.println("accept-encoding : " + req.getHeader("accept-encoding"));
            System.out.println("accept-language : " + req.getHeader("accept-language"));
            System.out.println("connection : " + req.getHeader("connection"));
            System.out.println("host : " + req.getHeader("host"));
            System.out.println("referer : " + req.getHeader("referer"));
            System.out.println("sec-fetch-dest : " + req.getHeader("sec-fetch-dest"));
            System.out.println("sec-fetch-mode : " + req.getHeader("sec-fetch-mode"));
            System.out.println("sec-fetch-site : " + req.getHeader("sec-fetch-site"));
            System.out.println("sec-fetch-user : " + req.getHeader("sec-fetch-user"));
            System.out.println("cache-control : " + req.getHeader("cache-control"));
            System.out.println("upgrade-insecure-requests : " + req.getHeader("upgrade-insecure-requests"));
            System.out.println("user-agent : " + req.getHeader("user-agent"));
        }
    }
}

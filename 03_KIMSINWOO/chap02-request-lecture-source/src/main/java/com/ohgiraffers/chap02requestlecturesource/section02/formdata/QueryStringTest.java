package com.ohgiraffers.chap02requestlecturesource.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Date;
import java.util.Arrays;

// tip. 매핑 주소는
@WebServlet(value = "/formdata")
public class QueryStringTest extends HttpServlet {

    /* 서블릿에 매핑된 주소로 POST방식 요청이 발생하면 호출되는 메서드 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        /* 매개 변수 HttpServletRequest req에는
        * 클라이언트의 요청 정보가 담겨오는 객체를 참조하는 주소가 들어있음
        * - 요청 시 전달한 데이터는 req.getParameter(KEY)로 추출 가능
        * - 기본적으로 전달 받은 데이터는 모두 String type
        * - KEY 역할의 문자열은 Input 태그의 name 속성 값이다.
        * */
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        Date birthday = Date.valueOf(req.getParameter("birthday"));
        String gender = req.getParameter("gender");
        String national = req.getParameter("national");

        // checkbox는 다중으로 값을 입력 할 수 있어서 제출 시 String[] 형태로 전달된다
        String[] hobbies = req.getParameterValues("hobbies");

        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("birthday = " + birthday);
        System.out.println("gender = " + gender);
        System.out.println("national = " + national);
        System.out.println("hobbies = " + Arrays.toString(hobbies));

    }
}

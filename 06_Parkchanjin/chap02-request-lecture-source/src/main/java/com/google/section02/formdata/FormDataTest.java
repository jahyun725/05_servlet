package com.google.section02.formdata;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;

@WebServlet(value="/formdata")
public class FormDataTest extends HttpServlet{

    /* 서블릿에 매핑된 주소로 POST 방식 요청이 발생하면 호출되는 메서드 */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      /* 매개 변수 HttpServletRequest req 에는
       *  클라이언트의 요청 정보가 담겨있는 객체를 참조하는 주소가 들어있음.
       *
       * - 요청 시 전달한 데이터는 req.getParameter(KEY)으로 추출 가능.
       * - 기본적으로 전달 받은 데이터는 모두 String 타입
       * - KEY 역할의 문자열은 input 태그의 name 속성 값이다.
       * */
      String name = req.getParameter("name");
      int age = Integer.parseInt(req.getParameter("age")); //integer.parseint == 파싱.
      java.sql.Date birthday
          = java.sql.Date.valueOf(req.getParameter("birthday"));

      String gender = req.getParameter("gender");
      String national = req.getParameter("national");

      // checkbox는 다중으로 값을 입력할 수 있어서
      // 제출 시 String[] 형태로 저장된다
      String[] hobbies = req.getParameterValues("hobby");


      System.out.println("name = " + name);
      System.out.println("age = " + age);
      System.out.println("birthday = " + birthday);
      System.out.println("gender = " + gender);
      System.out.println("national = " + national);
      System.out.println("hobbies = " + Arrays.toString(hobbies));
    }
  }


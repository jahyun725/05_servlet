package com.jinosoft.chap03responselecturesource.section03.exception;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

/* 커스텀 에러 페이지 */
@WebServlet(value = "/showErrorPage")
public class ExceptionHandler extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    Enumeration<String> attrs = req.getAttributeNames();
    while(attrs.hasMoreElements()) {
      String attr = attrs.nextElement();
      System.out.println(attr + " : " + req.getAttribute(attr));
    }

    int statusCode = (int)req.getAttribute("jakarta.servlet.error.status_code");
    String message = (String)req.getAttribute("jakarta.servlet.error.message");
    String servletName = (String)req.getAttribute("jakarta.servlet.error.servlet_name");

    String errorTitle = getErrorTitle(statusCode);
    String errorDescription = getErrorDescription(statusCode);

    StringBuilder sb = new StringBuilder();
    sb.append("<!DOCTYPE html>")
        .append("<html lang='ko'>")
        .append("<head>")
        .append("<meta charset='UTF-8'>")
        .append("<meta name='viewport' content='width=device-width, initial-scale=1.0'>")
        .append("<title>").append(statusCode).append(" - ").append(errorTitle).append("</title>")
        .append("<style>")
        .append("* { margin: 0; padding: 0; box-sizing: border-box; }")
        .append("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; ")
        .append("background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); ")
        .append("min-height: 100vh; display: flex; align-items: center; justify-content: center; ")
        .append("color: #fff; overflow: hidden; }")
        .append(".error-container { text-align: center; padding: 40px; ")
        .append("background: rgba(255, 255, 255, 0.1); backdrop-filter: blur(10px); ")
        .append("border-radius: 20px; box-shadow: 0 8px 32px rgba(0, 0, 0, 0.1); ")
        .append("border: 1px solid rgba(255, 255, 255, 0.2); max-width: 600px; ")
        .append("animation: fadeInUp 0.6s ease-out; }")
        .append(".error-code { font-size: 120px; font-weight: 900; ")
        .append("background: linear-gradient(45deg, #fff, #e0e0e0); ")
        .append("-webkit-background-clip: text; -webkit-text-fill-color: transparent; ")
        .append("margin-bottom: 20px; animation: pulse 2s ease-in-out infinite; }")
        .append(".error-title { font-size: 32px; font-weight: 600; margin-bottom: 15px; ")
        .append("text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2); }")
        .append(".error-description { font-size: 18px; margin-bottom: 25px; ")
        .append("opacity: 0.9; line-height: 1.6; }")
        .append(".error-details { background: rgba(0, 0, 0, 0.2); padding: 20px; ")
        .append("border-radius: 10px; margin: 25px 0; text-align: left; ")
        .append("font-size: 14px; line-height: 1.8; }")
        .append(".error-details strong { color: #ffd700; }")
        .append(".btn-home { display: inline-block; padding: 15px 40px; ")
        .append("background: linear-gradient(45deg, #f093fb 0%, #f5576c 100%); ")
        .append("color: white; text-decoration: none; border-radius: 50px; ")
        .append("font-weight: 600; font-size: 16px; transition: transform 0.3s ease, box-shadow 0.3s ease; ")
        .append("box-shadow: 0 4px 15px rgba(0, 0, 0, 0.2); margin-top: 10px; }")
        .append(".btn-home:hover { transform: translateY(-3px); ")
        .append("box-shadow: 0 6px 20px rgba(0, 0, 0, 0.3); }")
        .append(".floating-shapes { position: fixed; top: 0; left: 0; width: 100%; ")
        .append("height: 100%; pointer-events: none; z-index: -1; }")
        .append(".shape { position: absolute; opacity: 0.1; }")
        .append(".shape:nth-child(1) { top: 10%; left: 10%; width: 80px; height: 80px; ")
        .append("background: white; border-radius: 50%; animation: float 6s ease-in-out infinite; }")
        .append(".shape:nth-child(2) { top: 60%; right: 15%; width: 60px; height: 60px; ")
        .append("background: white; border-radius: 50%; animation: float 8s ease-in-out infinite 1s; }")
        .append(".shape:nth-child(3) { bottom: 20%; left: 20%; width: 100px; height: 100px; ")
        .append("background: white; transform: rotate(45deg); animation: float 7s ease-in-out infinite 2s; }");

    // 500 에러일 때 도게자 캐릭터 추가
    if(statusCode == 500) {
      sb.append(".dogeza-container { margin: 30px 0; position: relative; height: 150px; }")
          .append(".dogeza-character { width: 120px; height: 120px; position: absolute; ")
          .append("left: 50%; transform: translateX(-50%); animation: dogeza 1.5s ease-in-out infinite; }")
          .append(".character-body { width: 80px; height: 60px; background: #fff; ")
          .append("border-radius: 40px 40px 10px 10px; position: absolute; top: 40px; left: 20px; }")
          .append(".character-head { width: 50px; height: 50px; background: #fff; ")
          .append("border-radius: 50%; position: absolute; top: 10px; left: 35px; }")
          .append(".character-face { position: absolute; top: 20px; left: 10px; ")
          .append("width: 30px; height: 20px; }")
          .append(".eye { width: 4px; height: 8px; background: #333; ")
          .append("border-radius: 50%; position: absolute; top: 5px; }")
          .append(".eye.left { left: 8px; }")
          .append(".eye.right { right: 8px; }")
          .append(".mouth { width: 15px; height: 8px; border: 2px solid #333; ")
          .append("border-top: none; border-radius: 0 0 15px 15px; ")
          .append("position: absolute; bottom: 2px; left: 50%; transform: translateX(-50%); }")
          .append(".arm { width: 30px; height: 15px; background: #fff; ")
          .append("border-radius: 10px; position: absolute; }")
          .append(".arm.left { top: 50px; left: 10px; transform: rotate(-20deg); }")
          .append(".arm.right { top: 50px; right: 10px; transform: rotate(20deg); }")
          .append(".apology-text { position: absolute; top: -10px; left: 50%; ")
          .append("transform: translateX(-50%); font-size: 24px; font-weight: bold; ")
          .append("color: #fff; text-shadow: 2px 2px 4px rgba(0,0,0,0.3); ")
          .append("animation: apologyPulse 1.5s ease-in-out infinite; white-space: nowrap; }")
          .append("@keyframes dogeza { ")
          .append("0%, 100% { transform: translateX(-50%) translateY(0) rotateX(0deg); } ")
          .append("50% { transform: translateX(-50%) translateY(20px) rotateX(60deg); } }")
          .append("@keyframes apologyPulse { ")
          .append("0%, 100% { opacity: 1; transform: translateX(-50%) scale(1); } ")
          .append("50% { opacity: 0.7; transform: translateX(-50%) scale(1.1); } }");
    }

    sb.append("@keyframes fadeInUp { from { opacity: 0; transform: translateY(30px); } ")
        .append("to { opacity: 1; transform: translateY(0); } }")
        .append("@keyframes pulse { 0%, 100% { transform: scale(1); } ")
        .append("50% { transform: scale(1.05); } }")
        .append("@keyframes float { 0%, 100% { transform: translateY(0px); } ")
        .append("50% { transform: translateY(-20px); } }")
        .append("</style>")
        .append("</head>")
        .append("<body>")
        .append("<div class='floating-shapes'>")
        .append("<div class='shape'></div>")
        .append("<div class='shape'></div>")
        .append("<div class='shape'></div>")
        .append("</div>")
        .append("<div class='error-container'>")
        .append("<div class='error-code'>").append(statusCode).append("</div>");

    // 500 에러일 때 도게자 캐릭터 표시
    if(statusCode == 500) {
      sb.append("<div class='dogeza-container'>")
          .append("<div class='apology-text'>정말 죄송합니다! 🙇</div>")
          .append("<div class='dogeza-character'>")
          .append("<div class='character-head'>")
          .append("<div class='character-face'>")
          .append("<div class='eye left'></div>")
          .append("<div class='eye right'></div>")
          .append("<div class='mouth'></div>")
          .append("</div>")
          .append("</div>")
          .append("<div class='character-body'></div>")
          .append("<div class='arm left'></div>")
          .append("<div class='arm right'></div>")
          .append("</div>")
          .append("</div>");
    }

    sb.append("<div class='error-title'>").append(errorTitle).append("</div>")
        .append("<div class='error-description'>").append(errorDescription).append("</div>")
        .append("<div class='error-details'>")
        .append("<strong>메시지:</strong> ").append(message != null ? message : "N/A").append("<br>")
        .append("<strong>서블릿:</strong> ").append(servletName != null ? servletName : "N/A")
        .append("</div>")
        .append("<a href='/' class='btn-home'>홈으로 돌아가기</a>")
        .append("</div>")
        .append("</body>")
        .append("</html>");

    resp.setContentType("text/html; charset=UTF-8");
    PrintWriter printWriter = resp.getWriter();
    printWriter.println(sb);
    printWriter.flush();
    printWriter.close();
  }

  private String getErrorTitle(int statusCode) {
    switch(statusCode) {
      case 400: return "잘못된 요청";
      case 401: return "인증 필요";
      case 403: return "접근 거부";
      case 404: return "페이지를 찾을 수 없습니다";
      case 405: return "허용되지 않은 메서드";
      case 500: return "서버 오류 - 정말 죄송합니다";
      case 502: return "게이트웨이 오류";
      case 503: return "서비스 이용 불가";
      default: return "오류 발생";
    }
  }

  private String getErrorDescription(int statusCode) {
    switch(statusCode) {
      case 400: return "요청을 처리할 수 없습니다. 입력한 정보를 다시 확인해주세요.";
      case 401: return "이 페이지에 접근하려면 로그인이 필요합니다.";
      case 403: return "이 페이지에 접근할 권한이 없습니다.";
      case 404: return "요청하신 페이지를 찾을 수 없습니다. URL을 확인해주세요.";
      case 405: return "요청 메서드가 허용되지 않습니다.";
      case 500: return "저희 서버에 문제가 발생했습니다. 빠른 시일 내에 복구하겠습니다. 불편을 드려 대단히 죄송합니다.";
      case 502: return "게이트웨이 오류가 발생했습니다.";
      case 503: return "서비스를 일시적으로 사용할 수 없습니다.";
      default: return "예상치 못한 오류가 발생했습니다.";
    }
  }
}
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Request Test</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            min-height: 100vh;
            padding: 40px 20px;
        }

        .container {
            max-width: 900px;
            margin: 0 auto;
        }

        h1 {
            color: white;
            text-align: center;
            margin-bottom: 40px;
            font-size: 2.5em;
            text-shadow: 2px 2px 4px rgba(0,0,0,0.2);
        }

        .form-section {
            background: white;
            border-radius: 20px;
            padding: 40px;
            margin-bottom: 30px;
            box-shadow: 0 10px 40px rgba(0,0,0,0.1);
        }

        h2 {
            color: #667eea;
            margin-bottom: 10px;
            font-size: 1.8em;
        }

        h3 {
            color: #666;
            margin-bottom: 25px;
            font-size: 1.1em;
            font-weight: normal;
        }

        form {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .form-group {
            display: flex;
            flex-direction: column;
            gap: 8px;
        }

        label:not([for*="male"]):not([for*="female"]):not([for*="movie"]):not([for*="music"]):not([for*="sleep"]) {
            font-weight: 600;
            color: #333;
            font-size: 0.95em;
        }

        input[type="text"],
        input[type="number"],
        input[type="date"],
        select {
            padding: 12px 16px;
            border: 2px solid #e0e0e0;
            border-radius: 10px;
            font-size: 16px;
            transition: all 0.3s ease;
            outline: none;
        }

        input[type="text"]:focus,
        input[type="number"]:focus,
        input[type="date"]:focus,
        select:focus {
            border-color: #667eea;
            box-shadow: 0 0 0 3px rgba(102, 126, 234, 0.1);
        }

        .radio-group,
        .checkbox-group {
            display: flex;
            gap: 20px;
            flex-wrap: wrap;
        }

        .radio-item,
        .checkbox-item {
            display: flex;
            align-items: center;
            gap: 8px;
        }

        input[type="radio"],
        input[type="checkbox"] {
            width: 20px;
            height: 20px;
            cursor: pointer;
            accent-color: #667eea;
        }

        input[type="radio"] + label,
        input[type="checkbox"] + label {
            cursor: pointer;
            color: #555;
            font-weight: normal;
        }

        input[type="submit"] {
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            border: none;
            padding: 15px 30px;
            border-radius: 10px;
            font-size: 1.1em;
            font-weight: 600;
            cursor: pointer;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(102, 126, 234, 0.4);
        }

        input[type="submit"]:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(102, 126, 234, 0.5);
        }

        input[type="submit"]:active {
            transform: translateY(0);
        }

        .header-link {
            background: white;
            border-radius: 20px;
            padding: 30px;
            text-align: center;
            box-shadow: 0 10px 40px rgba(0,0,0,0.1);
        }

        .header-link h1 {
            color: #667eea;
            margin-bottom: 20px;
            font-size: 2em;
        }

        .header-link a {
            display: inline-block;
            background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
            color: white;
            text-decoration: none;
            padding: 15px 40px;
            border-radius: 10px;
            font-weight: 600;
            font-size: 1.1em;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(102, 126, 234, 0.4);
        }

        .header-link a:hover {
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(102, 126, 234, 0.5);
        }

        select {
            cursor: pointer;
            background-color: white;
        }

        @media (max-width: 768px) {
            .form-section {
                padding: 25px;
            }

            h1 {
                font-size: 2em;
            }

            h2 {
                font-size: 1.5em;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Request Parameter</h1>

    <div class="form-section">
        <h2>GET 방식의 요청</h2>
        <h3>form 태그를 이용한 get 방식 요청</h3>
        <form action="querystring" method="get">
            <div class="form-group">
                <label>이름</label>
                <input type="text" name="name" placeholder="이름을 입력하세요">
            </div>

            <div class="form-group">
                <label>나이</label>
                <input type="number" name="age" placeholder="나이를 입력하세요">
            </div>

            <div class="form-group">
                <label>생일</label>
                <input type="date" name="birthday">
            </div>

            <div class="form-group">
                <label>성별</label>
                <div class="radio-group">
                    <div class="radio-item">
                        <input type="radio" name="gender" id="male" value="M">
                        <label for="male">남자</label>
                    </div>
                    <div class="radio-item">
                        <input type="radio" name="gender" id="female" value="F">
                        <label for="female">여자</label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label>국적</label>
                <select name="national">
                    <option value="ko">한국</option>
                    <option value="ch">중국</option>
                    <option value="jp">일본</option>
                    <option value="etc">기타</option>
                </select>
            </div>

            <div class="form-group">
                <label>취미</label>
                <div class="checkbox-group">
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" id="movie" value="movie">
                        <label for="movie">영화</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" id="music" value="music">
                        <label for="music">음악</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" id="sleep" value="sleep">
                        <label for="sleep">취침</label>
                    </div>
                </div>
            </div>

            <input type="submit" value="GET 요청">
        </form>
    </div>

    <div class="form-section">
        <h2>POST 방식의 요청</h2>
        <h3>form 태그를 이용한 post 방식 요청</h3>
        <form action="formdata" method="post">
            <div class="form-group">
                <label>이름</label>
                <input type="text" name="name" placeholder="이름을 입력하세요">
            </div>

            <div class="form-group">
                <label>나이</label>
                <input type="number" name="age" placeholder="나이를 입력하세요">
            </div>

            <div class="form-group">
                <label>생일</label>
                <input type="date" name="birthday">
            </div>

            <div class="form-group">
                <label>성별</label>
                <div class="radio-group">
                    <div class="radio-item">
                        <input type="radio" name="gender" id="male2" value="M">
                        <label for="male2">남자</label>
                    </div>
                    <div class="radio-item">
                        <input type="radio" name="gender" id="female2" value="F">
                        <label for="female2">여자</label>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label>국적</label>
                <select name="national">
                    <option value="ko">한국</option>
                    <option value="ch">중국</option>
                    <option value="jp">일본</option>
                    <option value="etc">기타</option>
                </select>
            </div>

            <div class="form-group">
                <label>취미</label>
                <div class="checkbox-group">
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" id="movie2" value="movie">
                        <label for="movie2">영화</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" id="music2" value="music">
                        <label for="music2">음악</label>
                    </div>
                    <div class="checkbox-item">
                        <input type="checkbox" name="hobbies" id="sleep2" value="sleep">
                        <label for="sleep2">취침</label>
                    </div>
                </div>
            </div>

            <input type="submit" value="POST 요청">
        </form>
    </div>

    <div class="header-link">
        <h1>Request Header 값 확인</h1>
        <a href="headers">헤더 정보 보기</a>
    </div>
</div>
</body>
</html>
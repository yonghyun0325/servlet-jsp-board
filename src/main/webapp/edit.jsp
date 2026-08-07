<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 수정 - Legacy Board</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            margin: 0;
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
        }

        .container {
            width: 900px;
            margin: 60px auto;
            background-color: white;
            padding: 40px;
            border-radius: 8px;
        }

        h1 {
            margin-top: 0;
            margin-bottom: 10px;
        }

        .description {
            color: #666;
            margin-bottom: 40px;
        }

        .form-group {
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-bottom: 8px;
            font-weight: bold;
        }

        input,
        textarea {
            width: 100%;
            padding: 12px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 15px;
        }

        textarea {
            min-height: 300px;
            resize: vertical;
        }

        .button-area {
            display: flex;
            justify-content: flex-end;
            gap: 10px;
            margin-top: 30px;
        }

        .button {
            display: inline-block;
            padding: 11px 20px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            cursor: pointer;
            font-size: 14px;
        }

        .cancel-button {
            background-color: #eee;
            color: #222;
        }

        .submit-button {
            background-color: #222;
            color: white;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>게시글 수정</h1>

    <p class="description">
        게시글 내용을 수정합니다.
    </p>

    <form action="#" method="post">

        <div class="form-group">
            <label for="title">제목</label>

            <input
                    type="text"
                    id="title"
                    name="title"
                    value="Servlet 공부 중입니다."
            >
        </div>

        <div class="form-group">
            <label for="writer">작성자</label>

            <input
                    type="text"
                    id="writer"
                    name="writer"
                    value="홍길동"
            >
        </div>

        <div class="form-group">
            <label for="content">내용</label>

            <textarea
                    id="content"
                    name="content"
            >Servlet과 JSP를 이용해서 게시판을 만들어보고 있습니다.

Spring Boot 없이 직접 Servlet과 JSP를 사용하여
전통적인 Java 웹 애플리케이션 구조를 공부하고 있습니다.

앞으로 JDBC와 PostgreSQL도 연결할 예정입니다.</textarea>

        </div>

        <div class="button-area">

            <a href="detail.jsp" class="button cancel-button">
                취소
            </a>

            <button type="submit" class="button submit-button">
                수정 완료
            </button>

        </div>

    </form>

</div>

</body>
</html>
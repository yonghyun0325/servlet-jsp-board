<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>글쓰기 - Legacy Board</title>

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

    <h1>게시글 작성</h1>

    <p class="description">
        새로운 게시글을 작성합니다.
    </p>

    <form action="#" method="post">

        <div class="form-group">
            <label for="title">제목</label>

            <input
                    type="text"
                    id="title"
                    name="title"
                    placeholder="제목을 입력해주세요."
            >
        </div>

        <div class="form-group">
            <label for="writer">작성자</label>

            <input
                    type="text"
                    id="writer"
                    name="writer"
                    placeholder="작성자를 입력해주세요."
            >
        </div>

        <div class="form-group">
            <label for="content">내용</label>

            <textarea
                    id="content"
                    name="content"
                    placeholder="내용을 입력해주세요."
            ></textarea>
        </div>

        <div class="button-area">

            <a href="index.jsp" class="button cancel-button">
                취소
            </a>

            <button type="submit" class="button submit-button">
                등록
            </button>

        </div>

    </form>

</div>

</body>
</html>
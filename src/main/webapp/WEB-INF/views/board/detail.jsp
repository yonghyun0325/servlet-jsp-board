<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시글 상세 - Legacy Board</title>

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

        .post-header {
            border-top: 2px solid #222;
            border-bottom: 1px solid #ddd;
            padding: 25px 10px;
        }

        .post-title {
            margin: 0 0 20px;
            font-size: 24px;
        }

        .post-info {
            display: flex;
            gap: 30px;
            color: #666;
            font-size: 14px;
        }

        .post-content {
            min-height: 300px;
            padding: 40px 10px;
            border-bottom: 1px solid #ddd;
            line-height: 1.8;
            white-space: pre-wrap;
        }

        .button-area {
            display: flex;
            justify-content: space-between;
            margin-top: 30px;
        }

        .right-buttons {
            display: flex;
            gap: 10px;
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

        .list-button {
            background-color: #eee;
            color: #222;
        }

        .edit-button {
            background-color: #222;
            color: white;
        }

        .delete-button {
            background-color: #555;
            color: white;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>게시글 상세</h1>

    <p class="description">
        게시글 내용을 확인합니다.
    </p>

    <div class="post-header">

        <h2 class="post-title">
            <c:out value="${board.title}" />
        </h2>

        <div class="post-info">
            <span>
                작성자 : <c:out value="${board.writer}" />
            </span>
            <span>
                작성일 : <c:out value="${board.createdAt}" />
            </span>
            <span>
                조회수 : <c:out value="${board.viewCount}" />
            </span>
        </div>

    </div>

    <div class="post-content">
        <c:out value="${board.content}" />
    </div>

    <div class="button-area">

        <a href="${pageContext.request.contextPath}/boards" class="button list-button">
            목록
        </a>

        <div class="right-buttons">

            <a href="${pageContext.request.contextPath}/boards/edit?id=${board.id}" class="button edit-button">
                수정
            </a>

            <form
                    action="${pageContext.request.contextPath}/boards/delete"
                    method="post"
                    style="display: inline;"
                    onsubmit="return confirm('정말 삭제하시겠습니까?');"
            >
                <input
                        type="hidden"
                        name="id"
                        value="${board.id}"
                >

                <button
                        type="submit"
                        class="button delete-button"
                >
                    삭제
                </button>
            </form>

        </div>

    </div>

</div>

</body>
</html>
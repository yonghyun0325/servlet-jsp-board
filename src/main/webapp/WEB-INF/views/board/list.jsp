<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Legacy Board</title>

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
            width: 1000px;
            margin: 60px auto;
            background: white;
            padding: 40px;
            border-radius: 8px;
        }

        h1 {
            margin-bottom: 10px;
        }

        .description {
            color: #666;
            margin-bottom: 30px;
        }

        .board-header {
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 20px;
        }

        .write-button {
            padding: 10px 18px;
            background-color: #222;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th,
        td {
            padding: 15px;
            border-bottom: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #f1f1f1;
        }

        .title {
            text-align: left;
        }

        .title a {
            color: #222;
            text-decoration: none;
        }

        .title a:hover {
            text-decoration: underline;
        }

        .pagination {
            margin-top: 30px;
            text-align: center;
        }

        .pagination a {
            margin: 0 5px;
            text-decoration: none;
            color: #333;
        }
    </style>
</head>

<body>

<div class="container">

    <h1>Legacy Board</h1>

    <p class="description">
        Servlet / JSP로 만드는 게시판입니다.
    </p>

    <div class="board-header">
        <h2>게시글 목록</h2>

        <a href="${pageContext.request.contextPath}/boards/write" class="write-button">
            글쓰기
        </a>
    </div>

    <table>

        <thead>
        <tr>
            <th style="width: 10%;">번호</th>
            <th style="width: 50%;">제목</th>
            <th style="width: 15%;">작성자</th>
            <th style="width: 15%;">작성일</th>
            <th style="width: 10%;">조회수</th>
        </tr>
        </thead>

        <tbody>

        <c:forEach var="board" items="${boards}">

            <tr>
                <td>${board.id}</td>

                <td class="title">
                    <a href="${pageContext.request.contextPath}boards/detail?id=${board.id}">
                            ${board.title}
                    </a>
                </td>

                <td>${board.writer}</td>
                <td>${board.createdAt}</td>
                <td>${board.viewCount}</td>
            </tr>

        </c:forEach>

        </tbody>

    </table>

    <div class="pagination">
        <a href="#">1</a>
        <a href="#">2</a>
        <a href="#">3</a>
    </div>

</div>

</body>
</html>
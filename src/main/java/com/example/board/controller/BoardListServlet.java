package com.example.board.controller;

import com.example.board.dto.BoardDto;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/boards")
public class BoardListServlet extends HttpServlet {

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        // 아직 DB를 연결하지 않았기 때문에
        // 테스트용 게시글 데이터를 Java에서 직접 생성합니다.
        List<BoardDto> boards = List.of(

                new BoardDto(
                        3L,
                        "Servlet 공부 중입니다.",
                        "Servlet 게시판을 공부하고 있습니다.",
                        "홍길동",
                        "2026-08-07",
                        15
                ),

                new BoardDto(
                        2L,
                        "JSP 게시판을 만들어봅시다.",
                        "JSP 화면을 만들어보고 있습니다.",
                        "김철수",
                        "2026-08-07",
                        8
                ),

                new BoardDto(
                        1L,
                        "첫 번째 게시글입니다.",
                        "첫 게시글입니다.",
                        "이영희",
                        "2026-08-06",
                        21
                )
        );

        // Servlet에서 JSP로 데이터 전달
        request.setAttribute("boards", boards);

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/views/board/list.jsp"
                );

        dispatcher.forward(request, response);
    }
}
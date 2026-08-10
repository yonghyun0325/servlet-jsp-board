package com.example.board.controller;

import com.example.board.dao.BoardDao;
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

    private final BoardDao boardDao =
            new BoardDao();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        // DB에서 게시글 목록 조회
        List<BoardDto> boards =
                boardDao.findAll();

        // JSP로 게시글 목록 전달
        request.setAttribute(
                "boards",
                boards
        );

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/views/board/list.jsp"
                );

        dispatcher.forward(
                request,
                response
        );
    }
}
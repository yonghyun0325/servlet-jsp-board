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

@WebServlet("/boards/edit")
public class BoardUpdateServlet extends HttpServlet {

    private final BoardDao boardDao = new BoardDao();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        String idParameter =
                request.getParameter("id");

        if (idParameter == null) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "게시글 번호가 필요합니다."
            );
            return;
        }

        Long id;

        try {
            id = Long.parseLong(idParameter);
        } catch (NumberFormatException e) {
            response.sendError(
                    HttpServletResponse.SC_BAD_REQUEST,
                    "게시글 번호가 올바르지 않습니다."
            );
            return;
        }

        BoardDto board =
                boardDao.findById(id);

        if (board == null) {
            response.sendError(
                    HttpServletResponse.SC_NOT_FOUND,
                    "게시글을 찾을 수 없습니다."
            );
            return;
        }

        request.setAttribute(
                "board",
                board
        );

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/views/board/edit.jsp"
                );

        dispatcher.forward(
                request,
                response
        );
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        request.setCharacterEncoding("UTF-8");

        Long id =
                Long.parseLong(
                        request.getParameter("id")
                );

        String title =
                request.getParameter("title");

        String writer =
                request.getParameter("writer");

        String content =
                request.getParameter("content");

        boardDao.update(
                id,
                title,
                content,
                writer
        );

        response.sendRedirect(
                request.getContextPath()
                        + "/boards/detail?id="
                        + id
        );
    }
}
package com.example.board.controller;

import com.example.board.dao.BoardDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/boards/delete")
public class BoardDeleteServlet extends HttpServlet {

    private final BoardDao boardDao =
            new BoardDao();

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

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

        boardDao.delete(id);

        response.sendRedirect(
                request.getContextPath() + "/boards"
        );
    }
}
package com.example.board.controller;

import com.example.board.dao.BoardDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/boards/write")
public class BoardWriteServlet extends HttpServlet {

    private final BoardDao boardDao = new BoardDao();

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {

        RequestDispatcher dispatcher =
                request.getRequestDispatcher(
                        "/WEB-INF/views/board/write.jsp"
                );

        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String writer = request.getParameter("writer");
        String content = request.getParameter("content");

        boardDao.save(
                title,
                content,
                writer
        );

        response.sendRedirect(
                request.getContextPath() + "/boards"
        );
    }
}
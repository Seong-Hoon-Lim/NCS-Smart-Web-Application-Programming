package com.example.sample_mamber_servlet.controller;

import com.example.sample_mamber_servlet.service.BoardService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@Log4j2
@WebServlet("*.do")
public class BoardController extends HttpServlet {

    BoardService boardService = BoardService.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String RequestURI = req.getRequestURI();
        String contextPath = req.getContextPath();
        String command = RequestURI.substring(contextPath.length());
        log.info("command : " + command);

        String viewPath = "/WEB-INF/template/board/";

        resp.setContentType("text/html; charset=utf-8");
        req.setCharacterEncoding("utf-8");


        if (command.contains("addForm.do")) {   //글입력 폼
            req.getRequestDispatcher(viewPath + "addForm.jsp").forward(req, resp);
            log.info("addForm.do ...");
        }
        else if (command.contains("addAction.do")) {    //글 입력
            log.info("addAction.do ...");
            try {
                if (boardService.saveBoard(req)) {
                    resp.sendRedirect("list.do");
                }
            }
            catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else if (command.contains("list.do")) { //글 목록
            log.info("list.do");
            try {
                boardService.getList(req);
            }
            catch (SQLException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            req.getRequestDispatcher(viewPath + "list.jsp").forward(req, resp);
        }



        else {
            req.getRequestDispatcher(viewPath + "error.jsp").forward(req, resp);
        }

    }
}

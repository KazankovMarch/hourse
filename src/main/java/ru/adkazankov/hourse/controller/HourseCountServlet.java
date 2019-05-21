package ru.adkazankov.hourse.controller;


import org.springframework.beans.factory.annotation.Autowired;
import ru.adkazankov.hourse.model.ChessBoard;
import ru.adkazankov.hourse.model.Hourse;
import ru.adkazankov.hourse.model.Position;
import ru.adkazankov.hourse.model.SquareChessBoard;
import ru.adkazankov.hourse.service.ChessPieceService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HourseCountServlet extends HttpServlet {

    private ChessPieceService chessPieceService;
    private Hourse hourse;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer width = Integer.valueOf(req.getParameter("width"));
        Integer height = Integer.valueOf(req.getParameter("height"));
        String start = req.getParameter("start");
        String end = req.getParameter("end");

        Position startPosition = Position.of(start);
        Position endPosition = Position.of(end);
        ChessBoard board = new SquareChessBoard(width, height);

        int result = chessPieceService.findShortestWay(hourse, startPosition, endPosition, board);

        resp.getWriter().print(result);
        resp.getWriter().close();
    }

    @Autowired
    public void setChessPieceService(ChessPieceService chessPieceService) {
        this.chessPieceService = chessPieceService;
    }
    @Autowired
    public void setHourse(Hourse hourse) {
        this.hourse = hourse;
    }
}

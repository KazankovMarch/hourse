package ru.adkazankov.hourse.service;

import org.junit.Test;
import ru.adkazankov.hourse.model.ChessBoard;
import ru.adkazankov.hourse.model.Hourse;
import ru.adkazankov.hourse.model.Position;
import ru.adkazankov.hourse.model.SquareChessBoard;

import static org.junit.Assert.*;

public class ChessPieceServiceImplTest extends ChessPieceServiceImpl {

    @Test
    public void findShortestWay1() {
        simpleTest();
        complexTest();
        impossibleTest();
    }

    // http://localhost/hourse/rest/count?width=10&height=14&start=B1&end=A3
    private void simpleTest() {
        Position start = new Position(1, 0);
        Position end = new Position(0, 2);
        Hourse hourse = new Hourse();
        ChessBoard chessBoard = new SquareChessBoard(10, 14);
        assertEquals(1, super.findShortestWay(hourse, start, end, chessBoard));
    }

    private void complexTest() {
        Position start = new Position(1, 3);
        Position end = new Position(6, 7);
        Hourse hourse = new Hourse();
        ChessBoard chessBoard = new SquareChessBoard(8, 7);
        assertEquals(3, super.findShortestWay(hourse, start, end, chessBoard));
    }

    private void impossibleTest() {
        Position start = new Position(0, 0);
        Position end = new Position(0, 1);
        Hourse hourse = new Hourse();
        ChessBoard chessBoard = new SquareChessBoard(5, 2);
        assertEquals(-1, super.findShortestWay(hourse, start, end, chessBoard));
    }

}
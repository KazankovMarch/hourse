package ru.adkazankov.hourse.model;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.UnaryOperator;

@Component
public class Hourse implements ChessPiece {

    //первая координата изменяет "строку", вторая - "столбец"
    //левый верхний угол - 0;0
    private static final UnaryOperator<Position> leftUp = new ChessMove(-1, -2);
    private static final UnaryOperator<Position> upLeft = new ChessMove(-2, -1);
    private static final UnaryOperator<Position> upRight = new ChessMove(-2, +1);
    private static final UnaryOperator<Position> rightUp = new ChessMove(-1, +2);
    private static final UnaryOperator<Position> rightDown = new ChessMove(+1, +2);
    private static final UnaryOperator<Position> downRight = new ChessMove(+2, +1);
    private static final UnaryOperator<Position> downLeft = new ChessMove(+2, -1);
    private static final UnaryOperator<Position> leftDown = new ChessMove(+1, -2);

    private static final List<UnaryOperator<Position>> moves
            = Arrays.asList(leftUp, upLeft, upRight, rightUp, rightDown, downRight, downLeft, leftDown);

    @Override
    public List<UnaryOperator<Position>> getMoves() {
        return moves;
    }

}

package ru.adkazankov.hourse.model;

import lombok.AllArgsConstructor;

import java.util.function.UnaryOperator;

@AllArgsConstructor
public class ChessMove implements UnaryOperator<Position> {
    //первая координата "строка", вторая - "столбец"
    //левый верхний угол - 0;0
    private int valX, valY;

    @Override
    public Position apply(Position position) {
        return new Position(position.getX() + valX, position.getY() + valY);
    }

}

package ru.adkazankov.hourse.model;

import java.util.List;
import java.util.function.UnaryOperator;

public interface ChessPiece {
    List<UnaryOperator<Position>> getMoves();
}

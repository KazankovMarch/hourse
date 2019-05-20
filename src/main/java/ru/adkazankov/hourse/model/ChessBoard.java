package ru.adkazankov.hourse.model;

public interface ChessBoard {
    boolean isOkPosition(Position position);
    void setStep(Position position, int step);
    int getStep(Position position);
}

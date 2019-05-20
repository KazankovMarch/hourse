package ru.adkazankov.hourse.model;

public class SquareChessBoard implements ChessBoard {

    private int width, height;
    private int[][] body;


    public SquareChessBoard(int width, int height) {
        this.width = width;
        this.height = height;
        body = new int[height][width];
    }

    @Override
    public boolean isOkPosition(Position position) {
        //первая координата (X) "строкa", вторая (Y) - "столбец"
        //левый верхний угол - 0;0
        return position.getX() >= 0
                && position.getX() < height
                && position.getY() >= 0
                && position.getY() < width
                && body[position.getX()][position.getY()] == 0;
    }

    @Override
    public void setStep(Position position, int step) {
        body[position.getX()][position.getY()] = step;
    }

    @Override
    public int getStep(Position position) {
        return body[position.getX()][position.getY()];
    }

}

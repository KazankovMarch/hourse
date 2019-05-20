package ru.adkazankov.hourse.service;

import org.springframework.stereotype.Service;
import ru.adkazankov.hourse.model.ChessBoard;
import ru.adkazankov.hourse.model.ChessPiece;
import ru.adkazankov.hourse.model.Position;

import java.util.LinkedList;
import java.util.Queue;
import java.util.function.UnaryOperator;

@Service
public class ChessPieceServiceImpl implements ChessPieceService {

    @Override
    public int findShortestWay(ChessPiece chessPiece, Position start, Position end, ChessBoard chessBoard) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(start);
        /*
        * Обход графа "в ширину",
        * вершины графа - ячейки доски (position),
        * ребра - возможность перемещения фиугры (move)
        * */
        while (!queue.isEmpty() && !queue.peek().equals(end)){
            Position currentPosition = queue.remove();
            int currentStep = chessBoard.getStep(currentPosition) + 1;
            /*
            * Пытаемся пойти по каждому "ребру", если это возможно
            * и если до этого мы там не были (isOkPosition)
            * */
            for(UnaryOperator<Position> move : chessPiece.getMoves()){
                Position nextPosition = move.apply(currentPosition);

                if(chessBoard.isOkPosition(nextPosition)){
                    queue.add(nextPosition);
                    chessBoard.setStep(nextPosition, currentStep);
                }
            }
        }
        if(queue.isEmpty())
            return -1;
        else
            return chessBoard.getStep(end);
    }

}

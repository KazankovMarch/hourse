package ru.adkazankov.hourse.service;

import ru.adkazankov.hourse.model.ChessBoard;
import ru.adkazankov.hourse.model.ChessPiece;
import ru.adkazankov.hourse.model.Position;

public interface ChessPieceService {
    int findShortestWay(ChessPiece chessPiece, Position start, Position end, ChessBoard chessBoard);
}

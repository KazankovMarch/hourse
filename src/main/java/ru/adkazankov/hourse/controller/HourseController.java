package ru.adkazankov.hourse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.adkazankov.hourse.model.*;
import ru.adkazankov.hourse.service.ChessPieceService;

@RestController
@RequestMapping("/hourse/rest")
public class HourseController {

    private ChessPieceService chessPieceService;
    private Hourse hourse;

    //http://localhost/hourse/rest/count?width=10&height=14&start=B1&end=A3
    @GetMapping("/count")
    public ResponseEntity<Integer> findShortestWay(
            @RequestParam("width") Integer width,
            @RequestParam("height") Integer height,
            @RequestParam("start") String start,
            @RequestParam("end") String end){

        Position startPosition = Position.of(start);
        Position endPosition = Position.of(end);
        ChessBoard board = new SquareChessBoard(height, width);

        int result = chessPieceService.findShortestWay(hourse, startPosition, endPosition, board);
        return ResponseEntity.ok(result);
    }


    @Autowired
    public void setChessPieceService(ChessPieceService chessPieceService) {
        this.chessPieceService = chessPieceService;
    }
}

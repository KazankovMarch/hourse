package ru.adkazankov.hourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class Position {

    private int x,y;

    public void changeX(int val){
        x += val;
    }
    public void changeY(int val){
        y += val;
    }

    public static Position of(String view){
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Position))
            return false;
        else{
            Position p = (Position) o;
            return p.getX() == x && p.getY() == y;
        }
    }
}

package ru.adkazankov.hourse.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;

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
        int i = 0;
        while (Character.isAlphabetic(view.charAt(i)))
            i++;
        int x = getExcelColumnNumber(view.substring(0, i)) - 1;
        int y = Integer.parseInt(view.substring(i)) - 1;
        return new Position(x,y);
    }

    private static int getExcelColumnNumber(String column) {
        int result = 0;
        for (int i = 0; i < column.length(); i++) {
            result *= 26;
            result += column.charAt(i) - 'A' + 1;
        }
        return result;
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

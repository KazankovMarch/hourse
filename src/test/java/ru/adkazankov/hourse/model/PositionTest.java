
package ru.adkazankov.hourse.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class PositionTest {

    @Test
    public void of1() {
        simpleTest();
        complexTest();
    }


    // http://localhost/hourse/rest/count?width=10&height=14&start=B1&end=A3
    private void simpleTest() {
        String view = "B1";
        Position position = Position.of(view);
        assertEquals(new Position(1,0), position);
        view = "A3";
        position = Position.of(view);
        assertEquals(new Position(0,2), position);
    }

    private void complexTest() {
        String view = "AZ435";
        Position position = Position.of(view);
        assertEquals(new Position(51,434), position);
    }

}
package ru.zefick.tictactoe.test;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;
import ru.zefick.tictactoe.Grid3x3;
import ru.zefick.tictactoe.core.Grid;

public class GridTest {

    @Test
    public void testPossibleMove() {
        Grid g = new Grid3x3();
        for (int i=0; i<9; i++) {
            String move = String.valueOf(i);
            Assert.assertTrue(g.possibleMove(1, move));
            g = g.move(move, 1);
            Assert.assertFalse(g.possibleMove(1, move));
        }
        Assert.assertTrue(g.full());
    }

    @Test
    public void testPossibleMoves() {
        Grid g = new Grid3x3()
                .move("1", 1)
                .move("5", 2)
                .move("7", 1);
        assertEquals(
                Arrays.asList("0", "2", "3", "4", "6", "8"),
                g.possibleMoves(1));
    }

}

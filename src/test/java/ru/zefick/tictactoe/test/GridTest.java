package ru.zefick.tictactoe.test;

import org.junit.Test;

import junit.framework.Assert;
import ru.zefick.tictactoe.Grid;

public class GridTest {

    @Test
    public void testFree() {
        Grid g = new Grid();
        for (int i=0; i<9; i++) {
            String move = String.valueOf(i);
            Assert.assertTrue(g.free(move));
            g = g.move(move, 1);
            Assert.assertFalse(g.free(move));
        }
        Assert.assertTrue(g.full());
    }

}

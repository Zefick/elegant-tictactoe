package ru.zefick.tictactoe.test;

import org.junit.Test;

import junit.framework.Assert;
import ru.zefick.tictactoe.Grid;

public class GridTest {

    @Test
    public void testFree() {
        Grid g = new Grid();
        for (int i=0; i<9; i++) {
            Assert.assertTrue(g.free(i));
            g = g.move(i, 1);
            Assert.assertFalse(g.free(i));
        }
        Assert.assertTrue(g.full());
    }

}

package ru.zefick.tictactoe.test;

import org.junit.Test;

import junit.framework.Assert;
import ru.zefick.tictactoe.Game;
import ru.zefick.tictactoe.Grid;
import ru.zefick.tictactoe.State;

/**
 * Unit test for simple App.
 */
public class GameTest {

    @Test
    public void testX() {
        // X O O
        // . X .
        // . . X
        Assert.assertSame(
            new Game(
                new Grid(),
                new PredefinedPlayer(new int[] {0, 4, 8}),
                new PredefinedPlayer(new int[] {1, 2})
            ).play().winner(),
            State.X);
    }

    @Test
    public void testO() {
        // O X X
        // O X .
        // O . .
        Assert.assertSame(
            new Game(
                new Grid(),
                new PredefinedPlayer(new int[] {1, 4, 2}),
                new PredefinedPlayer(new int[] {0, 3, 6})
            ).play().winner(),
            State.O);
    }

    @Test
    public void testTie() {
        // X O X
        // X X O
        // O X O
        Assert.assertTrue(
            new Game(
                new Grid(),
                new PredefinedPlayer(new int[] {0, 2, 4, 5, 7}),
                new PredefinedPlayer(new int[] {1, 3, 6, 8})
            ).play().winner().empty());
    }

    @Test
    public void testFirst() throws Exception {
        Assert.assertSame(
            new Game(
                new Grid(),
                new PredefinedPlayer(new int[] {0, 1, 2}),
                new PredefinedPlayer(new int[] {6, 7, 8}),
                1
            ).play().winner(),
            State.X);

        Assert.assertSame(
            new Game(
                new Grid(),
                new PredefinedPlayer(new int[] {0, 1, 2}),
                new PredefinedPlayer(new int[] {6, 7, 8}),
                2
            ).play().winner(),
            State.O);
    }

}

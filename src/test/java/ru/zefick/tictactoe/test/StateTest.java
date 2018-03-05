package ru.zefick.tictactoe.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ru.zefick.tictactoe.core.State;

public class StateTest {

    @Test
    public void testSymbol() {
        assertEquals('.', State.EMPTY.symbol());
        assertEquals('X', State.X.symbol());
        assertEquals('O', State.O.symbol());
    }

    @Test
    public void testEmtpy() {
        assertTrue(State.EMPTY.empty());
        assertFalse(State.X.empty());
        assertFalse(State.O.empty());
    }

    @Test
    public void testOf() throws Exception {
        assertSame(State.of(1), State.X);
        assertSame(State.of(2), State.O);
    }

}

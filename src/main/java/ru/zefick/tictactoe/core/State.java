
package ru.zefick.tictactoe.core;

public enum State {

    EMPTY ('.'),
    X('X'),
    O('O');

    private final char symbol;

    private State(char symbol) {
        this.symbol = symbol;
    }

    public static State of(int side) {
        return side == 1 ? X : O;
    }

    public boolean empty() {
        return this == EMPTY;
    }

    public char symbol() {
        return symbol;
    }

}

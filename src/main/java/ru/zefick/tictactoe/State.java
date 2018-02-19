
package ru.zefick.tictactoe;

public enum State {

    EMPTY ('.'),
    X('X'),
    O('O');

    private final char symbol;

    private State(char symbol) {
        this.symbol = symbol;
    }

    public static State of(boolean side) {
        return side ? X : O;
    }

    public boolean empty() {
        return this == EMPTY;
    }

    public char symbol() {
        return symbol;
    }

}

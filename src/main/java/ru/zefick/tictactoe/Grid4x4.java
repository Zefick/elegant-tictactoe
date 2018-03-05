
package ru.zefick.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Variant of the game in 4x4 grid.
 * If somebody build 4 figures in a vertical or horizontal row then first player wins.
 * Otherwise if a table is full then second player wins.
 * In this version of the rules, a tie is impossible if the table is full.
 */
public final class Grid4x4 implements Grid {

    private final State data[];

    private Grid4x4(State grid[]) {
        this.data = grid;
    }

    public Grid4x4() {
        data = new State[16];
        Arrays.fill(data, State.EMPTY);
    }

    @Override
    public Grid4x4 move(String cell, int side) {
        State data2[] = data.clone();
        data2[Integer.parseInt(cell)] = State.of(side);
        return new Grid4x4(data2);
    }

    @Override
    public boolean possibleMove(int side, String n) {
        return data[Integer.valueOf(n)].empty();
    }

    @Override
    public List<String> possibleMoves(int side) {
        List<String> moves = new ArrayList<>();
        for (int i=0; i<16; i++) {
            String move = String.valueOf(i);
            if (possibleMove(side, move)) {
                moves.add(move);
            }
        }
        return moves;
    }

    @Override
    public boolean full() {
        for (State s : data) {
            if (s.empty()) return false;
        }
        return true;
    }

    @Override
    public String string() {
        return String.format("%c %c %c %c\n%c %c %c %c\n%c %c %c %c\n%c %c %c %c\n",
                data[0].symbol(), data[1].symbol(), data[2].symbol(), data[3].symbol(),
                data[4].symbol(), data[5].symbol(), data[6].symbol(), data[7].symbol(),
                data[8].symbol(), data[9].symbol(), data[10].symbol(), data[11].symbol(),
                data[12].symbol(), data[13].symbol(), data[14].symbol(), data[15].symbol());
    }

    @Override
    public State winner() {
        int lines[][] = {
                {0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}, {12, 13, 14, 15},
                {0, 4, 8, 12}, {1, 5, 9, 13}, {2, 6, 10, 14}, {3, 7, 11, 15}
        };
        for (int[] line : lines) {
            State a = data[line[0]];
            if (!a.empty()
                    && data[line[1]] == a
                    && data[line[2]] == a
                    && data[line[3]] == a) {
                return State.of(1);
            }
        }
        if (full()) {
            return State.of(2);
        }
        return State.EMPTY;
    }

}

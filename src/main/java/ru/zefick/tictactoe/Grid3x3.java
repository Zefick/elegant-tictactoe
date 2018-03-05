
package ru.zefick.tictactoe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Grid3x3 implements Grid {

    private final State data[];

    private Grid3x3(State grid[]) {
        this.data = grid;
    }

    public Grid3x3() {
        data = new State[9];
        Arrays.fill(data, State.EMPTY);
    }

    @Override
    public Grid3x3 move(String cell, int side) {
        State data2[] = data.clone();
        data2[Integer.parseInt(cell)] = State.of(side);
        return new Grid3x3(data2);
    }

    @Override
    public boolean possibleMove(int side, String n) {
        return data[Integer.valueOf(n)].empty();
    }

    @Override
    public List<String> possibleMoves(int side) {
        List<String> moves = new ArrayList<>();
        for (int i=0; i<9; i++) {
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
        return String.format("%c %c %c\n%c %c %c\n%c %c %c\n",
                data[0].symbol(), data[1].symbol(), data[2].symbol(),
                data[3].symbol(), data[4].symbol(), data[5].symbol(),
                data[6].symbol(), data[7].symbol(), data[8].symbol());
    }

    @Override
    public State winner() {
        int lines[][] = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6},
                {1, 4, 7}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}
        };
        for (int[] line : lines) {
            State a = data[line[0]];
            if (!a.empty()
                    && data[line[1]] == a
                    && data[line[2]] == a) {
                return a;
            }
        }
        return State.EMPTY;
    }

}


package ru.zefick.tictactoe;

import java.util.Arrays;

public final class Grid {

    private final State data[];

    private Grid(State grid[]) {
        this.data = grid;
    }

    public Grid() {
        data = new State[9];
        Arrays.fill(data, State.EMPTY);
    }

    public Grid move(int cell, int side) {
        State data2[] = data.clone();
        data2[cell] = State.of(side);
        return new Grid(data2);
    }

    public boolean free(int n) {
        return data[n].empty();
    }

    public boolean full() {
        for (State s : data) {
            if (s.empty()) return false;
        }
        return true;
    }

    public String string() {
        return String.format("%c %c %c\n%c %c %c\n%c %c %c\n",
                data[0].symbol(), data[1].symbol(), data[2].symbol(),
                data[3].symbol(), data[4].symbol(), data[5].symbol(),
                data[6].symbol(), data[7].symbol(), data[8].symbol());
    }

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

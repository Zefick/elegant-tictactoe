
package ru.zefick.tictactoe.estimation;

import java.util.OptionalInt;

import ru.zefick.tictactoe.Grid;
import ru.zefick.tictactoe.State;

public class FullDepthEstimation implements Estimation {

    @Override
    public int estimate(Grid grid, String cell, int side) {
        grid = grid.move(cell, side);
        if (grid.winner() == State.of(side)) {
            return 1;
        } else if (grid.full()) {
            return 0;
        }
        OptionalInt best = OptionalInt.empty();
        for (int i=0; i<9; ++i) {
            String move = String.valueOf(i);
            if (grid.free(move)) {
                int n = -estimate(grid, move, 3 - side);
                if (!best.isPresent() ||  n < best.getAsInt()) {
                    best = OptionalInt.of(n);
                }
            }
        }
        return best.getAsInt();
    }

}

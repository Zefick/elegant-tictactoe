
package ru.zefick.tictactoe.estimation;

import java.util.OptionalInt;

import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.State;

public class FullDepthEstimation implements Estimation {

    @Override
    public int estimate(Grid grid, String cell, int side) {
        grid = grid.move(cell, side);
        if (grid.winner() == State.of(side)) {
            return 1;
        } else if (grid.winner() == State.of(3-side)) {
            return -1;
        } else if (grid.full()) {
            return 0;
        }
        OptionalInt best = OptionalInt.empty();
        for (String move : grid.possibleMoves(side)) {
            int n = -estimate(grid, move, 3 - side);
            if (!best.isPresent() ||  n < best.getAsInt()) {
                best = OptionalInt.of(n);
            }
        }
        return best.getAsInt();
    }

}


package ru.zefick.tictactoe.estimation;

import java.util.OptionalInt;

import ru.zefick.tictactoe.Grid;
import ru.zefick.tictactoe.State;

public class FullDepthEstimation implements Estimation {

    int count;

    @Override
    public int estimate(Grid grid, String cell, int side) {
        count++;
        if (count % 1000_000 == 0) {
            System.out.println(count);
        }
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

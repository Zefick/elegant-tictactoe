
package ru.zefick.tictactoe.player;

import java.util.OptionalInt;

import ru.zefick.tictactoe.Grid;
import ru.zefick.tictactoe.estimation.Estimation;

public final  class EstimatingAI implements Player {

    private final Estimation estimation;

    public EstimatingAI(Estimation e) {
        this.estimation = e;
    }

    @Override
    public int move(Grid grid, int side) {
        OptionalInt best = OptionalInt.empty(),
                max = OptionalInt.empty();
        for (int i=0; i<9; i++) {
            if (grid.free(i)) {
                int n = estimation.estimate(grid, i, side);
                if (!max.isPresent() || n > max.getAsInt()) {
                    max = OptionalInt.of(n);
                    best = OptionalInt.of(i);
                }
            }
        }
        return best.getAsInt();
    }

}

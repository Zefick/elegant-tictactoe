
package ru.zefick.tictactoe.player;

import java.util.Optional;
import java.util.OptionalInt;

import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;
import ru.zefick.tictactoe.estimation.Estimation;

public final  class EstimatingAI implements Player {

    private final Estimation estimation;

    public EstimatingAI(Estimation e) {
        this.estimation = e;
    }

    @Override
    public String move(Grid grid, int side) {
        Optional<String> best = Optional.empty();
        OptionalInt max = OptionalInt.empty();

        for (String move : grid.possibleMoves(side)) {
            int n = estimation.estimate(grid, move, side);
            if (!max.isPresent() || n > max.getAsInt()) {
                max = OptionalInt.of(n);
                best = Optional.of(move);
            }
        }
        return best.get();
    }

}

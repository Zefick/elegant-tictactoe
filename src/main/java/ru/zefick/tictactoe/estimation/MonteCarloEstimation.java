
package ru.zefick.tictactoe.estimation;

import ru.zefick.tictactoe.core.Game;
import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;
import ru.zefick.tictactoe.core.State;
import ru.zefick.tictactoe.player.EstimatingAI;

public class MonteCarloEstimation implements Estimation {

    private final int count;

    public MonteCarloEstimation(int count) {
        this.count = count;
    }

    public MonteCarloEstimation() {
        this(1000);
    }

    @Override
    public int estimate(Grid grid, String cell, int side) {
        Player p = new EstimatingAI(
                new RandomEstimation());
        Game game = new Game(grid.move(cell, side), p, p, 3 - side);
        int n = 0;
        for (int i=0; i<count; i++) {
            State winner = game.play().winner();
            if (winner == State.of(side)) {
                n += 1;
            } else if (winner == State.of(3 - side)) {
                n -= 5;
            }
        }
        return n;
    }

}

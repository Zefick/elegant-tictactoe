
package ru.zefick.tictactoe.test;

import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;

public class PredefinedPlayer implements Player {

    private final int moves[];

    private int count = 0;

    public PredefinedPlayer(int moves[]) {
        this.moves = moves;
    }

    @Override
    public String move(Grid grid, int side) {
        return String.valueOf(moves[count++]);
    }

}

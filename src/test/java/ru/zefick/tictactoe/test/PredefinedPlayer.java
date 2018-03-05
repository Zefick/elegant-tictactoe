
package ru.zefick.tictactoe.test;

import ru.zefick.tictactoe.Grid;
import ru.zefick.tictactoe.player.Player;

public class PredefinedPlayer implements Player {

    private final int moves[];

    private int count = 0;

    public PredefinedPlayer(int moves[]) {
        this.moves = moves;
    }

    @Override
    public int move(Grid grid, int side) {
        return moves[count++];
    }

}

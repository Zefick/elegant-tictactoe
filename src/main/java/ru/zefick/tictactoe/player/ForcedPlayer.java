
package ru.zefick.tictactoe.player;

import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;

/**
 * Forced move is either move which gives a player instant victory or prevent it for opponent.
 */
public class ForcedPlayer implements Player {

    private final Player player;

    public ForcedPlayer(Player player) {
        this.player = player;
    }

    private static boolean checkMove(Grid grid, int side, String move) {
        return grid.possibleMove(side, move)
                && (!grid.move(move, 1).winner().empty()
                || !grid.move(move, 2).winner().empty());
    }

    @Override
    public String move(Grid grid, int side) {
        for (int i=0; i<9; i++) {
            String move = String.valueOf(i);
            if (checkMove(grid, side, move)) {
                return move;
            }
        }
        return player.move(grid, side);
    }

}

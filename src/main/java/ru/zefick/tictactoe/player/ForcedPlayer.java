
package ru.zefick.tictactoe.player;

import ru.zefick.tictactoe.Grid;

/**
 * Forced move is either move which gives a player instant victory or prevent it for opponent.
 */
public class ForcedPlayer implements Player {

    private final Player player;

    public ForcedPlayer(Player player) {
        this.player = player;
    }

    private static boolean checkMove(Grid grid, int move) {
        return grid.free(move)
                && (!grid.move(move, true).winner().empty()
                || !grid.move(move, false).winner().empty());
    }

    @Override
    public int move(Grid grid, boolean side) {
        for (int i=0; i<9; i++) {
            if (checkMove(grid, i)) {
                return i;
            }
        }
        return player.move(grid, side);
    }

}

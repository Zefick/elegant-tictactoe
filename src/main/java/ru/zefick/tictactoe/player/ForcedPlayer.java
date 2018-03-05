
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

    private static boolean checkMove(Grid grid, String move) {
        return grid.free(move)
                && (!grid.move(move, 1).winner().empty()
                || !grid.move(move, 2).winner().empty());
    }

    @Override
    public String move(Grid grid, int side) {
        for (int i=0; i<9; i++) {
            String move = String.valueOf(i);
            if (checkMove(grid, move)) {
                return move;
            }
        }
        return player.move(grid, side);
    }

}

package ru.zefick.tictactoe.player;

import ru.zefick.tictactoe.Grid;
import ru.zefick.tictactoe.State;

public class VerbosePlayer implements Player {

    private final Player player;

    public VerbosePlayer(Player p) {
        this.player = p;
    }

    @Override
    public int move(Grid grid, boolean side) {
        long t = System.currentTimeMillis();
        int move = player.move(grid, side);
        t = System.currentTimeMillis() - t;
        System.out.println(
                String.format("Player %c moved on cell %d-%d in %d ms.",
                        State.of(side).symbol(), move/3+1, move%3+1, t));
        return move;
    }

}

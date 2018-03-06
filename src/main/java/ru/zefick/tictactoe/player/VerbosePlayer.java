package ru.zefick.tictactoe.player;

import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;
import ru.zefick.tictactoe.core.State;

public class VerbosePlayer implements Player {

    private final Player player;

    public VerbosePlayer(Player p) {
        this.player = p;
    }

    @Override
    public String move(Grid grid, int side) {
        long t = System.currentTimeMillis();
        String move = player.move(grid, side);
        t = System.currentTimeMillis() - t;
        int moveInt = Integer.parseInt(move);
        System.out.println(
                String.format("Player %c moved on cell %d-%d in %d ms.",
                        State.of(side).symbol(), moveInt/3+1, moveInt%3+1, t));
        return move;
    }

}

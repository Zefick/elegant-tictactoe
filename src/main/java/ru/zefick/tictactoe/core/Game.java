
package ru.zefick.tictactoe.core;

import ru.zefick.tictactoe.player.Player;

public final class Game {

    private final Player p1, p2;

    private final Grid grid;

    private final int first;

    public Game(Grid grid, Player p1, Player p2, int first) {
        this.first = first;
        this.grid = grid;
        this.p1 = p1;
        this.p2 = p2;
    }

    public Game(Grid grid, Player p1, Player p2) {
        this(grid, p1, p2, 1);
    }

    public Grid play() {
        Grid grid = this.grid;
        Player p = first == 1 ? p1 : p2;
        int side = first;

        while (grid.winner().empty()
                && !grid.full())
        {
            grid = grid.move(p.move(grid, side), side);
            side = 3 - side;
            p = (p == p1) ? p2 : p1;
        }
        return grid;
    }

}

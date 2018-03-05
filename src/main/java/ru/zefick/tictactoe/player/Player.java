
package ru.zefick.tictactoe.player;

import ru.zefick.tictactoe.Grid;

public interface Player {

    String move(Grid grid, int side);

}
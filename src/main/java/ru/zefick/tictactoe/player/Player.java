
package ru.zefick.tictactoe.player;

import ru.zefick.tictactoe.core.Grid;

public interface Player {

    String move(Grid grid, int side);

}
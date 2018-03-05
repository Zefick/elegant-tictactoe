
package ru.zefick.tictactoe.estimation;

import ru.zefick.tictactoe.core.Grid;

public interface Estimation {

    int estimate(Grid grid, String move, int side);

}

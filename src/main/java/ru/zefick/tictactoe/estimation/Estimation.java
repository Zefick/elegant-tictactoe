
package ru.zefick.tictactoe.estimation;

import ru.zefick.tictactoe.Grid;

public interface Estimation {

    int estimate(Grid grid, int move, boolean side);

}

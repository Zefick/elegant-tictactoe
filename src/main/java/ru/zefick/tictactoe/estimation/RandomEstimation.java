
package ru.zefick.tictactoe.estimation;

import java.util.Random;

import ru.zefick.tictactoe.core.Grid;

public final class RandomEstimation implements Estimation {

    @Override
    public int estimate(Grid grid, String move, int side) {
        return new Random().nextInt();
    }

}

package ru.zefick.tictactoe.estimation;

import java.util.Random;

import ru.zefick.tictactoe.Grid;

public final class RandomEstimation implements Estimation {

    @Override
    public int estimate(Grid grid, int move, int side) {
        return new Random().nextInt();
    }

}
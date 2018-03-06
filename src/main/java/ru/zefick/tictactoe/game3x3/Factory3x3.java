
package ru.zefick.tictactoe.game3x3;

import ru.zefick.tictactoe.core.GameFactory;
import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.player.HumanPlayer.Assistant;

public class Factory3x3 implements GameFactory {

    @Override
    public Grid grid() {
        return new Grid3x3();
    }

    @Override
    public Assistant humanAssistant() {
        return new HumanAssistant();
    }

}

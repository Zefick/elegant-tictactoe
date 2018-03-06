
package ru.zefick.tictactoe.game4x4;

import ru.zefick.tictactoe.core.GameFactory;
import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.player.HumanPlayer.Assistant;

public class Factory4x4 implements GameFactory {

    @Override
    public Grid grid() {
        return new Grid4x4();
    }

    @Override
    public Assistant humanAssistant() {
        return new HumanAssistant();
    }

}

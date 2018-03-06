
package ru.zefick.tictactoe.core;

import ru.zefick.tictactoe.player.HumanPlayer.Assistant;

public interface GameFactory {

    Grid grid();

    Assistant humanAssistant();

}

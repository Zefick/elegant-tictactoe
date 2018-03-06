
package ru.zefick.tictactoe.game4x4;

import ru.zefick.tictactoe.player.HumanPlayer;

public class HumanAssistant implements HumanPlayer.Assistant {

    @Override
    public String prompt() {
        return "Move format: {row}{column}";
    }

    @Override
    public String convertMove(String input) throws IllegalArgumentException {
        int move = (input.charAt(0)-'1') * 4 + (input.charAt(1)-'1');
        if (move < 0 || move > 16) {
            throw new IllegalArgumentException();
        }
        return String.valueOf(move);
    }

}

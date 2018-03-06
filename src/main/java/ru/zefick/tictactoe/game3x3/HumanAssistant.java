
package ru.zefick.tictactoe.game3x3;

import ru.zefick.tictactoe.player.HumanPlayer;

public class HumanAssistant implements HumanPlayer.Assistant {

    @Override
    public String prompt() {
        return "Move format: {row}{column}";
    }

    @Override
    public String convertMove(String input) throws IllegalArgumentException {
        int move = (input.charAt(0)-'1') * 3 + (input.charAt(1)-'1');
        if (move < 0 || move > 9) {
            throw new IllegalArgumentException();
        }
        return String.valueOf(move);
    }

}


package ru.zefick.tictactoe.player;

import java.util.Scanner;

import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;
import ru.zefick.tictactoe.core.State;

public class HumanPlayer implements Player {

    private final Assistant assist;

    public HumanPlayer(Assistant assist) {
        this.assist = assist;
    }

    @Override
    public String move(Grid grid, int side) {
        message(grid.string());
        message(assist.prompt());
        message(String.format("Your move (%s): ", State.of(side).symbol()));

        for (;;) {
            try {
                @SuppressWarnings("resource")
                String input = new Scanner(System.in).nextLine();
                return assist.convertMove(input);
            } catch (IllegalArgumentException __) {
                message("Illegal move, try again.");
            }
        }
    }

    private void message(String msg) {
        System.out.println(msg);
    }

    public interface Assistant {
        String prompt();
        String convertMove(String input) throws IllegalArgumentException;
    }

}

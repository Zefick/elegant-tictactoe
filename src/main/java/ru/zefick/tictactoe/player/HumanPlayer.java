
package ru.zefick.tictactoe.player;

import java.util.Scanner;

import ru.zefick.tictactoe.Grid;
import ru.zefick.tictactoe.State;

public class HumanPlayer implements Player {

    @Override
    public String move(Grid grid, int side) {
        message(grid.string());
        message(String.format("Your move (%s): ", State.of(side).symbol()));

        @SuppressWarnings("resource")
        String input = new Scanner(System.in).nextLine();
        for (;;) {
            int move = (input.charAt(0)-'1')*3 + (input.charAt(1)-'1');
            if (move < 0 || move > 9) {
                message("Illegal move, try again.");
            }
            return String.valueOf(move);
        }
    }

    private void message(String msg) {
        System.out.println(msg);
    }

}

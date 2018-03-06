
package ru.zefick.tictactoe;

import ru.zefick.tictactoe.core.Game;
import ru.zefick.tictactoe.core.GameFactory;
import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;
import ru.zefick.tictactoe.core.State;
import ru.zefick.tictactoe.estimation.FullDepthEstimation;
import ru.zefick.tictactoe.estimation.MonteCarloEstimation;
import ru.zefick.tictactoe.game4x4.Factory4x4;
import ru.zefick.tictactoe.player.EstimatingAI;
import ru.zefick.tictactoe.player.HumanPlayer;
import ru.zefick.tictactoe.player.VerbosePlayer;

public class Main {

    static int foo(int n) {
        return n;
    }

    public static void main(String[] args) {

        GameFactory factory = new Factory4x4();

        Player p1 = new VerbosePlayer(
                new EstimatingAI(
                      new MonteCarloEstimation(100)));

        Player p2 = new VerbosePlayer(
                new EstimatingAI(
                      new FullDepthEstimation()));

        Player p3 = new HumanPlayer(factory.humanAssistant());

        Grid finish = new Game(factory.grid(), p1, p1).play();

        System.out.println(finish.string());

        State winner = finish.winner();
        if (winner.empty()) {
            System.out.println("Tie");
        } else {
            System.out.printf("%c won\n", winner.symbol());
        }
    }
}

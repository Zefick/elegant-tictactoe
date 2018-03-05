
package ru.zefick.tictactoe;

import ru.zefick.tictactoe.estimation.FullDepthEstimation;
import ru.zefick.tictactoe.estimation.MonteCarloEstimation;
import ru.zefick.tictactoe.player.EstimatingAI;
import ru.zefick.tictactoe.player.HumanPlayer;
import ru.zefick.tictactoe.player.Player;
import ru.zefick.tictactoe.player.VerbosePlayer;

public class Main {

    static int foo(int n) {
        return n;
    }

    public static void main(String[] args) {

        Player p1 = new VerbosePlayer(
                new EstimatingAI(
                      new MonteCarloEstimation(100)));

        Player p2 = new VerbosePlayer(
                new EstimatingAI(
                      new FullDepthEstimation()));

        Player p3 = new HumanPlayer();

        Grid finish = new Game(new Grid4x4(), p1, p1).play();

        System.out.println(finish.string());

        State winner = finish.winner();
        if (winner.empty()) {
            System.out.println("Tie");
        } else {
            System.out.printf("%c won\n", winner.symbol());
        }
    }
}

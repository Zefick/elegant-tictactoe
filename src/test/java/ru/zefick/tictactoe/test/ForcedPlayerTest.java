
package ru.zefick.tictactoe.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ru.zefick.tictactoe.core.Grid;
import ru.zefick.tictactoe.core.Player;
import ru.zefick.tictactoe.game4x4.Grid4x4;
import ru.zefick.tictactoe.player.ForcedPlayer;

public class ForcedPlayerTest {

    @Test
    /**
     * Test that ForcedPlayer correctly handles 4x4 rules where second player loses when builds 4 O's in a row.
     */
    public void test4x4rules() {
        Grid g = new Grid4x4()
                .move("0", 1)
                .move("1", 1)
                .move("2", 1);
        Player p = new ForcedPlayer(new PredefinedPlayer(new int[] {4}));

        // first player must move 3 to win immediately
        assertEquals("3", p.move(g, 1));

        g = new Grid4x4()
                .move("0", 2)
                .move("1", 2)
                .move("2", 2);
        // second player must avoid move 3 to not lose
        assertEquals("4", p.move(g, 2));
    }

}

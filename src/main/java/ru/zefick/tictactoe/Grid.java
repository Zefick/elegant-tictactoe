
package ru.zefick.tictactoe;

import java.util.List;

public interface Grid {

    public Grid move(String cell, int side);

    public boolean possibleMove(int side, String n);

    public List<String> possibleMoves(int side) ;

    public boolean full();

    public String string() ;

    public State winner();

}

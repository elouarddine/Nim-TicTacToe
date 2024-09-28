package games.genericgames;

import games.players.Player;

import java.util.ArrayList;


public interface Game {
    
	public String nomToString();
    public Player getCurrentPlayer();
    public ArrayList<Integer> validMoves();
    public  boolean isValid (int coup);
    public void execute(int coup);
    public boolean isOver();
    public  Player getWinner();
    public String moveToString(int move);
    public String situationToString();
    public Game copy();

}

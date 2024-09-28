package games.genericgames;

import games.players.Player;
import java.util.ArrayList;

public class Nim extends AbstractGame implements Game {
   
    private int n;
    private int k;
    private int Currentnball;

    public Nim(int n, int k, Player j1, Player j2) {
        super(j1, j2);
        this.n = n;
        this.k = k;
        this.Currentnball = n;
    }

    public int getInitialNbMatches() {
        return this.n;
    }

    public int getCurrentNbMatches() {
        return this.Currentnball;
    }

    @Override
    public ArrayList<Integer> validMoves() {
        ArrayList<Integer> validMoves = new ArrayList<>();
        for (int i = 1; i <= this.k && i <= this.Currentnball; i++) {
            validMoves.add(i);
        }
        return validMoves;
    }

    @Override
    public boolean isValid(int y) {
        return y > 0 && y <= this.k && y <= this.Currentnball;
    }
    
    @Override
    public String nomToString() {
        return "Nim";
    }

    @Override
    protected void doExecute(int y) {
        this.Currentnball -= y;
    }

    @Override
    public boolean isOver() {
        return Currentnball == 0;
    }

    @Override
    public Player getWinner() {
        if (!isOver()) { 
            return null; 
        } else if (super.getCurrentPlayer() == this.j1) {
            return super.j1;
        } else {
            return super.j2;
        }
    }

    @Override
    public String moveToString(int y) {
        return y + " allumettes.";
    }

    @Override
    public String situationToString() {
        StringBuilder situation = new StringBuilder();
        System.out.println();
        for (int i = 0; i < getCurrentNbMatches(); i++) {
            situation.append("|| ");
        }
        return situation + "  (Il reste " + getCurrentNbMatches() + " allumettes).";
    }

    @Override
    public Game copy() {
        Nim res = new Nim(this.n, this.k, this.j1, this.j2);
        res.Currentnball = this.Currentnball;
        res.Currentplayer = super.Currentplayer;
        return res;
    }
}








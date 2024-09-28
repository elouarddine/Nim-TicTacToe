package games.genericgames;

import java.util.ArrayList;
import games.players.Player;

public class TicTacToe extends AbstractGame implements Game {

    private Player[][] board;

    public TicTacToe(Player j1, Player j2) {
        super(j1, j2);
        this.board = new Player[3][3];
    }

    @Override
    public String nomToString() {
        return "TicTacToe";
    }

    @Override
    public String situationToString() {
        StringBuilder sb = new StringBuilder();
        
        System.out.println("Le tableau de jeu : ");
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == null) {
                    sb.append(". ");
                } else if (this.board[i][j] == super.j1) {
                    sb.append("X ");
                } else {
                    sb.append("O ");
                }
            }
            sb.append(System.lineSeparator());
        }
        return sb.toString();
    }

    @Override
    public String moveToString(int coup) {
        return coup + " = " + " ( " + getRow(coup) + " , " + getColumn(coup) + " ) ";
    }

    @Override
    public ArrayList<Integer> validMoves() {
        ArrayList<Integer> listMoves = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.board[i][j] == null) {
                    listMoves.add(3 * i + j);
                }
            }
        }
        return listMoves;
    }

    public int getRow(int coup) {
        return coup / 3;
    }

    public int getColumn(int coup) {
        return coup % 3;
    }

    public boolean wins(Player joueur, int row, int col, int deltaRow, int deltaCol) {
        return this.board[row][col] == this.board[row + deltaRow][col + deltaCol]
                && this.board[row][col] == this.board[row + 2 * deltaRow][col + 2 * deltaCol]
                && this.board[row][col] == joueur;
    }

    @Override
    public boolean isValid(int coup) {
        return coup >= 0 && coup < 9 && this.board[getRow(coup)][getColumn(coup)] == null;
    }

    @Override
    public void doExecute(int coup) {
        this.board[this.getRow(coup)][this.getColumn(coup)] = super.Currentplayer;
    }

    @Override
    public boolean isOver() {
        return getWinner() != null || validMoves().isEmpty();
    }

    @Override
    public Player getWinner() {
        for (int i = 0; i < 3; i++) {
            if (wins(super.j1, i, 0, 0, 1) || wins(super.j1, 0, i, 1, 0) || wins(super.j1, 0, 0, 1, 1)
                    || wins(super.j1, 0, 2, 1, -1))
                return super.j1;
            if (wins(super.j2, i, 0, 0, 1) || wins(super.j2, 0, i, 1, 0) || wins(super.j2, 0, 0, 1, 1)
                    || wins(super.j2, 0, 2, 1, -1))
                return super.j2;
        }
        return null;
    }

    @Override
    public Game copy() {
        TicTacToe res = new TicTacToe(this.j1, this.j2);
        res.Currentplayer = super.Currentplayer;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                res.board[i][j] = this.board[i][j];
            }
        }
        return res;
    }
}

package games.players;

import games.genericgames.Game;


public class NegamaxPlayer implements Player{
    public NegamaxPlayer(){}


    /** Algorithme evaluer du cours
     * @param situationcourante , l'instance du jeu choisi
     * @return res, le meilleur coup possible sous forme d'entier
     * @return 1, si le joueur courant est gagnant sous forme d'entier
     * @return -1, si le joueur courant est perdant sous forme d'entier
     * @return 0, si match nul sous forme d'entier
     */
    public int evaluate(Game situationcourante) {

        if (situationcourante.isOver()==true) {
            if (situationcourante.getWinner() == null) {
                return 0;
            } else if (situationcourante.getWinner().equals(situationcourante.getCurrentPlayer())) {
                return 1;
            } else {
                return -1;
            }

        } else {

            // situation is not a finished situation

            Integer res = null;
            for (int coup : situationcourante.validMoves()) {
                Game situation = situationcourante.copy();
                situation.execute(coup);
                int value = -(evaluate(situation));
                if (res == null || value > res) {
                    res = value;
                }
            }

            return res;
        }

    }
    @Override
    public int chooseMove(Game situationcourante) {
        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Thread interrupted: " + e.getMessage());
        }

        Integer bestValue = null;
        Integer bestMove = null;
        for (int coup : situationcourante.validMoves()) {
            Game situation = situationcourante.copy();
            situation.execute(coup);
            int value = -(evaluate(situation));
            if (bestValue == null || value > bestValue) {
                bestValue = value;
                bestMove = coup;
            }
        }
        return bestMove;
    }
}



package games.players;

import games.genericgames.Game;
import java.util.Random;


public class RandomPlayer implements Player {
    private Random rand ;

    public RandomPlayer(Random rand ){
        this.rand = rand ;
    }
 // Methode sert à retourner un coup tiré parmi l’ensemble des coups valides dans la situation donnée
    @Override
    public int chooseMove(Game jeu) {
        // Introduire un délai de 1 seconde (1000 millisecondes)
        try {
            Thread.sleep(600); // Pause execution for 1 second
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.err.println("Interrupted: " + e.getMessage());
        }

        // Tirer un indice aléatoire. This.rand.nextInt(n) retourne un entier tiré dans l’intervalle [0, n[
        int indicealeatoire = this.rand.nextInt(jeu.validMoves().size());

        // Retourner le coup situé à cet indice dans la liste retournée par validMoves
        int couptire = jeu.validMoves().get(indicealeatoire);

        return couptire;
    }
    public String toString () {

        return "Joueur aléatoire n° " + this.hashCode() ;
    }

}
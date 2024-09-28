package games.plays;

import games.genericgames.Game;


public class Orchestrator {
    private Game game ;

    public Orchestrator(Game game) {
        this.game = game;
    }

    // Méthode utiliser pour gérer la partie
    public void play() {

    	
    	System.out.println( " \t\t         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    	System.out.println( " \t\t                                                                                                ");
    	System.out.println( " \t\t                                   Commencement du jeu de "+this.game.nomToString()              );              
    	System.out.println( " \t\t                                                                							      ");
    	System.out.println( " \t\t         * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * * *");
    	
        System.out.println("\n\n");

        while (!this.game.isOver()) {


            //affichant la situation courante du jeu
            System.out.println(game.situationToString());
           
            // le tour du joueur courant pour choisir un coup
            System.out.println("\n ==> C'est le tour de " + game.getCurrentPlayer()+ "\n");
            int coup = game.getCurrentPlayer().chooseMove(this.game);

            // obtenir une représentation naturelle du coup choisi
            System.out.println("Vous avez choisi : " + game.moveToString(coup));
            this.game.execute(coup);

            

        }
        // le cas ou il existe un winner afficher ce winner si le jeu est terminer et il y'a aucun winner afficher partie null
        if (game.getWinner() != null) {

            System.out.println("\n\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("\t\tLe gagnant est : " + game.getWinner());
            System.out.println("\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
        } else {
            System.out.println("\n\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-");
            System.out.println("\t\tMATCH NUL");
            System.out.println("\t\t*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-\n");
        }

    }

}

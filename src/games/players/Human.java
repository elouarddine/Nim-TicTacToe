package games.players;


import java.util.ArrayList ;
import java.util.Scanner;
import games.genericgames.Game;



/* Joueur humain*/
public class Human implements Player{
    protected String nom ;

    //Création de l'instance scan, objet de type Scanner
    protected Scanner scan;

    ArrayList<Integer> coupsValid = new ArrayList<>();


    public  Human(String nom , Scanner scan){

        this.nom = nom;
        this.scan = scan;
    }




    /** Renvoie le coup choisi par le joueur (méthode de l'interface Player)
     * Demande à chaque tour le coup que le joueur veut joueur
     * si le coup est présent dans la liste des coups valides il est renvoyé
     * sinon on affiche un message d'erreur et on redemande un coup
     * @param game, l'instance du jeu choisi
     * @return coup, le coup choisi par le joueur sous forme d'un entier
     */



    @Override
    public int chooseMove(Game game) {

        System.out.println("Les cousps valides sont : \n" ) ;
        for(int coup : game.validMoves()) {
            System.out.println(game.moveToString(coup));
        }
        System.out.println("\n Choisissez votre coup : ");
        int coup = scan.nextInt();
        while(!game.isValid(coup)){
            System.out.println("Coup Impossible !!" );
            System.out.println("Veuillez choisir un autre coup entre les coups suivantes : " + game.validMoves()) ;
            coup = scan.nextInt() ;
        }

        return coup;

       }



    /** Renvoie le nom du joueur
     * @return this.nom, nom du joueur Human sous forme d'une chaine de caractère
     */
    @Override
    public String toString () {
        return this.nom ;
    }

}


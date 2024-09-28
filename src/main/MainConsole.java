package main;

import games.plays.Orchestrator;
import games.genericgames.Nim;
import games.genericgames.TicTacToe;
import games.players.Human;
import games.players.NegamaxPlayer;
import games.players.Player;
import games.players.RandomPlayer;

import java.util.Random;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        
        if (args.length < 3) {
            System.out.println("Usage: java Main <jeu> <joueur1> <joueur2> [<n> <k>]");
            return;
        }

        String choixJeu = args[0];
        String typeJoueur1 = args[1];
        String typeJoueur2 = args[2];
        
        int n = 0;
        int k = 0;

        if (choixJeu.equalsIgnoreCase("Nim")) {
            if (args.length < 5) {
                System.out.println("Pour le jeu de Nim, veuillez fournir <n> (nombre initial d'allumettes) et <k> (nombre maximum d'allumettes à tirer).");
                return;
            }
            try {
                n = Integer.parseInt(args[3]);
                k = Integer.parseInt(args[4]);
            } catch (NumberFormatException e) {
                System.out.println("Les arguments <n> et <k> doivent être des entiers.");
                return;
            }
        }

        Player j1 = creerJoueur(typeJoueur1, "Joueur 1");
        Player j2 = creerJoueur(typeJoueur2, "Joueur 2");

        if (j1 == null || j2 == null) {
            System.out.println("Types de joueurs invalides fournis.");
            return;
        }

        if (choixJeu.equalsIgnoreCase("Nim")) {
            Nim jeuNim = new Nim(n, k, j1, j2);
            Orchestrator orchestrateur = new Orchestrator(jeuNim);
            orchestrateur.play();
        } else if (choixJeu.equalsIgnoreCase("TicTacToe")) {
        	TicTacToe jeuTicTacToe = new TicTacToe(j1, j2);
            Orchestrator orchestrateur = new Orchestrator(jeuTicTacToe);
            orchestrateur.play();
        } else {
            System.out.println("Choix de jeu invalide. Choisissez entre 'Nim' et 'TicTacToe'.");
        }
    }

    private static Player creerJoueur(String typeJoueur, String nomJoueur) {
        switch (typeJoueur.toLowerCase()) {
            case "human":
                return new Human(nomJoueur, new Scanner(System.in));
            case "randomplayer":
                return new RandomPlayer(new Random());
            case "negamaxplayer":
                return new NegamaxPlayer();
            default:
                System.out.println("Type de joueur inconnu : " + typeJoueur);
                return null;
        }
    }

}

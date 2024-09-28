#!/bin/bash
clear


#!/bin/bash

afficher_titre() {
   
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo "          *                                                       *"
    echo "          *                 Application Jeux.                     *"
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
    echo "          *                                                       *"                                
    echo "          	            -- Nim TicTacToe -- 		    ";
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo ""
}



afficher_titre3() {
    clear
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                    Application Jeux.                  *";
   echo "          *                   -- Mode console --                  *";
   echo "          *                                                       *";
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                                                       *"
   echo "          	                   -- Nim --                        ";
   echo "          *                                                       *"
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "";
}


afficher_titre4() {
    clear
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                    Application Jeux.                  *";
   echo "          *                  -- Mode graphique --                 *";
   echo "          *                                                       *";
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                                                       *"
   echo "          	                   -- Nim -- 		           ";
   echo "          *                                                       *"
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "";
}



afficher_titre5() {
    clear
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                    Application Jeux.                  *";
   echo "          *                   -- Mode console --                  *";
   echo "          *                                                       *";
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                                                       *"
   echo "          	                -- TicTacToe --                     ";
   echo "          *                                                       *"
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "";
}


afficher_titre6() {
    clear
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                    Application Jeux.                  *";
   echo "          *                   -- Mode graphique --                *";
   echo "          *                                                       *";
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "          *                                                       *"
   echo "          	                 -- TicTacToe --                    ";
   echo "          *                                                       *"
   echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *";
   echo "";
}


echo "Compilation des sources..."
javac -Xlint:unchecked -d ../build ../src/main/MainConsole.java ../src/games/plays/*.java ../src/games/players/*.java ../src/games/genericgames/*.java


if [ $? -eq 0 ]; then
    echo "Compilation réussie."
else
    echo "Erreur de compilation."
    exit 1
fi

choix_jeux() {
    afficher_titre
    echo "1. Nim"
    echo "2. TicTacToe"
    echo "3. Quitter"
    echo -e -n "\nChoisissez une option: "
}


verifier_entier() {
    local re='^[0-9]+$'
    if ! [[ $1 =~ $re ]] ; then
        return 1
    else
        return 0
    fi
}

valider_n() {
    while true; do
        echo -n "Entrez le nombre total d'allumettes (n): "
        read n
        verifier_entier $n && [ $n -gt 0 ] && break
        echo "Entrée invalide. Veuillez entrer un entier positif."
    done
}

valider_k() {
    while true; do
        echo -n "Entrez le nombre maximal d'allumettes qu'un joueur peut tirer (k): "
        read k
        verifier_entier $k && [ $k -gt 0 ] && [ $k -le $n ] && break
        echo "Entrée invalide. Veuillez entrer un entier positif qui est inférieur ou égal à $n."
    done
}

valider_joueur1() {
    echo "Types de joueurs disponibles :"
    echo "1. Human"
    echo "2. RandomPlayer"
    echo "3. NegamaxPlayer"

    while true; do
        echo -n "Choisissez le type de joueur 1 (1-3): "
        read joueur1
        verifier_entier $joueur1 && [ $joueur1 -ge 1 ] && [ $joueur1 -le 3 ] && break
        echo "Entrée invalide. Veuillez entrer un nombre entre 1 et 3."
    done
}

valider_joueur2() {
    echo "Types de joueurs disponibles :"
    echo "1. Human"
    echo "2. RandomPlayer"
    echo "3. NegamaxPlayer"

    while true; do
        echo -n "Choisissez le type de joueur 2 (1-3): "
        read joueur2
        verifier_entier $joueur2 && [ $joueur2 -ge 1 ] && [ $joueur2 -le 3 ] && break
        echo "Entrée invalide. Veuillez entrer un nombre entre 1 et 3."
    done
}

valider_joueurs() {
    valider_joueur1
    valider_joueur2
}

get_joueur_type() {
    case $1 in
        1) echo "Human" ;;
        2) echo "RandomPlayer" ;;
        3) echo "NegamaxPlayer" ;;
        *) echo "Inconnu" ;;
    esac
}

modifier_donnees() {
    while true; do
        echo -e "\nQuelle donnée souhaitez-vous modifier ?\n"
        echo "1. Nombre total d'allumettes (n)"
        echo "2. Nombre maximal d'allumettes qu'un joueur peut tirer (k)"
        echo "3. Type de joueur 1"
        echo "4. Type de joueur 2"
        echo "5. Terminer les modifications"
        echo -e -n "\nChoisissez une donnée entre 1 et 5: "
        read choix_modif

        case $choix_modif in
            1) valider_n ;;
            2) valider_k ;;
            3) valider_joueur1 ;;
            4) valider_joueur2 ;;
            5) return ;;
            *) echo "Choix invalide. Veuillez réessayer." ;;
        esac

        while true; do
            echo -e "\nVoulez-vous modifier autre chose ? (O/N)"
            read choix_continue
            choix_continue=$(echo "$choix_continue" | tr '[:lower:]' '[:upper:]')

            if [[ "$choix_continue" == "N" ]]; then
                return
            elif [[ "$choix_continue" == "O" ]]; then
                break
            else
                echo "Option invalide. Veuillez entrer 'O' pour Oui ou 'N' pour Non."
            fi
        done
    done
}

modifier_donnees2() {
    while true; do
        echo -e "\nQuelle donnée souhaitez-vous modifier ?\n"
        echo "1. Type de joueur 1"
        echo "2. Type de joueur 2"
        echo "3. Terminer les modifications"
        echo -e -n "\nChoisissez une donnée entre 1 et 3: "
        read choix_modif

        case $choix_modif in
            1) valider_joueur1 ;;
            2) valider_joueur2 ;;
            3) return ;;
            *) echo "Choix invalide. Veuillez réessayer." ;;
        esac

        while true; do
            echo -e "\nVoulez-vous modifier autre chose ? (O/N)"
            read choix_continue
            choix_continue=$(echo "$choix_continue" | tr '[:lower:]' '[:upper:]')

            if [[ "$choix_continue" == "N" ]]; then
                return
            elif [[ "$choix_continue" == "O" ]]; then
                break
            else
                echo "Option invalide. Veuillez entrer 'O' pour Oui ou 'N' pour Non."
            fi
        done
    done
}

nim_console() {
    afficher_titre3
    valider_n
    valider_k
    valider_joueurs

    while true; do
        afficher_recapitulatif
        echo -n "Tout est correct ? (O/N): "
        read correct
        correct=$(echo "$correct" | tr '[:lower:]' '[:upper:]')
        
        if [[ "$correct" == "O" ]]; then
            break
        elif [[ "$correct" == "N" ]]; then
            modifier_donnees
        else
            echo "Option invalide. Veuillez entrer 'O' pour Oui ou 'N' pour Non."
        fi
    done

    echo -e "\n"

    joueur1_type=$(get_joueur_type $joueur1 | tr '[:upper:]' '[:lower:]')
    joueur2_type=$(get_joueur_type $joueur2 | tr '[:upper:]' '[:lower:]')

    echo "Lancement du jeu Nim en mode Console..."
    
    echo -e "\n"

    clear
    java -cp ../build main.MainConsole Nim $joueur1_type $joueur2_type $n $k 
    echo -e "\n"
    echo "===> Appuyez sur n'importe quelle touche pour revenir."
    read
}

tictactoe_console() {
    afficher_titre5
    valider_joueurs

    while true; do
        afficher_recapitulatif2
        echo -n "Tout est correct ? (O/N): "
        read correct
        correct=$(echo "$correct" | tr '[:lower:]' '[:upper:]')
        
        if [[ "$correct" == "O" ]]; then
            break
        elif [[ "$correct" == "N" ]]; then
            modifier_donnees2
        else
            echo "Option invalide. Veuillez entrer 'O' pour Oui ou 'N' pour Non."
        fi
    done

    echo -e "\n"

    joueur1_type=$(get_joueur_type $joueur1 | tr '[:upper:]' '[:lower:]')
    joueur2_type=$(get_joueur_type $joueur2 | tr '[:upper:]' '[:lower:]')

    echo "Lancement du jeu TicTacToe en mode Console..."
    
    echo -e "\n"

    clear
    java -cp ../build main.MainConsole TicTacToe $joueur1_type $joueur2_type 
    echo -e "\n"
    echo "===> Appuyez sur n'importe quelle touche pour revenir."
    read
}





afficher_recapitulatif() {
    clear
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo "          *                   Application Nim                     *"
    echo "          *                  -- Mode console --                   *"
    echo "          *                                                       *"
    echo "          *                --Personnaliser mon jeu--              *"
    echo "          *                                                       *"
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo "          *                                                       *"
    echo "          *              Récapitulatif de vos choix               *"
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo "          *                                                       *"
    echo "          *     Nombre total d'allumettes (n): $n                 "
    echo "          *     Nombre maximal d'allumettes (k): $k               "
    echo "          *     Joueur 1: $(get_joueur_type $joueur1)             "
    echo "          *     Joueur 2: $(get_joueur_type $joueur2)             "
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo ""
}




afficher_recapitulatif2() {
    clear
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo "          *                 Application TicTacToe                 *"
    echo "          *                  -- Mode console --                   *"
    echo "          *                                                       *"
    echo "          *                --Personnaliser mon jeu--              *"
    echo "          *                                                       *"
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo "          *                                                       *"
    echo "          *              Récapitulatif de vos choix               *"
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"
    echo "          *                                                       *"
    echo "          *     Joueur 1: $(get_joueur_type $joueur1)             "
    echo "          *     Joueur 2: $(get_joueur_type $joueur2)             "
    echo "          *                                                       *"
    echo "          * * * * * * * * * * * * * * * * * * * * * * * * * * * * *"    
}







traiter_mode_gui() {
    echo -e "\nLancement du mode GUI...\n"
    java -cp ../build main.MainGui
    echo "===> Appuyez sur n'importe quelle touche pour revenir."
    read
}





while true; do
    clear
    choix_jeux
    read choix_jeu
    case "$choix_jeu" in
        1) nim_console ;;
        2) tictactoe_console ;;
        3) echo "Au revoir !" ; exit 0 ;;
    esac
done

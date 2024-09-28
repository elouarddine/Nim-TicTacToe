
# README - Application Nim et TicTacToe

Ce projet représente un jeu combinant le **Nim** et le **TicTacToe**. Vous pouvez jouer à ces deux jeux en mode console. Le menu principal vous permettra de choisir entre **Nim**, **TicTacToe**, ou de quitter l'application.

## Fonctionnalités

- **Jeu de Nim** : 
  - L'utilisateur doit entrer le nombre total d'allumettes (`n`) et le nombre maximal d'allumettes que chaque joueur peut retirer par tour (`k`).
  - Le jeu permet de choisir le type de joueurs (Humain, Joueur aléatoire, ou Joueur Negamax).
  
- **Jeu de TicTacToe** :
  - Le jeu propose également de choisir le type de joueurs pour chacun des participants (Humain, Joueur aléatoire, ou Joueur Negamax).

## Instructions d'utilisation

### Lancer l'application

1. Dans votre terminal, déplacez-vous dans le répertoire `scripts` où se trouve le fichier `script.sh` :
   ```bash
   cd chemin/vers/scripts
   ```

2. Exécutez le script de lancement avec la commande suivante :
   ```bash
   ./script.sh
   ```

3. Un menu principal apparaîtra avec trois options :
   - [1] Nim
   - [2] TicTacToe
   - [3] Quitter

4. Choisissez l'option souhaitée :
   - Si vous sélectionnez **Nim** ou **TicTacToe**, l'application vous demandera de définir certains paramètres (comme le nombre d'allumettes pour Nim ou les types de joueurs pour chaque jeu).
   - Une fois les paramètres définis, le jeu commencera automatiquement.

### Paramètres pour le jeu de Nim

- **Nombre total d'allumettes (`n`)** : vous devez entrer un entier positif.
- **Nombre maximal d'allumettes qu'un joueur peut retirer (`k`)** : cet entier doit être inférieur ou égal à `n`.
- **Type de joueur** : vous pouvez choisir entre les options suivantes pour chaque joueur :
  - [1] Humain
  - [2] RandomPlayer (joueur aléatoire)
  - [3] NegamaxPlayer (algorithme Negamax)

### Paramètres pour le jeu de TicTacToe

- **Type de joueur** : similaire au jeu de Nim, vous pouvez choisir le type de chaque joueur entre :
  - [1] Humain
  - [2] RandomPlayer
  - [3] NegamaxPlayer

## Structure du projet

Les fichiers Java sont répartis dans plusieurs répertoires selon les fonctionnalités :

- `../src/main/` : contient la classe principale de l'application.
- `../src/games/plays/` : classes liées aux différentes actions de jeu.
- `../src/games/players/` : gestion des différents types de joueurs.
- `../src/games/genericgames/` : fonctionnalités communes aux jeux.

## Compilation et Exécution

1. Dans votre terminal, déplacez-vous dans le répertoire `scripts` où se trouve le fichier `script.sh` :
   ```bash
   cd chemin/vers/scripts
   ```

2. Exécutez le script de jeu pour compiler et démarrer l'application :
   ```bash
   ./script.sh
   ```

## Quitter l'application

Pour quitter le jeu, choisissez l'option **[3] Quitter** dans le menu principal.

package games.genericgames;


import games.players.Player;

public abstract class AbstractGame implements Game {
    protected Player j1;
    protected Player j2;
    protected Player Currentplayer;

    public AbstractGame(Player j1 , Player j2){
        this.j1 = j1;
        this.j2 = j2;
        this.Currentplayer = j1;
    }

    protected abstract void doExecute(int coup);

    public void execute(int coup) {
        doExecute(coup);
        this.Currentplayer = (this.Currentplayer.equals(this.j1)) ? this.j2 : this.j1;
    }

    public Player getCurrentPlayer() {

        return this.Currentplayer ;
    }


}




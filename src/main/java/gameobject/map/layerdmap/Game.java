package gameobject.map.layerdmap;

import controllers.GameController;

import java.util.ArrayList;

public class Game implements Runnable {
    public final GameController gameController;
    public final GameMap gameMap;

    public Game(GameController gameController, GameMap gameMap) {
        this.gameController = gameController;
        this.gameMap = gameMap;
    }
    protected void init(){
        gameMap.country.init();
        gameMap.organisms.unit();
    }




    @Override
    public void run() {
    }
}


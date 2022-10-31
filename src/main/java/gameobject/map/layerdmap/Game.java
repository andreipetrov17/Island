package gameobject.map.layerdmap;

import controllers.GameController;

import java.util.ArrayList;

public class Game implements Runnable {
    public final GameController gameController;
    public final GameMap gameMap;

    public Game(GameController gameController, GameMap gameMap) {
        this.gameController = gameController;
        this.gameMap = gameMap;
        init();
    }
    protected void init(){
        gameMap.country.init();
        gameMap.organisms.unit();
        gameMap.view.init();
        Thread thread = new Thread(gameMap.view);
        thread.start();

    }




    @Override
    public void run() {
    }
}


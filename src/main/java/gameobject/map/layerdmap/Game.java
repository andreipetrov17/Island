package gameobject.map.layerdmap;

import controllers.GameController;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

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
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Arrays.stream(gameMap.view.getArr()).forEach(viewField -> {
                    viewField.label.setBackground(Color.RED);
                    viewField.label.revalidate();
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                } );
            }
        });
        try {
            thread1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread1.start();
    }




    @Override
    public void run() {
    }
}


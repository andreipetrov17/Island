package Functions;

import controllers.GameController;
import gameobject.map.layerdmap.GameMap;

import java.util.concurrent.Callable;

public abstract class AbstractFunction implements Runnable{
    public GameMap ply;
    public Thread endCycle;
    public Thread endNext;
    public GameController gameController;
    public AbstractFunction(GameController gameController){
        this.gameController = gameController;
        setStopper(500);
    }
    public void setStopper(int sleep){
        endCycle = new Thread(new Runnable() {
            @Override
            public void run() {
                while(gameController.getMode().isStopCycle()){
                    try {
                        Thread.sleep(sleep);
                        System.out.println("Конец хода");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        endNext = new Thread(new Runnable() {
            @Override
            public void run() {
                while(gameController.getMode().isStopNext()){
                    try {
                        Thread.sleep(sleep);
                        System.out.println("Конец цикла");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

}

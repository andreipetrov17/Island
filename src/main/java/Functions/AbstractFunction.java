package Functions;

import controllers.GameController;
import gameobject.map.layerdmap.GameMap;

import java.util.concurrent.Callable;

public abstract class AbstractFunction implements Runnable{
    public GameMap ply;


    public GameController gameController;
    public AbstractFunction(GameController gameController){
        this.gameController = gameController;
    }
    public Thread getStopperCycle(int sleep){
        return new Thread(() -> {
            while(gameController.getMode().isStopCycle()){
                try {
                    Thread.sleep(sleep);
                    System.out.println("Конец цикла");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public Thread getStopperNext(int sleep){
        return new Thread(() -> {
            while(gameController.getMode().isStopNext()){
                try {
                    Thread.sleep(sleep);
                    System.out.println("Конец хода");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

}

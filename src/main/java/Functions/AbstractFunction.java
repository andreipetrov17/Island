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
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public Thread getStopperStep(int sleep){
        return new Thread(() -> {
            while(gameController.getMode().isStopNext()){
                try {
                    Thread.sleep(sleep);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
    public void stopNextStep(){
        Thread thread = getStopperStep(500);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void stopNextCycle(){
        Thread thread = getStopperCycle(500);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

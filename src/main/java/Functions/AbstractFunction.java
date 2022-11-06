package Functions;

import gameobject.map.layerdmap.GameMap;

import java.util.concurrent.Callable;

public class AbstractFunction implements Runnable, Callable {
    public GameMap ply;
    public AbstractFunction(){

    }
    @Override
    public void run() {

    }

    @Override
    public String call() throws Exception {
        return null;
    }
}

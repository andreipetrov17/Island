package gameobject.map.layerdmap;

import Functions.AbstractFunction;
import controllers.GameController;

public class Game<T extends AbstractFunction>  {
    public final GameController gameController;
    public final GameMap gameMap;
    private final T function;

    public Game(GameController gameController, GameMap gameMap, T function) {
        this.gameController = gameController;
        this.gameMap = gameMap;
        this.function = function;
        function.gameMap = gameMap;
        init();
    }
    protected void init() {
        gameMap.country.init();
        gameMap.organisms.unit();
        gameMap.view.init();
        Thread thread = new Thread(function);
        thread.start();
    }




}


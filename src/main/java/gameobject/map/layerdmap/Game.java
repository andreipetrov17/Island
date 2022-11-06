package gameobject.map.layerdmap;

import Functions.AbstractFunction;
import controllers.GameController;

public class Game<T extends AbstractFunction>  {
    public final GameController gameController;
    public final GameMap ply;
    private final T function;

    public Game(GameController gameController, GameMap gameMap, T function) {
        this.gameController = gameController;
        this.ply = gameMap;
        this.function = function;
        function.ply = gameMap;
        init();
    }
    protected void init() {
        ply.country.init();
        ply.organisms.unit();
        ply.view.init();
        Thread thread = new Thread(function);
        thread.start();
    }




}


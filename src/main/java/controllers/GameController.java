package controllers;

import commands.game.AbstractGameAction;
import commands.game.CycleNext;
import commands.game.GameAction;
import commands.main.AbstractLoader;

public class GameController {
    private Thread mainThread;
    public AbstractGameAction doGameAction(){
        return new CycleNext();
    }
}

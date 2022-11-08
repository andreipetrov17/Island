package controllers;

import commands.game.AbstractGameAction;
import commands.game.CycleNext;
import commands.game.GameAction;
import commands.game.GameStopper;
import commands.main.AbstractLoader;

public class GameController {
    private Thread stopper;
    public AbstractGameAction currentMode = GameActionContainer.get("stop");

    public void changeMode(String str){
    currentMode =  GameActionContainer.get(str);
    }
    public AbstractGameAction getMode(){
        return currentMode;
    }
}

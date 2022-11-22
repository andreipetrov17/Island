package controllers;

import commands.game.StopAction;

public class GameController {
    public StopAction currentMode = GameActionContainer.get("stop");

    public void changeMode(String str){
    currentMode =  GameActionContainer.get(str);
    }
    public StopAction getMode(){
        return currentMode;
    }
}

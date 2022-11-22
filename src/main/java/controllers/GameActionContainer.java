package controllers;

import commands.game.*;

public enum GameActionContainer {
    RUN(new StopAction(false, false)),
    STOP(new StopAction(true, true)),
    NEXT_CYCLE(new StopAction(true,false)),
    NEXT_STEP(new StopAction(true, true));
    StopAction action;

    GameActionContainer(StopAction action){
        this.action = action;
    }
    public static StopAction get(String actionName){
        StopAction action = GameActionContainer.valueOf(actionName.toUpperCase()).action;
        return action;
    }
}

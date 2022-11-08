package controllers;

import commands.game.*;
import commands.main.Action;

public enum GameActionContainer {
    RUN(new GameStarter(false, false)),
    STOP(new GameStopper(true, true)),
    NEXT_CYCLE(new CycleNext(true,false)),
    NEXT_STEP(new StepNext(true, true));
    AbstractGameAction action;

    GameActionContainer(AbstractGameAction action){
        this.action = action;
    }
    public static AbstractGameAction get(String actionName){
        AbstractGameAction action = GameActionContainer.valueOf(actionName.toUpperCase()).action;
        return action;
    }
}

package controllers;

import commands.main.*;
import swing.GameFrame;

@SuppressWarnings("unused")
public enum MenuActionContainer {
    NEW(new NewGameLoader()),
    LOAD(new MapEditorLoader()),
    SAVE(new SaveGameLoader()),
    SETTINGS(new SaveGameLoader()),
    EXIT(new ExitLoader()),
    MENU(new MenuLoader(Action.frame.mainController));
    private Action action;
    private boolean isExist = false;


    MenuActionContainer(Action action) {
        this.action = action;
    }

    public static Action get(String actionName){
        Action action1 = performed(MenuActionContainer.valueOf(actionName.toUpperCase()));
        return action1;
    }
    private static Action performed(MenuActionContainer actionContainer){
        actionContainer.isExist = true;
        return actionContainer.action;
    }
}

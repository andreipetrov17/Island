package controllers;

import commands.main.*;

@SuppressWarnings("unused")
public enum MenuActionContainer {
    TEST_INIT_FIELD(new TestUnitLoader()),
    TEST_FUNCTION_STOP(new TestStopLoader()),
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
        Action action = performed(MenuActionContainer.valueOf(actionName.toUpperCase()));
        return action;
    }
    private static Action performed(MenuActionContainer actionContainer){
        actionContainer.isExist = true;
        return actionContainer.action;
    }
}

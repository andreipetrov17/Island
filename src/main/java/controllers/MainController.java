package controllers;

import commands.main.Action;

public class MainController {
    public Action doAction(String str){
        Action action = MenuActionContainer.get(str);
        action.execute();
        return  action;
    }
}

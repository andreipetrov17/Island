package commands.main;

import commands.main.Action;

public class ExitLoader extends AbstractLoader implements Action {
    public ExitLoader(){

    }

    @Override
    public void execute() {
        System.exit(0);
    }
}

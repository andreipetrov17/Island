package commands.main;

import commands.main.Action;
import swing.LoadGamePanel;

public class OldGameLoader extends AbstractLoader implements Action {
    public OldGameLoader(){
    }

    @Override
    public void execute() {
        changeView(new LoadGamePanel());
    }
}

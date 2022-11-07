package commands.main;

import commands.main.Action;
import swing.LoadGamePanel;

public class OldGameLoader extends AbstractLoader {
    public OldGameLoader(){
    }

    @Override
    public void execute() {
        changeView(new LoadGamePanel());
    }
}

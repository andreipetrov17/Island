package commands.main;

import commands.main.Action;
import controllers.MainController;
import swing.MainMenu;

public class MenuLoader extends AbstractLoader implements Action {
    private MainController mainController;
    public MenuLoader(MainController mainController){
        this.mainController = mainController;
    }

    @Override
    public void execute() {
        changeView(new MainMenu(mainController));
        frame.requestFocusInWindow();
    }
}

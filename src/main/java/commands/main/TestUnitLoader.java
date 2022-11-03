package commands.main;

import Functions.TestCommonRes;
import controllers.GameController;
import gameobject.map.layerdmap.Game;
import gameobject.map.layerdmap.GameMap;
import swing.components.viewport.FieldPanel;
import swing.components.viewport.ViewportPanel;

public class TestUnitLoader extends AbstractLoader implements Action {
    public TestUnitLoader(){

    }
    @Override
    public void execute() {
        int x = 3;
        int y = 4;
        Game<TestCommonRes> game;
        game = new Game(new GameController(), new GameMap(x, y), new TestCommonRes());
        changeView(new ViewportPanel(new FieldPanel(game.gameMap)));

    }
}
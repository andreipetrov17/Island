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
        Game<TestCommonRes> game;
        game = new Game(new GameController(), new GameMap(3, 4), new TestCommonRes());
        changeView((new ViewportPanel(new FieldPanel(game.ply))));

    }
}
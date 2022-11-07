package commands.main;

import Functions.TestCommonRes;
import controllers.GameController;
import gameobject.map.layerdmap.Game;
import gameobject.map.layerdmap.GameMap;
import swing.components.viewport.FieldPanel;
import swing.components.viewport.ViewportPanel;

public class TestUnitLoader extends AbstractLoader {
    public TestUnitLoader(){

    }
    @Override
    public void execute() {
        Game<TestCommonRes> game;
        GameController gameController = new GameController();
        game = new Game(gameController, new GameMap(30, 40), new TestCommonRes());
        changeView((new ViewportPanel(new FieldPanel(game.ply), gameController)));

    }
}
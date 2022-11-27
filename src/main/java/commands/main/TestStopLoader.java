package commands.main;

import Functions.TestCommonRes;
import Functions.TestStop;
import controllers.GameController;
import gameobject.map.layerdmap.Game;
import gameobject.map.layerdmap.GameMap;
import swing.components.viewport.FieldPanel;
import swing.components.viewport.ViewportPanel;

import javax.swing.*;

public class TestStopLoader extends AbstractLoader{
    @Override
    public void execute() {
        Game<TestStop> game;
        GameController gameController = new GameController();
        game = new Game(gameController, new GameMap(30, 40), new TestStop(gameController));
        changeView((new ViewportPanel(new FieldPanel(game.ply), gameController)));
    }
}

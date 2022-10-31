package swing.components.viewport;
import gameobject.map.layerdmap.CountryMap;
import gameobject.map.layerdmap.Game;
import gameobject.map.layerdmap.GameMap;
import gameobject.map.layerdmap.ViewField;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    public FieldPanel(GameMap gameMap){
        int x = gameMap.width;
        int y = gameMap.height;
        setFocusable(false);
        setOpaque(false);
        setLayout(new GridLayout(x, y,1,1));
        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                add(gameMap.view.get()[j][i].label);
            }
        }
    }
}

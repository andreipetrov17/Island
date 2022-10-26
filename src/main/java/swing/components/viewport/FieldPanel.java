package swing.components.viewport;
import gameobject.map.layerdmap.Game;
import gameobject.map.layerdmap.ViewField;

import javax.swing.*;
import java.awt.*;

public class FieldPanel extends JPanel {
    public FieldPanel(){
        setFocusable(false);
        setOpaque(false);
        setLayout(new GridLayout(Game.y, Game.x,1,1));
        for (int i = 0; i < Game.y; i++) {
            for (int j = 0; j < Game.x; j++) {
                add(((ViewField)Game.getInstance().viewMap.get()[j][i]).label);
            }
        }
    }
}

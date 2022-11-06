package swing;

import gameobject.map.layerdmap.GameMap;
import swing.components.StatisticPanel;
import swing.components.viewport.FieldPanel;
import swing.components.viewport.ViewportPanel;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {
    public ViewportPanel viewportPanel;
    public StatisticPanel statisticPanel;
    public GamePanel(){
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 1;
        gbc.gridy = 0;
    }
}

package gameobject.map.layerdmap;

import javax.swing.*;
import java.awt.*;

public class ViewField extends AbstractField{
    public JLabel label;
    public ViewField(){
            label = new JLabel("");
            label.setPreferredSize(new Dimension(45,45));
            label.setOpaque(true);
            label.setBackground(Color.GRAY);

    }
    }


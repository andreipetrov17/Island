package gameobject.map.layerdmap;

import javax.swing.*;
import java.awt.*;

public class ViewField extends AbstractField{
    public JLabel label;
    public ViewField(int x, int y){
        super(x,y);
        label = new JLabel("");
        label.setMinimumSize(new Dimension(50,50));
        label.setMaximumSize(new Dimension(100, 100));
        label.setOpaque(true);
        label.setBackground(Color.BLUE);

    }
//    public void setText(String str){
//        label.setText(str);
//    }
}


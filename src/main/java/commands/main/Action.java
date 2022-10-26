package commands.main;

import controllers.MainController;
import swing.GameFrame;

import javax.swing.*;
import java.awt.*;

public interface Action<T extends JPanel> {
   GameFrame frame = GameFrame.getInstance();
    void execute();
    default void changeView(T panel){
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel, BorderLayout.CENTER);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
        frame.requestFocusInWindow();
    }
}

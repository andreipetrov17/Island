package commands.main;

import commands.main.Action;

import javax.swing.*;
import java.awt.*;

public class MapEditorLoader extends AbstractLoader{
    @Override
    public void execute() {
        System.setProperty("file.encoding", "UTF-8");
        //Toolkit.getDefaultToolkit().

        JPanel panel = new JPanel();
        JLabel label = new JLabel("!!!!\uD83D\uDC3B");
       // Font font = new Font("segoe ui emoji", Font.PLAIN, 30);
       // label.setFont(font);
        label.setOpaque(true);
        // label.
        label.setText("<html>&#129427;&#129409;!!\uD83D\uDC3B</html>");

        panel.add(label);
        changeView(panel);
        System.out.println("!!!!");
    }
}

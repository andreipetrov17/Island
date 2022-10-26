package swing;

import controllers.MenuActionContainer;
import controllers.MainController;

import javax.swing.*;
import java.awt.*;

public class MainMenu extends JPanel{
    public MainMenu(MainController mainController) {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        MenuActionContainer[] actionContainers = MenuActionContainer.values();
        for(MenuActionContainer command : actionContainers){
            gbc.gridy++;
            JButton jButton = new JButton(command.toString());
            jButton.setFocusable(false);
            add(jButton, gbc);
            jButton.addActionListener((e) ->mainController.doAction(command.toString()));
        }

    }
}

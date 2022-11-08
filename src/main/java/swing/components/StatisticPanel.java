package swing.components;

import controllers.GameController;
import swing.components.viewport.ViewportPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatisticPanel extends JPanel {
    JScrollPane scrollPane = new JScrollPane();
    JTextArea textArea = new JTextArea();
    private final GameController gameController;
    public StatisticPanel(GameController gameController){
        this.gameController = gameController;
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 0.05;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        add(new JLabel("статистика"), gbc);
        gbc.gridy = 1;
        JButton button = new JButton("!!!");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameController.changeMode("run");
                System.out.println("Режим поменен");
                button.setBackground(Color.BLUE);
            }
        });
        add(button, gbc);
        requestFocusInWindow();
        textArea.setMinimumSize(new Dimension(300, 300));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        scrollPane.add(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);


    }
}

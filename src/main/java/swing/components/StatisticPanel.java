package swing.components;

import javax.swing.*;
import java.awt.*;

public class StatisticPanel extends JPanel {
    JScrollPane scrollPane = new JScrollPane();
    JTextArea textArea = new JTextArea();
    public StatisticPanel(){
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
        add(new JButton("!!!"), gbc);
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

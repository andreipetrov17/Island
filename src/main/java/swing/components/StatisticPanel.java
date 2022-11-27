package swing.components;

import controllers.GameActionContainer;
import controllers.GameController;
import swing.icon.Icons;
import swing.printout.SwingOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintStream;

public class StatisticPanel extends JPanel {
//    JScrollPane scrollPane = new JScrollPane();
    JTextArea textArea = new JTextArea();
    SwingOutput output = new SwingOutput(textArea);
    private final GameController gameController;
    public StatisticPanel(GameController gameController){
        this.gameController = gameController;
        PrintStream printStream = new PrintStream(output);
        System.setOut(printStream);
        System.setErr(printStream);
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



        add(new ButtonPanel(), gbc);
        textArea.setMinimumSize(new Dimension(300, 300));
        textArea.setLineWrap(true);
        textArea.setEditable(false);
        textArea.setOpaque(false);

//        scrollPane.add(textArea);
//        scrollPane.add(new JLabel("!!!!"));
//        scrollPane.setOpaque(true);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        add(textArea, gbc);


    }
    class ButtonPanel extends JPanel{
        private ButtonPanel(){
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.fill = GridBagConstraints.BOTH;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.gridheight = 1;
            gbc.gridwidth = 1;
            for(GameActionContainer action: GameActionContainer.values()){
                String name = action.name();
                Icon icon = new ImageIcon(Icons.getResources(name));
                JButton button = new JButton(icon);
                button.addActionListener(e -> {
                    new Thread(() -> {
                        gameController.changeMode("run");
                        gameController.changeMode(name);
                        System.out.println(gameController.getMode().toString());
                    }).start();
                });
                button.setFocusable(false);
                add(button,gbc);
                gbc.gridx++;

            }
        }
    }
}

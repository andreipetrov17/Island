package swing;

import controllers.MainController;
import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class GameFrame extends JFrame {
    private JPanel[] mainBorder = new JPanel[4];
    private static GameFrame instance;

    public MainController mainController;
    private GameFrame(MainController mainController){
        super();
        instance = this;
        this.mainController = mainController;
        setFocusableWindowState(true);
        setAlwaysOnTop(true);
        setUndecorated(true);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setLayout(new BorderLayout());
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                mainController.doAction("menu");
            }
        });

        setVisible(true);


    }
    private JPanel[] getMainBorder(){

        //for()
        return null;
    }

    public static GameFrame getInstance(){
        if(instance == null){
            return new GameFrame(new MainController());
        } else throw new RuntimeException();

    }
}
/*
 String ACTION_KEY = "theAction";
        Action getMenu = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Menu");
            }
        };
        JRootPane rootPane = getRootPane();
        KeyStroke esc = KeyStroke.getKeyStroke(ACTION_KEY);
        rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(esc, ACTION_KEY);
        rootPane.getActionMap().put(ACTION_KEY, getMenu);

        //setFocusableWindowState(true);
        //setFocusTraversalKeysEnabled(true);
 */
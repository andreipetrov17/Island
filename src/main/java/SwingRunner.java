import commands.main.MenuLoader;
import controllers.MainController;
import gameobject.map.layerdmap.*;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;

public class SwingRunner {


    public static void main(String[] args) throws InstantiationException, IllegalAccessException {

       SwingUtilities.invokeLater(new Runnable() {

           @Override
            public void run() {
               MainController mainController = new MainController();
               (new MenuLoader(mainController)).execute();
           }

        });
       }
    }







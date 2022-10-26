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
               OrganismMap map = new OrganismMap();
               Game.getInstance().initialize();
               // AbstractMap<CountryField, CountryField> statisticMap = new StatisticMap();
               // System.out.println((((OrganismField)Game.getInstance().organismMap.get()[1][1]).population[0].atomicCommonRes.value.get((((OrganismField)Game.getInstance().organismMap.get()[1][1]).population[0].atomicCommonRes.value.length()-1)/2)));
              // System.out.println((((OrganismField)Game.getInstance().organismMap.get()[1][1]).population[0]));


           }

        });
       }
    }







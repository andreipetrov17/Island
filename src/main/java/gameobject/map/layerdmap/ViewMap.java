package gameobject.map.layerdmap;

import garbage.AddFont;

import java.awt.*;

public class ViewMap extends AbstractMap<ViewField> implements Runnable{
    public ViewMap(GameMap gameMap) {
        super(ViewField.class, gameMap);
    }
    public void init() {
        for (int y = 0; y < get()[0].length; y++) {
            for (int x = 0; x < get().length; x++) {
                get()[x][y].setText("" + gameMap.country.get()[x][y].moveOptions[0]);
                if (gameMap.country.get()[x][y].getTerritory() != Territory.WATER) {
                       get()[x][y].label.setBackground(Color.GRAY);
                } else{
                    get()[x][y].label.setBackground(Color.BLUE);
                    System.out.println("!!!!");
                }
                get()[x][y].label.revalidate();
            }
        }
    }
    @Override
    public void run() {
        for (int y = 0; y < get()[0].length; y++) {
            for (int x = 0; x < get().length; x++) {
                get()[x][y].label.setBackground(Color.BLACK);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                get()[x][y].label.revalidate();
                System.out.println(get()[x][y].getX() + "|" + get()[x][y].getY());
            }

        }
    }
}

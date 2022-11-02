package gameobject.map.layerdmap;

import constants.Characteristic;
import entity.Population;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

public class ViewMap extends AbstractMap<ViewField> implements Runnable{
    public ViewMap(GameMap gameMap) {
        super(ViewField.class, gameMap);
    }
    public void init() {
        Optional<Characteristic> optional = gameMap.statistic.state.entrySet()
                .stream()
                .filter(e -> e.getValue()!=true)
                .map(Map.Entry::getKey)
                .findAny();
        Arrays.stream(gameMap.country.getArr()).
                filter(e -> e.getTerritory() != Territory.WATER)
                .forEach(e -> {
            int x = e.getX();
            int y = e.getY();
            get()[x][y].label.setBackground(Color.GRAY);
                    for (Characteristic characteristic: optional.stream().toList()) {
                        Population population = gameMap.organisms.get()[x][y].population[characteristic.ordinal()];
                        get()[x][y].label.setText("!!!"
                                + population.totoString() +"<BR>" +
                                population.capacity);
                        get()[x][y].label.revalidate();
                    }

        });

    }
    @Override
    public void run() {

    }
}

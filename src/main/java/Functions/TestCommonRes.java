package Functions;

import constants.Characteristic;
import entity.Population;
import gameobject.map.layerdmap.Territory;

import java.awt.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class TestCommonRes extends AbstractFunction{
    public TestCommonRes(){

    }
    @Override
    public void run() {
        Optional<Characteristic> optional = gameMap.statistic.state.entrySet()
                .stream()
                .filter(e -> !e.getValue())
                .map(Map.Entry::getKey)
                .findAny();
        Arrays.stream(gameMap.country.getArr())
                .filter(e -> e.getTerritory() != Territory.WATER)
                .forEach(e -> {
                    int x = e.getX();
                    int y = e.getY();
                    gameMap.view.get()[x][y].label.setBackground(Color.GRAY);
                    for (Characteristic characteristic: optional.stream().toList()) {
                        Population population = gameMap.organisms.get()[x][y].population[characteristic.ordinal()];
                        gameMap.view.get()[x][y].label.setText("<HTML>" + population.toString() +"<BR>" + population.commonMoveRes.toString() +
                                "<BR>" + gameMap.country.get()[x][y].moveOptions[3].toString() + "</HTML>");
                    }

                });
        gameMap.view.revalidateAll();
    }

    @Override
    public String call() throws Exception {
        return super.call();
    }
}

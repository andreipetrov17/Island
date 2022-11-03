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
                .findFirst();

        Arrays.stream(gameMap.country.getArr())
                .filter(e -> e.getTerritory() != Territory.WATER)
                .forEach(e -> {
                    e.getIn(gameMap.view).label.setBackground(Color.GRAY);
                    for (Characteristic characteristic: optional.stream().toList()) {
                        Population population = e.getIn(gameMap.organisms).population[characteristic.ordinal()];
                        e.getIn(gameMap.view).label.setText("<HTML>" + population.toString() +"<BR>" + population.commonMoveRes.toString() +
                                "<BR>" + e.getIn(gameMap.country).moveOptions[3].toString() + "</HTML>");
                    }

                });
        gameMap.view.revalidateAll();
    }

    @Override
    public String call() throws Exception {
        return super.call();
    }
}

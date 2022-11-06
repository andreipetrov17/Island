package Functions;

import constants.Characteristic;
import entity.Population;
import gameobject.map.layerdmap.Territory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class TestCommonRes extends AbstractFunction{
    public TestCommonRes(){

    }
    @Override
    public void run() {
        Optional<Characteristic> optional = ply.statistic.state.entrySet()
                .stream()
                .filter(e -> !e.getValue())
                .map(Map.Entry::getKey)
                .findFirst();
        //Stream<CountryField> countryFields = Arrays.stream(gameMap.country.getArr());
        Arrays.stream(ply.country.getArr())
                .filter(e -> e.getTerritory() != Territory.WATER)
                .forEach(e -> showCommonRes(optional.get()));
        ply.view.revalidateAll();
    }

    @Override
    public String call() throws Exception {
        return super.call();
    }
    private void showCommonRes(Characteristic characteristic){
        ArrayList<JLabel> labels = new ArrayList<>();
        ply.organisms.habitPlace.forEach(e -> {
                    e.getIn(ply.view).label.setBackground(Color.GRAY);
                        Population population = e.getIn(ply.organisms).population[characteristic.ordinal()];
                        e.getIn(ply.view).label.setText("<HTML>"
                                + characteristic.name() + "<BR>"
                                + e.getIn(ply.organisms).population[characteristic.ordinal()].capacity + "<BR>"
                                + population.toString() +"<BR>"
                                + population.commonMoveRes.toString() + "<BR>"
                                + "<BR>" + e.getIn(ply.country).moveOptions[3].toString() + "</HTML>");
                                labels.add(e.getIn(ply.view).label);

            try {
                ply.view.blackLightLabel(Color.RED, labels.stream(), 2000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }


        });
    }

}

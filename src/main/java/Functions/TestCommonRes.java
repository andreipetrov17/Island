package Functions;

import constants.Characteristic;
import controllers.GameController;
import entity.Population;
import gameobject.map.layerdmap.Territory;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.Optional;

public class TestCommonRes extends AbstractFunction{
    public TestCommonRes(GameController gameController){
        super(gameController);

    }
    @Override
    public void run() {
        endCycle.start();
        try {
            if(endCycle.isAlive()) {
                Thread.currentThread().join();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("пошла нить");
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


    private void showCommonRes(Characteristic characteristic){
        ArrayList<JLabel> labels = new ArrayList<>();
        ply.organisms.habitPlace.forEach(e -> {
                    e.getIn(ply.view).label.setBackground(Color.GRAY);
                        Population population = e.getIn(ply.organisms).population[characteristic.ordinal()];
                        e.getIn(ply.view).label.setText("<HTML>"
                                + characteristic.name() + "<BR>"
                                + e.getIn(ply.organisms).population[characteristic.ordinal()].capacity + "<BR>"
                                + population.toString() +"<BR>"
                                //+ population.commonMoveRes.toString() + "<BR>"
                                + "<BR>" + e.getIn(ply.country).moveOptions[3].toString() + "</HTML>");
                                labels.add(e.getIn(ply.view).label);

            try {
                ply.view.blackLightLabel(Color.RED, labels.stream(), 20);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }


        });
    }

}

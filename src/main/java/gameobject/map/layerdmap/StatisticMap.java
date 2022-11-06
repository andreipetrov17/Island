package gameobject.map.layerdmap;

import commands.main.ViewStatistic;
import constants.Characteristic;

import java.util.HashMap;
import java.util.Map;

public class StatisticMap  extends AbstractMap<StatisticField> implements ViewStatistic{
    public Map<Characteristic, Boolean> state = new HashMap<>();
    public StatisticMap(GameMap gameMap) {
        super(StatisticField.class,  gameMap);
        for(Characteristic characteristic:Characteristic.values()){
            state.put(characteristic, false);
        }
        state.put(Characteristic.GOAT, true);
    }
    @Override
    public void addListeners() {

    }

    @Override
    public void removeListeners() {

    }

    @Override
    public void notifyListeners() {

    }
}

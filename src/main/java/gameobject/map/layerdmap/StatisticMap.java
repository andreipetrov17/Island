package gameobject.map.layerdmap;

import constants.Characteristic;

import java.util.HashMap;
import java.util.Map;

public class StatisticMap extends AbstractMap<StatisticField>{
    public Map<Characteristic, Boolean> state = new HashMap<>();
    public StatisticMap(GameMap gameMap) {
        super(StatisticField.class,  gameMap);
        for(Characteristic characteristic:Characteristic.values()){
            state.put(characteristic, false);
        }
        state.put(Characteristic.GOAT, true);
    }





}

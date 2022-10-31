package gameobject.map.layerdmap;

public class StatisticMap extends AbstractMap{
    public StatisticMap(GameMap gameMap) {
        super(StatisticField.class,  gameMap);
    }

    //@Override
    public void initialize() {
    }
    public StatisticField[][] get() {
        return (StatisticField[][])super.get();
    }
}

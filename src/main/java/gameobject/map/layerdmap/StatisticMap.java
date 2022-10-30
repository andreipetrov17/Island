package gameobject.map.layerdmap;

public class StatisticMap extends AbstractMap{
    public StatisticMap() {
        super(StatisticField.class);
    }

    //@Override
    public void initialize() {
    }
    public StatisticField[][] get() {
        return (StatisticField[][])super.get();
    }
}

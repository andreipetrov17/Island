package gameobject.map.layerdmap;

public abstract class AbstractField{
    private final int x;
    private final int y;
    protected AbstractField(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public CountryField getIn(CountryMap map){
        return map.get()[getX()][getY()];
    }
    public StatisticField getIn(StatisticMap map){
        return map.get()[getX()][getY()];
    }
    public OrganismField getIn(OrganismMap map){
        return map.get()[getX()][getY()];
    }
    public ViewField getIn(ViewMap map){
        return map.get()[getX()][getY()];
    }
    // TODO in generics do it
}

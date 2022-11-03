package gameobject.map.layerdmap;

public class GameMap {
    public final int width;
    public final int height;
    public final CountryMap country;
    public final OrganismMap organisms;
    public final ViewMap view;
    public final StatisticMap statistic;
    public GameMap(int width, int height){
        this.width = width;
        this.height = height;
        country = new CountryMap(this);
        organisms = new OrganismMap(this);
        view = new ViewMap(this);
        statistic = new StatisticMap(this);
    }


    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}

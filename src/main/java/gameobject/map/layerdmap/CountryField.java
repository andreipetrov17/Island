package gameobject.map.layerdmap;

import constants.MoveArray;
import entity.MoveOptions;

public class CountryField extends AbstractField{
    private Territory territory;

    public CountryField(int x, int y) {
        super(x, y);
        territory = Territory.EARTH;
    }
    public void setTerritory(Territory territory){
        this.territory = territory;
    }

    public Territory getTerritory() {
        return territory;
    }

}

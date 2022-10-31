package gameobject.map.layerdmap;

import constants.MoveArray;
import entity.MoveOptions;

public class CountryField extends AbstractField{
    private Territory territory;
    public MoveArray[] moveArrays = new MoveArray[4];
    public MoveOptions[] moveOptions = new MoveOptions[4];
    //TODO take length in Characteristic
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
    public void initMoveOptions(){

    }
}

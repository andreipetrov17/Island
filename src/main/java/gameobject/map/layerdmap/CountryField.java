package gameobject.map.layerdmap;

import constants.MoveArray;
import entity.MoveOptions;

public class CountryField extends AbstractField{
    private Territory territory;
    int[] environmentalСonditions;
    public MoveArray[] moveArrays = new MoveArray[4];
    public MoveOptions[] moveOptions = new MoveOptions[4];
    //TODO take length in Characteristic
    public CountryField() {
        territory = Territory.EARTH;
    }
    public void setTerritory(Territory territory){
        this.territory = territory;
    }

    public Territory getTerritory() {
        return territory;
    }
}

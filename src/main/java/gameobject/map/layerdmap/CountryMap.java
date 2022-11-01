package gameobject.map.layerdmap;

import constants.Characteristic;
import constants.MoveArray;
import entity.CanMove;
import entity.MoveOptions;

import java.util.ArrayList;
import java.util.Arrays;


public class CountryMap extends AbstractMap<CountryField> {

    private MoveArray[] moveArrays;


    public CountryMap(GameMap gameMap) {
        super(CountryField.class, gameMap);
    }
    protected void init(){
        setBorder();
        initMoveArr();
        unitMoveOptions();
    }
    private void initMoveArr() {
        int size;
        ArrayList<Integer> list = new ArrayList<>();
        for(Characteristic characteristic: Characteristic.values()){
            list.add((int)Characteristic.getBaseCharacteristic(characteristic.name())[2]); //max animal speed
        }
        size = list.stream().max(Integer::compare).get();
        moveArrays = new MoveArray[size];
        for (int i = 0; i < size; i++) {
            moveArrays[i] = new MoveArray(i+1);
        }
    }
    public void setBorder() {
        for (int x = 0; x < get().length; x++) {
            get()[x][0].setTerritory(Territory.WATER);
            get()[x][get()[0].length - 1].setTerritory(Territory.WATER);
        }
        for (int y = 1; y < get()[0].length-1 ; y++) {
            get()[0][y].setTerritory(Territory.WATER);
            get()[get().length - 1][y].setTerritory(Territory.WATER);
        }
    }
    private void unitMoveOptions() {
                Arrays.stream(getArr()).forEach(countryField -> {
                    for (int i = 0; i < moveArrays.length; i++) {
                        if(countryField.getTerritory()!=Territory.WATER) {
                            setNeighbors(moveArrays[i], countryField.getX(), countryField.getY());
                            System.out.println(moveArrays[i]);
                            countryField.moveOptions[i] = new MoveOptions(moveArrays[i]);
                            System.out.println(countryField.getX() + "|" + countryField.getY() + "\n" + countryField.moveOptions[i]);
                        }
                    }
                });
            }

    private void setNeighbors(MoveArray moveArray, int xMap, int yMap) {
        //
        boolean fieldIsExist;
        int deltaY = moveArray.demension;
        int deltaX;
        for (int y = 0; y < moveArray.value.length; y++) {
            if(moveArray.value[y].length == 1)deltaX = 0;
            else deltaX = (moveArray.value[y].length-1)/2;
            for (int x = 0; x < moveArray.value[y].length; x++) {
                fieldIsExist = xMap - deltaX + x >= 0 && xMap - deltaX + x<get().length
                        && yMap - deltaY + y >=0 && yMap - deltaY  + y<get()[0].length;
                if(fieldIsExist&& get()[xMap - deltaX + x][yMap - deltaY + y].getTerritory()==Territory.EARTH){
                    moveArray.value[y][x] = new CanMove(x-deltaX,-deltaY+y,true);
                }
            }
        }
    }
}

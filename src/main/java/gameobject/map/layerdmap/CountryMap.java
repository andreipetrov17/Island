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
        //initMoveArr();
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
            //System.out.println(moveArrays[i]);
        }
    }
    public void setBorder() {
        for (int x = 0; x < get().length; x++) {
            get()[x][0].setTerritory(Territory.WATER);
            get()[x][get()[0].length - 1].setTerritory(Territory.WATER);
            gameMap.organisms.get()[x][0] = null;
            gameMap.organisms.get()[x][get()[0].length - 1] = null;
        }
        for (int y = 1; y < get()[0].length-1 ; y++) {
            get()[0][y].setTerritory(Territory.WATER);
            get()[get().length - 1][y].setTerritory(Territory.WATER);
            gameMap.organisms.get()[0][y] = null;
            gameMap.organisms.get()[get().length - 1][y] = null;
        }
    }
    private void unitMoveOptions() {

                Arrays.stream(getArr()).forEach(countryField -> {
                    MoveArray moveArrayTemp;
                   // for (int i = 0; i < moveArrays.length; i++) {
                    int i =1;
                        if(countryField.getTerritory()!=Territory.WATER) {

                            moveArrayTemp = new MoveArray(2);
                            System.out.println(moveArrayTemp);
                            setNeighbors(moveArrayTemp, countryField.getX(), countryField.getY());
                            System.out.println(moveArrayTemp);
                           countryField.moveOptions[0] = new MoveOptions(moveArrayTemp);
                           // System.out.println("!!!!!!!!!!!!!!!!!!");
                            //System.out.println(countryField.getX() + "|" + countryField.getY() + "\n" + countryField.moveOptions[i]);
                        }
                    //}
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

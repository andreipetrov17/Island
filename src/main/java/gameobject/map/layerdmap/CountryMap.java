package gameobject.map.layerdmap;

import constants.Characteristic;
import constants.MoveArray;
import entity.CanMove;
import entity.MoveOptions;

import java.util.ArrayList;


public class CountryMap extends AbstractMap {
    private MoveOptions[] moveOptions;

    public CountryMap(GameMap gameMap) {
        super(CountryField.class, gameMap);
    }
    protected void init(){
        unitMoveOptions();
    }
    public CountryField[][] get(){
        return (CountryField[][]) super.get();
    }
    @Override
    public String toString() {
        return "";
    }
    private void unitMoveOptions(){
        int size;
        ArrayList<Integer> list = new ArrayList<>();
        for(Characteristic characteristic: Characteristic.values()){
            list.add((int)Characteristic.getBaseCharacteristic(characteristic.name())[2]);
            //max speed
        }
        size = list.stream().max(Integer::compare).get();
        moveOptions = new MoveOptions[size];
    }
    public void setBorder() {
        for (int x = 0; x < get().length; x++) {
            get()[x][0].setTerritory(Territory.WATER);
            get()[x][0].moveArrays = null;
            get()[x][get()[0].length - 1].setTerritory(Territory.WATER);
            get()[x][get()[0].length - 1].moveArrays = null;
        }
        for (int y = 1; y < get()[0].length - 1; y++) {
            get()[0][y].setTerritory(Territory.WATER);
            get()[0][y].moveArrays = null;
            get()[get().length - 1][y].setTerritory(Territory.WATER);
            get()[get().length - 1][y].moveArrays = null;
        }
    }
    public void setMoveArr() {
        for (int y = 1; y < get()[0].length-1; y++) {
            for (int x = 1; x < get().length-1; x++) {
                for (int i = 0; i < get()[x][y].moveArrays.length; i++) {
                    get()[x][y].moveArrays[i] = new MoveArray(i+1);
                    setNeighbors(get()[x][y].moveArrays[i], x, y);
                    get()[x][y].moveOptions[i] = new MoveOptions(get()[x][y].moveArrays[i]);
                }

            }
        }
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
/*
     boolean fieldIsExist;
        int delta = moveArray.demension;
        for (int x = 0; x < moveArray.value[delta].length; x++) {
            fieldIsExist = xMap - delta + x >= 0 && xMap - delta + x < get().length;
            if(fieldIsExist&&((CountryField)get()[xMap - delta + x][yMap]).getTerritory()==Territory.EARTH){
                ((CountryField)get()[xMap][yMap]).moveArray.value[delta][x] = new CanMove(x-delta,0,true);
            }
        }
        int deltaX;
        for (int y = 0; y < delta ; y++) {
            if(moveArray.value[y].length == 1)deltaX = 0;
            else deltaX = (moveArray.value[y].length-1)/2;
            for (int x = 0; x < moveArray.value[y].length; x++) {
                fieldIsExist = xMap - deltaX + x >= 0 && xMap - deltaX + x < get().length
                        && yMap - delta + y >=0 && yMap - delta  + y < get()[0].length;
                if(fieldIsExist&&((CountryField)get()[xMap - deltaX + x][yMap - delta + y]).getTerritory()==Territory.EARTH){
                    ((CountryField)get()[xMap][yMap]).moveArray.value[y][x] = new CanMove(x-deltaX,-delta+y,true);
                }
            }
        }

        for (int y = delta + 1; y < moveArray.value.length; y++) {
            if(moveArray.value[y].length == 1)deltaX = 0;
            else deltaX = (moveArray.value[y].length-1)/2;
            for (int x = 0; x < moveArray.value[y].length; x++) {
                fieldIsExist = xMap - deltaX + x >= 0 && xMap - deltaX + x<get().length
                        && yMap - delta + y >=0 && yMap - delta  + y<get()[0].length;
                if(fieldIsExist&&((CountryField)get()[xMap - deltaX + x][yMap - delta + y]).getTerritory()==Territory.EARTH){
                    ((CountryField)get()[xMap][yMap]).moveArray.value[y][x] = new CanMove(x-deltaX,-delta+y,true);
                }
            }
        }



*/


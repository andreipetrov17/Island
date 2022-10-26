package temptools;

import constants.MoveArray;
import entity.CanMove;

public class ArraysPrinters {
    public static String getMove(MoveArray moveArrays){
        StringBuilder str = new StringBuilder("");
        for(CanMove[] canMove: moveArrays.value){
            for (CanMove canMove1: canMove){
                str.append(canMove1.x + ":"+ canMove1.y);
            }
        }
        return str.toString();
    }
}

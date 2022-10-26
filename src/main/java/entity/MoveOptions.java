package entity;

import constants.MoveArray;

import java.util.ArrayList;

public class MoveOptions {
    public ArrayList<Integer[]> list = new ArrayList<>();

    public MoveOptions(MoveArray moveArray){
        for(CanMove[] canMoves : moveArray.value){
            for(CanMove canMove : canMoves){
                if(canMove!=null){
                    list.add(new Integer[]{canMove.x,canMove.y});
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("");
        for (Integer[] integers : list) {
            str.append("(" + integers[0] + ":" + integers[1] + ")");

        }
        return str.toString();
    }
}

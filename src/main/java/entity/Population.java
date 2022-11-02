package entity;

import gameobject.animal.AbstractAnimal;
import gameobject.map.layerdmap.*;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Population implements Runnable{
    private final GameMap gameMap;
    public ReentrantLock locker = new ReentrantLock();
    public ArrayList<Population>  commonMoveRes = new ArrayList<>();
    //only for init atomicCommonRes TODO remove
    public CommonRes atomicCommonRes;
    //Its can to lock all field atomari
    public List<AbstractAnimal> willMove = new ArrayList<>();
    public List<AbstractAnimal> wasMoved = new ArrayList<>();
    public int capacity = 30;
    public Population(GameMap gameMap){
        this.gameMap = gameMap;
    }
    public void setNeighbors(MoveOptions moveOptions,int  x, int y) {
        for (int j = 0; j < moveOptions.list.size(); j++) {
         commonMoveRes.add(gameMap.organisms.get()[x + moveOptions.list.get(j)[0]][y + moveOptions.list.get(j)[1]].population[0]);
        }
    }
    @Override
    public void run() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i <atomicCommonRes.value.length();i++){
            list.add(i);
        }
        //Collections.shuffle(list);
        for (int j = 0; j < atomicCommonRes.value.length(); j++) {
            atomicCommonRes.value.get(j).locker.lock();
        }
        try {

            while (!willMove.isEmpty()) {
                if (atomicCommonRes.value.get(list.get(0)).willMove.size() +
                        atomicCommonRes.value.get(list.get(0)).wasMoved.size() == capacity &&
                        !this.equals((atomicCommonRes.value.get(list.get(0))))) {
                        list.remove(0);
                }
                else {
                    atomicCommonRes.value.get(list.get(0)).wasMoved.add(willMove.get(0));
                    willMove.remove(0);
                }
            }
        }
                finally
            {
            for (int j = 0; j < commonMoveRes.size(); j++) {
                atomicCommonRes.value.get(j).locker.unlock();
            }
            }

    }

    public String totoString() {
        StringBuilder stringBuilder = new StringBuilder("<HTML>Name"+ this +"<BR>" + "Neighbors:<BR>");
        stringBuilder.append(commonMoveRes.size());
        Population population;
        String str;
        for (int i = 0; i < commonMoveRes.size(); i++) {
            stringBuilder.append(commonMoveRes.get(i).toString() + "<BR>");
        }

        return stringBuilder.append("</HTML>").toString();
    }
}


package entity;

import constants.Characteristic;
import gameobject.animal.AbstractAnimal;
import gameobject.map.layerdmap.*;

import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class Population implements Runnable {
    private final GameMap gameMap;
    public ReentrantLock locker = new ReentrantLock();
    public ArrayList<Population> commonMoveRes = new ArrayList<>();
    //only for init atomicCommonRes meTODO remove
    public CommonRes atomicCommonRes;
    public List<AbstractAnimal> willMove = new ArrayList<>();
    public List<AbstractAnimal> wasMoved = new ArrayList<>();
    public int capacity;

    public Population(GameMap gameMap, int ordinal) {
        this.gameMap = gameMap;
        String name = String.valueOf(Characteristic.values()[ordinal]);
        capacity = (int)Characteristic.getBaseCharacteristic(name)[1];

    }

    public void setNeighbors(MoveOptions moveOptions, int x, int y, int ordinal) {
        for (int j = 0; j < moveOptions.list.size(); j++) {
            commonMoveRes.add(gameMap.organisms
                    .get()[x + moveOptions.list.get(j)[0]]
                    [y + moveOptions.list.get(j)[1]].population[ordinal]);
        }
    }

    @Override
    public void run() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < atomicCommonRes.value.length(); i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        for (int j = 0; j < atomicCommonRes.value.length(); j++) {
            atomicCommonRes.value.get(j).locker.lock();
        }
        try {
            while (!willMove.isEmpty()) {
                if (atomicCommonRes.value.get(list.get(0)).willMove.size() +
                        atomicCommonRes.value.get(list.get(0)).wasMoved.size() == capacity &&
                        !this.equals((atomicCommonRes.value.get(list.get(0))))) {
                    list.remove(0);
                } else {
                    atomicCommonRes.value.get(list.get(0)).wasMoved.add(willMove.get(0));
                    willMove.remove(0);
                }
            }
        } finally {
            for (int j = 0; j < commonMoveRes.size(); j++) {
                atomicCommonRes.value.get(j).locker.unlock();
            }
        }

    }
}




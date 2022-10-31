package garbage;

import constants.Characteristic;
import constants.CloneList;
import gameobject.animal.AbstractAnimal;
import gameobject.animal.Duck;
import gameobject.animal.Wolf;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

public class JaggerArray {
    /*
    public ArrayBlockingQueue<AbstractAnimal>[] value;
    public JaggerArray() {
        int height = Characteristic.values().length;
        int width;
        value = new ArrayBlockingQueue[height];
        for (int y = 0; y < height; y++) {
            width = (int) Characteristic.values()[y].baseCharacteristic[1];
            value[y] = new ArrayBlockingQueue<>(2);
            value[y].add(new Wolf());
            value[y].add(new Duck());
        }
      // createRandomAnimal(new CloneList());
    }
    public void createRandomAnimal(CloneList clones){
        int randomNum;
        AbstractAnimal clone;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int y = 0; y < value.length; y++) {
            randomNum = random.nextInt(0,value[y].size());
            for (int x = 0; x < randomNum; x++) {
                try {
                    clone = (AbstractAnimal)clones.arr[y].clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    value[y].put(new Wolf());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder("<HTML>");
        for(ArrayBlockingQueue<AbstractAnimal> animal: value){
            str.append(animal.size()  + "<BR>");
        }
        return str.toString() + "</HTML>";
    }
    */
}

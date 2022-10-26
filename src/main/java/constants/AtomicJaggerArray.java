package constants;

import gameobject.animal.AbstractAnimal;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class AtomicJaggerArray  {
   public AtomicReferenceArray[][] value = new AtomicReferenceArray[2][];;
   public AtomicJaggerArray(){
        value[0] = new AtomicReferenceArray[Characteristic.values().length];
        value[1] = new AtomicReferenceArray[Characteristic.values().length];
       for (int j = 0; j < Characteristic.values().length; j++) {
           value[0][j] = new AtomicReferenceArray<AbstractAnimal>((int)Characteristic.values()[j].baseCharacteristic[1]);
           value[1][j] = new AtomicReferenceArray<AbstractAnimal>((int)Characteristic.values()[j].baseCharacteristic[1]);
       }


   }
   public synchronized void sortNullLeft(){

   }
   //public synchronized void sortNullRight(){
   //     value[i].
   //}
    @Override
    public String toString() {

        StringBuilder str = new StringBuilder("<HTML>");
        for (int i = 0; i < value[0].length; i++) {



            str.append( value[0][i].length() + "  " + value[1][i].length()  + "<BR>");
        }
        return str.toString() + "</HTML>";
    }
}

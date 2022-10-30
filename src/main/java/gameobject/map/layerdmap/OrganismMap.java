package gameobject.map.layerdmap;

import constants.CloneList;
import entity.CommonRes;
import gameobject.animal.AbstractAnimal;

import java.util.concurrent.ThreadLocalRandom;

public class OrganismMap extends AbstractMap {
    private final CloneList clones = new CloneList();

    public OrganismMap() {
        super(OrganismField.class);
        setBorder();
    }
    public OrganismField[][] get(){
        return (OrganismField[][])super.get();
    }
    public void unitPopulation(){
        CountryMap countryMap = Game.getInstance().countryMap;
        OrganismMap organismMap = Game.getInstance().organismMap;
        for (int y = 1; y < countryMap.get()[0].length-1; y++) {
            for (int x = 1; x < countryMap.get().length-1; x++) {
                get()[x][y].population[0].
                        setNeighbors(((CountryField)countryMap.get()[x][y])
                                .moveOptions[0], x, y);
                        createRandomAnimal(organismMap.get()[x][y], new CloneList());
            }
        }
    }
    public void createRandomAnimal(OrganismField organismField, CloneList clones){
        int randomNum;
        AbstractAnimal clone;
        ThreadLocalRandom random = ThreadLocalRandom.current();
                randomNum = random.nextInt(10,30);
                for (int i = 0; i < randomNum; i++) {
                    try {
                        clone = (AbstractAnimal)clones.arr[3].clone();
                        organismField.population[0].willMove.add(clone);
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
    public void setBorder(){
        for (int x = 0; x < get().length; x++) {
            get()[x][0].population = null;
           get()[x][get()[0].length - 1].population = null;

      }
      for (int y = 1; y < get()[0].length - 1; y++) {
          get()[0][y].population = null;
           get()[get().length - 1][y].population = null;
       }
   }
    public void unitCommonRes() {
        OrganismMap organismMap = Game.getInstance().organismMap;
        for (int y = 1; y < organismMap.get()[0].length-1; y++) {
            for (int x = 1; x < organismMap.get().length-1; x++) {
                get()[x][y].population[0].atomicCommonRes = new CommonRes((get()[x][y].population[0]).commonMoveRes);

            }
        }
    }
}
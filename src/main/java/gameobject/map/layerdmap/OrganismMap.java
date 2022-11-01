package gameobject.map.layerdmap;

import constants.CloneList;
import entity.CommonRes;
import entity.Population;
import gameobject.animal.AbstractAnimal;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class OrganismMap extends AbstractMap<OrganismField> {
    private final CloneList clones = new CloneList();

    public OrganismMap(GameMap gameMap) {
        super(OrganismField.class, gameMap);
    }

    protected void unit(){
        unitPopulation();
    }
    public void unitPopulation(){
        Arrays.stream(gameMap.country.getArr()).
                filter(countryField -> countryField.getTerritory()!= Territory.WATER)
                .forEach(countryField -> {
            int x = countryField.getX();
            int y = countryField.getY();
            get()[x][y].population[0] = new Population(gameMap);
            get()[x][y].population[0].setNeighbors(countryField.moveOptions[0], x, y);
        });
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
    public void unitCommonRes() {
        OrganismMap organismMap = gameMap.organisms;
        for (int y = 1; y < organismMap.get()[0].length-1; y++) {
            for (int x = 1; x < organismMap.get().length-1; x++) {
                get()[x][y].population[0].atomicCommonRes = new CommonRes((get()[x][y].population[0]).commonMoveRes);

            }
        }
    }


}
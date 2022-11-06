package gameobject.map.layerdmap;

import constants.Characteristic;
import entity.CommonRes;
import entity.Population;

import java.util.ArrayList;
import java.util.Arrays;

public class OrganismMap extends AbstractMap<OrganismField> {
    public ArrayList<OrganismField> habitPlace = new ArrayList<>();
    //private final CloneList clones = new CloneList();

    public OrganismMap(GameMap gameMap) {
        super(OrganismField.class, gameMap);
    }

    protected void unit(){
        unitPopulation();
        unitCommonRes();
    }
    public void unitPopulation(){
        Arrays.stream(ply.organisms.getArr()).forEach(e -> {
            e.population = new Population[Characteristic.values().length];
            for (int i = 0; i < e.population.length; i++) {
                e.population[i] = new Population(ply, i);
            }
        });
        Arrays.stream(ply.country.getArr()).
                filter(e -> !e.getTerritory().equals(Territory.WATER))
                .forEach(e -> {
            int x = e.getX();
            int y = e.getY();
            int maxSpeed;
                    for (int i = 0; i < get()[x][y].population.length; i++) {
                        maxSpeed = (int)Characteristic.getBaseCharacteristic(Characteristic.values()[i].name())[2];
                        get()[x][y].population[i].setNeighbors(e.moveOptions[maxSpeed], x, y,i);
                    }
            habitPlace.add(e.getIn(ply.organisms));
        });
        System.out.println(habitPlace.toString());
    }


//    public void createRandomAnimal(OrganismField organismField, CloneList clones){
//        int randomNum;
//        AbstractAnimal clone;
//        ThreadLocalRandom random = ThreadLocalRandom.current();
//                randomNum = random.nextInt(10,30);
//                for (int i = 0; i < randomNum; i++) {
//                    try {
//                        clone = (AbstractAnimal)clones.arr[3].clone();
//                        organismField.population[0].willMove.add(clone);
//                    } catch (CloneNotSupportedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
    public void unitCommonRes() {
        OrganismMap organismMap = ply.organisms;
        for (int y = 1; y < organismMap.get()[0].length-1; y++) {
            for (int x = 1; x < organismMap.get().length-1; x++) {
                get()[x][y].population[0].atomicCommonRes = new CommonRes((get()[x][y].population[0]).commonMoveRes);

            }
        }
    }


}
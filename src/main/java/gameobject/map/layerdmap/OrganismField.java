package gameobject.map.layerdmap;

import entity.Population;

public class OrganismField extends AbstractField implements Runnable{
    public Population[] population = new Population[1];
    public OrganismField(int x, int y) {
        super(x, y);
    }

    @Override
    public void run() {
        for (int i = 0; i < population[0].wasMoved.size(); i++) {
//            if(!population[0].willMove.isEmpty())throw new ArithmeticException("Some animal was not move or not stand");
            population[0].willMove.add(population[0].wasMoved.get(i));
        }
        population[0].wasMoved.clear();
        System.out.println(population[0].willMove + "****" + population[0].wasMoved);
    }
    /*
    public void createRandomAnimal(CloneList clones){
        int randomNum;
        AbstractAnimal clone;
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int y = 0; y < jaggerArr.value.length; y++) {
            randomNum = random.nextInt(0,jaggerArr.value[y].size());
            for (int x = 0; x < randomNum; x++) {
                try {
                    clone = (AbstractAnimal)clones.arr[y].clone();
                } catch (CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
                try {
                    jaggerArr.value[y].put(clone);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    public void initialize(){
        createRandomAnimal(new CloneList());

    }
    */

}

package constants;

public enum Characteristic {
    WOLF       (new double[]{50, 30, 3, 8 }),
    BOA        (new double[]{15, 30, 1, 3}),
    FOX        (new double[]{8, 30, 2, 2}),
    BEAR       (new double[]{500, 5, 2, 80}),
    EAGLE      (new double[]{6, 20, 3, 1}),
    HORSE      (new double[]{400, 20, 4, 60}),
    DEER       (new double[]{300, 20, 4, 50}),
    RABBIT     (new double[]{2, 150, 2, 0.45}),
    MOUSE      (new double[]{0.05, 500, 1, 0.01}),
    GOAT       (new double[]{60, 140, 3, 10}),
    SHEEP      (new double[]{70, 140, 3, 15}),
    COBAN      (new double[]{400, 50, 2, 50}),
    BUFFALO    (new double[]{700, 10, 3, 100}),
    DUCK       (new double[]{1, 200, 4, 0.15}),
    CATERPILLAR(new double[]{0.01, 1000, 0, 0}),
    PLANTS     (new double[]{1, 200, 0, 0});
    final double[] baseCharacteristic = new double[4];
    //final AbstractAnimal animal;
    Characteristic(double[] characteristic){
        this.baseCharacteristic[0] = characteristic[0];
        this.baseCharacteristic[1] = characteristic[1];
        this.baseCharacteristic[2] = characteristic[2];
        this.baseCharacteristic[3] = characteristic[3];
        //this.animal = animal;
    }
    public static double[] getBaseCharacteristic(String animal){
        return valueOf(animal).baseCharacteristic;
    }

}

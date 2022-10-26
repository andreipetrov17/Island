package gameobject.animal;

import constants.Characteristic;

public abstract class AbstractAnimal implements Cloneable{
    private final double weight;
    private final double maxAmountOnField;
    private final double maxSpeed;
    private final double foodAmountToSatiety;
    protected int x;
    protected int y;
    protected  AbstractAnimal(){
        String name = getClass().getName();
        String newName = name.replace("gameobject.animal.", "").toUpperCase();
        //TODO remove magic String
        double[] characteristic = Characteristic.getBaseCharacteristic(newName);
        this.weight = characteristic[0];
        this.maxAmountOnField = characteristic[1];
        this.maxSpeed = characteristic[2];
        this.foodAmountToSatiety = characteristic[3];
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getWeight() {
        return weight;
    }

    public double getMaxAmountOnField() {
        return maxAmountOnField;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public double getFoodAmountToSatiety() {
        return foodAmountToSatiety;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

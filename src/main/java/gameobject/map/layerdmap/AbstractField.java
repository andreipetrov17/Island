package gameobject.map.layerdmap;

public abstract class AbstractField{
    private final int x;
    private final int y;
    protected AbstractField(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

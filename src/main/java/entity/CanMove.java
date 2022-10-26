package entity;

public class CanMove {
    boolean canMove;
    public int x;
    public int y;
    public CanMove(int x, int y, boolean canMove){
        this.x = x;
        this.y = y;
        this.canMove = canMove;
    }
    @Override
    public String toString() {
        return x + ":" + y;
    }
}

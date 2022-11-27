package commands.game;

public class StopAction implements Observer{
    private final boolean stopCycle;
    private final boolean stopNext;
    public StopAction(boolean stopCycle, boolean stopNext){
        this.stopCycle = stopCycle;
        this.stopNext = stopNext;
    }

    public boolean isStopCycle() {
        return stopCycle;
    }

    public boolean isStopNext() {
        return stopNext;
    }
    @Override
    public String toString(){
        return "stopCycle = " + stopCycle + ", stopNext = " + stopNext;
    }

    @Override
    public void update() {

    }
}

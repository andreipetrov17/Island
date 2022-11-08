package commands.game;

public abstract class AbstractGameAction implements GameAction{
    private final boolean stopCycle;
    private final boolean stopNext;
    public AbstractGameAction(boolean stopCycle, boolean stopNext){
        this.stopCycle = stopCycle;
        this.stopNext = stopNext;
    }

    public boolean isStopCycle() {
        return stopCycle;
    }

    public boolean isStopNext() {
        return stopNext;
    }
}

package commands.game;

import java.util.ArrayList;
import java.util.List;

public class StopperListener implements Observable{
    private List<Observer> listeners;
    public StopperListener(){
        listeners = new ArrayList<>();
    }
    @Override
    public void registerObserver(Observer o) {
        listeners.add(o);
    }
    @Override
    public void removeObserver(Observer o) {
        listeners.remove(o);
    }
    @Override
    public void notifyObservers() {
        for (Observer o : listeners)
            o.update();
    }
}

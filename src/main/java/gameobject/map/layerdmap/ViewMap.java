package gameobject.map.layerdmap;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.stream.Stream;

public class ViewMap extends AbstractMap<ViewField> {
    public ViewMap(GameMap gameMap) {
        super(ViewField.class, gameMap);
    }
    public void init() {
        setOriginColor();
    }
    public void blackLightLabel(Color color, Stream<JLabel> stream, int sleep) throws InterruptedException {
        stream.forEach(e -> e.setBackground(color));
        Thread.sleep(sleep);
        setOriginColor();


    }

    private void setOriginColor() {
        Arrays.stream(getArr()).forEach(e->{
            if(e.getIn(ply.country).getTerritory()==Territory.WATER){
                e.label.setBackground(Color.BLUE);
            }
            else e.label.setBackground(Color.GRAY);
        });
    }

    public void revalidateAll() {
        Arrays.stream(getArr()).forEach(e -> e.label.revalidate());
    }
}

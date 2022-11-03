package gameobject.map.layerdmap;

import java.util.Arrays;

public class ViewMap extends AbstractMap<ViewField>{
    public ViewMap(GameMap gameMap) {
        super(ViewField.class, gameMap);
    }
    public void init() {
    }

    public void revalidateAll() {
        Arrays.stream(getArr()).forEach(e -> e.label.revalidate());
    }
}

package gameobject.map.layerdmap;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public abstract class AbstractMap<E extends AbstractField> {

    private final E[][] value;
    private final E[] arr;

    protected GameMap ply;

    public AbstractMap(Class<E> clazz, GameMap gameMap) {
        this.ply = gameMap;
        @SuppressWarnings("unchecked")
        E[][] value = (E[][]) Array.newInstance(clazz, gameMap.getWidth(), gameMap.getHeight());
        @SuppressWarnings("unchecked")
        E[] arr = (E[]) Array.newInstance(clazz, gameMap.width * gameMap.height);
        this.value = value;
        this.arr = arr;
        Constructor<E> constructor;
        Class<?>[] types = new Class[2];
        types[0] = int.class;
        types[1] = int.class;
        try {
            constructor = clazz.getConstructor(types);
            for (int y = 0; y < value[0].length; y++) {
                for (int x = 0; x < value.length; x++) {
                    value[x][y] = constructor.newInstance(x, y);
                    arr[x + y * value.length] = value[x][y];
                }
            }
        } catch (NoSuchMethodException | InstantiationException | InvocationTargetException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    public E[][] get() {
        return value;
    }

    public E[]getArr(){
        return arr;
    }

}




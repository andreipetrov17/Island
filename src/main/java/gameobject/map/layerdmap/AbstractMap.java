package gameobject.map.layerdmap;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class AbstractMap<E extends AbstractField> {

        private final E[][] a;
        protected GameMap gameMap;
        public  AbstractMap(Class<E> clazz, GameMap gameMap) {
            this.gameMap = gameMap;
            E[][] a = (E[][]) Array.newInstance(clazz, gameMap.getWidth(), gameMap.getHeight());
            this.a = a;
            Constructor constructor;
            Class[] types = new Class[2];
            types[0] = int.class;
            types[1] = int.class;
            try {
                constructor = clazz.getConstructor(types);
                for (int y = 0; y < a[0].length; y++) {
                    for (int x = 0; x < a.length; x++) {
                        a[x][y] = (E)constructor.newInstance(x, y);
                    }
                }
            } catch (NoSuchMethodException | InstantiationException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }

        public <E> E[][] get() {
            return (E[][])a;
        }



}

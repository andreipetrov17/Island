package gameobject.map.layerdmap;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class AbstractMap<E extends AbstractField> {

        private final E[][] value;
        private final E[] arr;
        protected GameMap gameMap;
        public  AbstractMap(Class<E> clazz, GameMap gameMap) {
            this.gameMap = gameMap;
            E[][] value = (E[][]) Array.newInstance(clazz, gameMap.getWidth(), gameMap.getHeight());
            E[] arr = (E[])Array.newInstance(clazz,gameMap.width*gameMap.height);
            this.value = value;
            this.arr = arr;
            Constructor constructor;
            Class[] types = new Class[2];
            types[0] = int.class;
            types[1] = int.class;
            try {
                constructor = clazz.getConstructor(types);
                for (int y = 0; y < value[0].length; y++) {
                    for (int x = 0; x < value.length; x++) {
                        value[x][y] = (E)constructor.newInstance(x, y);
                        arr[x + y*value.length] = value[x][y];
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
            return (E[][])value;
        }
        }




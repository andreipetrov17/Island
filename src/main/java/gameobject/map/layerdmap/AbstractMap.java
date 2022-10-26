package gameobject.map.layerdmap;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public abstract class AbstractMap<E> {

        private E[][] a;

        public  AbstractMap(Class<E> clazz) {
            E[][] a = (E[][]) Array.newInstance(clazz, Game.x, Game.y);
            this.a = a;
            Constructor constructor;
            try {
                constructor = clazz.getConstructor();
                for (int y = 0; y < a[0].length; y++) {
                    for (int x = 0; x < a.length; x++) {
                        a[x][y] = (E)constructor.newInstance();
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

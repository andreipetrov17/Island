package gameobject.map.layerdmap;

public abstract class AbstractField{
    public static int i = 0;
    public int id;
    public AbstractField(){
        id = i;
        i++;
    }


}

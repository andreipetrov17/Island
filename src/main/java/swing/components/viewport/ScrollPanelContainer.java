package swing.components.viewport;

public enum ScrollPanelContainer {
    NORTH(0, -1),
    EAST(1,0),
    SOUTH(0, 1),
    WEST(-1, 0);
    int moveX;
    int moveY;
    ScrollPanelContainer(int moveX, int moveY){
        this.moveX = moveX;
        this.moveY = moveY;
    }
    public String getConstToLayout(){
        String str = name().toLowerCase();
        String firstLatter = String.valueOf(str.charAt(0));
        return str.replaceFirst(firstLatter, firstLatter.toUpperCase());
    }

}

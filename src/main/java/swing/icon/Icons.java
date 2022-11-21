package swing.icon;

public enum Icons {
    RUN("src/main/resources/play.png"),
    STOP("src/main/resources/pause.png"),
    NEXT_STEP("src/main/resources/angle-double-right.png"),
    NEXT_CYCLE("src/main/resources/angle-right.png");
    public String resources;
    Icons(String resources){
        this.resources = resources;
    }
    public static String getResources(String name){
        return valueOf(name).resources;
    }
}

package garbage;

import java.awt.*;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

public class AddFont {
    private static Font ttfBase = null;
    private static Font telegraficoFont = null;
    private static InputStream myStream = null;
    private static final String FONT_PATH_TELEGRAFICO = "src/main/resources/EmogiFont.ttf";

    public static Font createFont() {


        try {
            myStream = new BufferedInputStream(
                    new FileInputStream(FONT_PATH_TELEGRAFICO));
            ttfBase = Font.createFont(Font.TRUETYPE_FONT, myStream);
            telegraficoFont = ttfBase.deriveFont(Font.PLAIN, 24);
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("Font not loaded.");
        }
        return telegraficoFont;
    }
}

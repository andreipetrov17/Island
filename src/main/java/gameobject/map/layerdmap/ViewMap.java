package gameobject.map.layerdmap;

import garbage.AddFont;

import java.awt.*;

public class ViewMap extends AbstractMap implements Runnable{
    public ViewMap(GameMap gameMap) {
        super(ViewField.class, gameMap);
    }
    public Font font;
    //@Override
    public void init() {
        for (int y = 0; y < get()[0].length; y++) {
            for (int x = 0; x < get().length; x++) {
                String str;
                if (gameMap.country.get()[x][y].getTerritory() != Territory.WATER) {

                    str = String.valueOf(gameMap.organisms.get()[x][y].population[0].willMove.size());

                    get()[x][y].label.setBackground(Color.GRAY);
                    get()[x][y].label.setText((str));
                } else get()[x][y].label.setText(("WATER"));
                get()[x][y].label.setBackground(Color.BLUE);
            }
        }
    }
    public void repaintLabel(){
        for (int y = 1; y < get()[0].length-1; y++) {
            for (int x = 1; x < get().length-1; x++) {
                String str;
                    str = String.valueOf(gameMap.organisms.get()[x][y].population[0].wasMoved.size());
                    //str += ((OrganismField) Game.getInstance().organismMap.get()[x][y]).population[0];
                    get()[x][y].label.setText((str));
            }
        }
    }
    public ViewField[][] get(){
        return (ViewField[][]) super.get();
    }
    public ViewField[] getArr(){
        return (ViewField[]) super.getArr();
    }
    public void setFont(){
        try {
            if (this.font == null) {
                this.font = AddFont.createFont();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        for (int y = 0; y < get()[0].length; y++) {
            for (int x = 0; x < get().length; x++) {
                get()[x][y].label.setBackground(Color.BLACK);
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                get()[x][y].label.revalidate();
                System.out.println("!!!");
            }

        }
    }
}
 /*  //System.out.println(str);
                setFont();
                ((ViewField)get()[x][y]).label.setFont(new Font("Noto Color Emoji", Font.PLAIN, 20));
                EmojiParser.UnicodeCandidate unicodeCandidate;
                String str1 = "🐢";
                EmojiParser emojiParser = new EmojiParser();
                System.out.println(str1);
                String str2 = emojiParser.parseToHtmlDecimal(str1);
                System.out.println(str2);
                Font[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAllFonts();
                for (Font font: fonts) {
                    if (font.canDisplay('\u23F0')) {
                        System.out.println(font);
                    }
                }
                */
package gameobject.map.layerdmap;

import garbage.AddFont;

import java.awt.*;

public class ViewMap extends AbstractMap{
    public ViewMap() {
        super(ViewField.class);
    }
    public Font font;
    //@Override
    public void initialize(OrganismMap organismMap, CountryMap countryMap) {
        for (int y = 0; y < get()[0].length; y++) {
            for (int x = 0; x < get().length; x++) {
                String str = "!!!";
                if (((CountryField) countryMap.get()[x][y]).getTerritory() != Territory.WATER) {

                    str = String.valueOf(((OrganismField) Game.getInstance().organismMap.get()[x][y]).population[0].willMove.size());

                    ((ViewField) get()[x][y]).label.setBackground(Color.GRAY);
                    ((ViewField) get()[x][y]).label.setText((str));
                } else ((ViewField) get()[x][y]).label.setText(("WATER"));
                ((ViewField) get()[x][y]).label.setBackground(Color.BLUE);
            }
        }
    }
    public void repaintLabel(){
        for (int y = 1; y < get()[0].length-1; y++) {
            for (int x = 1; x < get().length-1; x++) {
                String str = "!!!";
                    str = String.valueOf(((OrganismField) Game.getInstance().organismMap.get()[x][y]).population[0].wasMoved.size());
                    //str += ((OrganismField) Game.getInstance().organismMap.get()[x][y]).population[0];
                    ((ViewField) get()[x][y]).label.setText((str));
            }
        }
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
package commands.main;

import gameobject.map.layerdmap.Game;
import gameobject.map.layerdmap.OrganismField;
import swing.components.viewport.FieldPanel;
import swing.components.viewport.ViewportPanel;

public class NewGameLoader extends AbstractLoader implements Action {
    public NewGameLoader(){

    }

    @Override
    public void execute() {
        changeView(new ViewportPanel(new FieldPanel()));
       Thread thread = new Thread(Game.getInstance());
        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        thread.start();
    }
}
/*
String text = "&#x1f621;";
        String res = EmojiParser.parseToUnicode(text);
        String res1 = EmojiParser.parseToHtmlDecimal(text);
        JLabel label = new JLabel("<html>" + text + "</html>");
        JLabel label1 = new JLabel(res1);
        //String res = EmojiParser.parseToUnicode(String.valueOf(Character.toChars(Integer.parseInt("0x1F349"))));
        //String res = new String(Character.toChars("\\xF0\\x9F\\x98\\x81"));
        JEditorPane jEditorPane =new JEditorPane(new HTMLEditorKit().getContentType(), res1);
        Font font = new Font("Segoe UI Emoji", Font.PLAIN, 24);
        String bodyRule = "body { font-family: " + font.getFamily() + "; " + "font-size: " + font.getSize() + "pt; }";
        ((HTMLDocument)jEditorPane.getDocument()).getStyleSheet().addRule(bodyRule);
        System.out.println(EmojiParser.parseToHtmlDecimal(text));
        jPanel.add(jEditorPane);
        jPanel.add(label);
        jPanel.add(label1);
 */
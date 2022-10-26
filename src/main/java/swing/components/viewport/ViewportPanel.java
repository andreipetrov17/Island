package swing.components.viewport;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class ViewportPanel extends JPanel {
    private FieldPanel fieldPanel;
    private final JViewport viewport = new JViewport();
    private JPanel[] panels;
    private Thread scrollThread;
    public ViewportPanel(FieldPanel fieldPanel){
        this.fieldPanel = fieldPanel;
        setLayout(new BorderLayout());
        viewport.setView(fieldPanel);
        viewport.setScrollMode(JViewport.SIMPLE_SCROLL_MODE);
        viewport.setLayout(new ViewportLayout());
        add(viewport,BorderLayout.CENTER);
        setScrolls();
    }
    private void setScrolls(){
        ScrollPanelContainer[] scrollPanelContainer = ScrollPanelContainer.values();
        panels = new JPanel[scrollPanelContainer.length];
        for(ScrollPanelContainer scrollPanel : scrollPanelContainer){
            int num = scrollPanel.ordinal();
            JPanel panel = new JPanel();
            panel.setBackground(Color.BLACK);
            add(panel, scrollPanel.getConstToLayout());
            panels[num] = panel;
            panel.addMouseListener(new ScrollListener(scrollPanel.moveX, scrollPanel.moveY, 100));
        }
    }
    private Point countStepPoint(){
        Point point = new Point();

        return point;
    }
    private class ScrollListener extends MouseAdapter implements Runnable{
        int moveX;
        int moveY;
        int sleep;
        ScrollListener(int x, int y, int sleep){
            moveX = x;
            moveY = y;
            this.sleep = sleep;
        }
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            System.out.println("mouse inside");
            scrollThread = new Thread(this);
            scrollThread.start();
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            System.out.println("mouse outside");
            scrollThread.interrupt();
        }
        @Override
        public void run() {
            while(!scrollThread.isInterrupted()) {
                Point nextPoint = countStepPoint();
                Point currentPoint = viewport.getViewPosition();
                currentPoint.x += moveX * sleep;
                currentPoint.y += moveY * sleep;
                if (currentPoint.x < 0) currentPoint.x = 0;
                if (currentPoint.y < 0) currentPoint.y = 0;
                viewport.setViewPosition(currentPoint);
                try {
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}

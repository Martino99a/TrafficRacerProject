package it.unimol.traffic_racer.gui.panels;

import it.unimol.traffic_racer.gui.frames.MainFrame;
import it.unimol.traffic_racer.gui.utils.Images;
import it.unimol.traffic_racer.gui.utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.image.BufferedImage;

public class RecordPanel extends JPanel {

    public static final RecordPanel instance = new RecordPanel();

    private BufferedImage backgroundRecord;
    private static final int WIDTH_PANEL = 800;
    private static final int HEIGHT_PANEL = 600;
    private int record;

    private ClickArea back;

    private RecordPanel() {
        initPanel();
        initListener();
    }

    public static RecordPanel getInstance() {
        return instance;
    }

    private void initPanel() {
        this.setSize(WIDTH_PANEL, HEIGHT_PANEL);
        this.backgroundRecord = Images.loadImage("record.png");
        this.back = new ClickArea(310, 456, 184, 47);
        this.record = 0;
    }

    public void updateRecord(){
        if(GamePanel.getInstance().getPoints() > this.record){
            this.record = GamePanel.getInstance().getPoints();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundRecord,0,0,null);
      //g.drawRect(310, 456, 184, 47);
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 40));
        g.drawString(Integer.toString(this.record),455, 313);
    }

    private void initListener(){
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e);
                if (back.isClicked(e)) {
                    MainFrame.menuPanel.setVisible(true);
                    MainFrame.recordPanel.setVisible(false);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }

            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                super.mouseWheelMoved(e);
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                super.mouseDragged(e);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);
            }
        });
    }
}
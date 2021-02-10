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

public class InfoPanel extends JPanel {

    public static final InfoPanel instance = new InfoPanel();

    private BufferedImage backgroundInfo;
    private static final int WIDTH_PANEL = 800;
    private static final int HEIGHT_PANEL = 600;

    private ClickArea back;

    private InfoPanel() {
        initPanel();
        initListener();
    }

    public static InfoPanel getInstance() {
        return instance;
    }

    private void initPanel() {
        this.setSize(WIDTH_PANEL, HEIGHT_PANEL);
        this.backgroundInfo = Images.loadImage("informazioni.png");
        this.back = new ClickArea(327, 488, 177, 44);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundInfo,0,0,null);
      //g.drawRect(327, 488, 177, 44);
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
                    MainFrame.infoPanel.setVisible(false);
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
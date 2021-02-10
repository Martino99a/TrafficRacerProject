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

public class MenuPanel extends JPanel {
    private static final MenuPanel instance = new MenuPanel();

    private static final int WIDTH_PANEL = 800;
    private static final int HEIGHT_PANEL = 600;

    private ClickArea info;
    private ClickArea credits;
    private ClickArea record;
    private ClickArea game;

    private BufferedImage backgroundMenu;

    private MenuPanel(){
        initPanel();
        initListener();
    }

    public static MenuPanel getInstance() {
        return instance;
    }

    private void initPanel(){
        this.setSize(WIDTH_PANEL, HEIGHT_PANEL);
        this.backgroundMenu = Images.loadImage("menu.png");
        this.info = new ClickArea(470, 307, 210, 42);
        this.record = new ClickArea(470, 375, 153, 42);
        this.credits = new ClickArea(470, 444, 141, 42);
        this.game = new ClickArea(470, 236, 294, 42);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundMenu, 0, 0, null);
      //g.drawRect(470, 307, 210, 42);
      //g.drawRect(470, 375, 155, 42);
      //g.drawRect(470, 444, 144, 42);
      //g.drawRect(470, 236, 297, 42);
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

                if(info.isClicked(e)) {
                    MainFrame.infoPanel.setVisible(true);
                    MainFrame.menuPanel.setVisible(false);
                    MainFrame.gamePanel.setVisible(false);
                    MainFrame.recordPanel.setVisible(false);
                    MainFrame.creditsPanel.setVisible(false);
                }
                if(credits.isClicked(e)) {
                    MainFrame.creditsPanel.setVisible(true);
                    MainFrame.menuPanel.setVisible(false);
                    MainFrame.gamePanel.setVisible(false);
                    MainFrame.infoPanel.setVisible(false);
                    MainFrame.recordPanel.setVisible(false);
                }
                if(record.isClicked(e)) {
                    MainFrame.recordPanel.setVisible(true);
                    MainFrame.menuPanel.setVisible(false);
                    MainFrame.gamePanel.setVisible(false);
                    MainFrame.infoPanel.setVisible(false);
                    MainFrame.creditsPanel.setVisible(false);
                }
                if(game.isClicked(e)) {
                    MainFrame.gamePanel.setVisible(true);
                    MainFrame.recordPanel.setVisible(false);
                    MainFrame.menuPanel.setVisible(false);
                    MainFrame.infoPanel.setVisible(false);
                    MainFrame.creditsPanel.setVisible(false);
                    GamePanel.getInstance().requestFocusInWindow();
                    GamePanel.getInstance().newGame();
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

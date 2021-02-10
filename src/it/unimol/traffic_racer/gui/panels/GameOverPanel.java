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

public class GameOverPanel extends JPanel {

    public static  final GameOverPanel instance = new GameOverPanel();

    private BufferedImage backgroundGameOver;
    private static final int WIDTH_PANEL = 800;
    private static final int HEIGHT_PANEL = 600;

    private  ClickArea back;

    private GameOverPanel(){
        initPanel();
        initListener();
    }

    public static GameOverPanel getInstance(){
        return instance;
    }

    private void initPanel() {
        this.setSize(WIDTH_PANEL, HEIGHT_PANEL);
        this.backgroundGameOver = Images.loadImage("riprova.png");
        this.back = new ClickArea(539, 470, 236, 106);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundGameOver,0,0,null);
      //g.drawRect(580, 510, 150, 50);
        g.setColor(Color.red);
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(Integer.toString(GamePanel.getInstance().getPoints()),662, 120);
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
                    MainFrame.gameOverPanel.setVisible(false);
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




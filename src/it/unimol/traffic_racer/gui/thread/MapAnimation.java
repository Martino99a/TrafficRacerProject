package it.unimol.traffic_racer.gui.thread;

import it.unimol.traffic_racer.gui.panels.GamePanel;

public class MapAnimation extends Thread{

    @Override
    public void run() {
        super.run();

        int points;

        while (!GamePanel.getInstance().getPlayer().isDead()) {
            points = GamePanel.getInstance().getPoints();
            points++;
            GamePanel.getInstance().setPoints(points);
            GamePanel.getInstance().repaint();
            GamePanel.getInstance().update();
            GamePanel.getInstance().updateSpeed();
            try {
                Thread.sleep(7);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }

}

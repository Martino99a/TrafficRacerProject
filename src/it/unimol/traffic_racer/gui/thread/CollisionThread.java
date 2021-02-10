package it.unimol.traffic_racer.gui.thread;

import it.unimol.traffic_racer.gui.frames.MainFrame;
import it.unimol.traffic_racer.gui.panels.GamePanel;
import it.unimol.traffic_racer.gui.panels.RecordPanel;

public class CollisionThread extends Thread {

    private long delay;
    private Runnable todo;
    private int maxpoint;

    public CollisionThread(long delay) {
        super();
        this.delay = delay;
    }

    public int getRecord() {
        return maxpoint;
    }

    @Override
    public void run() {
        super.run();
        while(!GamePanel.getInstance().getPlayer().isDead()){
            for (int i = 0; i < GamePanel.getInstance().getEnemies().size(); i++) {
                if(GamePanel.getInstance().getPlayerSprite().getPlayerCollider().intersects(GamePanel.getInstance().getEnemies().get(i).getEnemieCollider())){
                    GamePanel.getInstance().getPlayer().setDead(true);
                    MainFrame.gamePanel.setVisible(false);
                    MainFrame.gameOverPanel.setVisible(true);
                    this.maxpoint = GamePanel.getInstance().getPoints();
                    RecordPanel.getInstance().updateRecord();
                }
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

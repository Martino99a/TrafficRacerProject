package it.unimol.traffic_racer.gui.thread;

import it.unimol.traffic_racer.gui.panels.GamePanel;
import it.unimol.traffic_racer.gui.sprites.EnemySprite;

public class EnemyAnimation extends Thread {

    private EnemySprite enemySprite;

    public EnemyAnimation(EnemySprite enemySprite) {
        this.enemySprite = enemySprite;
    }

    @Override
    public void run() {
        super.run();

        while (!GamePanel.getInstance().getPlayer().isDead()) {
            this.enemySprite.getCoordinate().y += enemySprite.getSpeed();
            this.enemySprite.getEnemieCollider().y += enemySprite.getSpeed();
            GamePanel.getInstance().repaint();
            try {
                Thread.sleep(16);
            } catch (InterruptedException ex) {
            }
        }
    }
}

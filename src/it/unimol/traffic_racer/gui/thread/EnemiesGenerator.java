package it.unimol.traffic_racer.gui.thread;

import it.unimol.traffic_racer.app.Player;
import it.unimol.traffic_racer.gui.panels.GamePanel;
import it.unimol.traffic_racer.gui.sprites.EnemySprite;

import java.util.Random;

public class EnemiesGenerator extends Thread {

    private GamePanel gamePanel;
    private Player player;

    public EnemiesGenerator(GamePanel gamePanel, Player player){
        this.gamePanel = gamePanel;
        this.player = player;
    }

    @Override
    public void run() {
        super.run();

        int enemiesWait;

        while (!player.isDead()) {
            Random randomSpaceEnemies = new Random();
            enemiesWait = randomSpaceEnemies.nextInt(2);
            if (enemiesWait == 1) {
                this.gamePanel.getEnemies().add(new EnemySprite());
                this.gamePanel.repaint();
            }
            try {
                Thread.sleep(870);
            } catch (InterruptedException ex) {
            }
        }
    }
}

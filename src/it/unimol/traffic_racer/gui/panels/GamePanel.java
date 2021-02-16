package it.unimol.traffic_racer.gui.panels;

import it.unimol.traffic_racer.app.Player;
import it.unimol.traffic_racer.gui.sprites.EnemySprite;
import it.unimol.traffic_racer.gui.sprites.PlayerSprite;
import it.unimol.traffic_racer.gui.thread.EnemiesGenerator;
import it.unimol.traffic_racer.gui.thread.MapAnimation;
import it.unimol.traffic_racer.gui.thread.CollisionThread;
import it.unimol.traffic_racer.gui.utils.Images;
import it.unimol.traffic_racer.gui.utils.Resources;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class GamePanel extends JPanel implements ActionListener {

    public  static final GamePanel instance = new GamePanel();

    private static final int WIDTH_PANEL = 800;
    private static final int HEIGHT_PANEL = 600;
    private int velocita;
    private int points;
    private Player player;
    private int Y;
    private int Y2;
    private Point coordinate;
    private Rectangle rectangle;

    private BufferedImage backgroundGame;
    private PlayerSprite playerSprite;
    private EnemiesGenerator enemiesGenerator;
    private MapAnimation mapAnimation;
    private CollisionThread timer;

    private ArrayList<EnemySprite> enemies;

    private  GamePanel() {
        initPanel();
        initListener();
    }

    public static GamePanel getInstance(){
        return instance;
    }

    public ArrayList<EnemySprite> getEnemies() {
        return enemies;
    }

    public EnemiesGenerator getEnemiesGenerator() {
        return enemiesGenerator;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public MapAnimation getMapAnimation() {
        return mapAnimation;
    }

    public PlayerSprite getPlayerSprite() {
        return playerSprite;
    }

    public CollisionThread getTimer() {
        return timer;
    }

    private void initPanel(){
        this.setSize(WIDTH_PANEL, HEIGHT_PANEL);
        this.backgroundGame = Images.loadImage("pista.png");
        this.playerSprite = new PlayerSprite();
        this.setFocusable(true);
        this.points = 0;
        this.Y = 0;
        this.Y2 = -590;
        this.enemies = new ArrayList<>();
        this.player = new Player();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(backgroundGame,0, Y,null);
        g.drawImage(backgroundGame,0, Y2,null);
        g.drawImage(this.playerSprite.getPlayerImage(), this.playerSprite.getCoordinate().x, this.playerSprite.getCoordinate().y, null);
        //g.drawRect(playerSprite.getPlayerCollider().x, playerSprite.getPlayerCollider().y, playerSprite.getPlayerCollider().width, playerSprite.getPlayerCollider().height);

        for(int i = 0; i < enemies.size(); i++) {
            g.drawImage(this.enemies.get(i).getEnemyImage(), this.enemies.get(i).getCoordinate().x, this.enemies.get(i).getCoordinate().y, null);
            //g.drawRect(this.enemies.get(i).getEnemieCollider().x, this.enemies.get(i).getEnemieCollider().y, this.enemies.get(i).getEnemyImage().getWidth(null), this.enemies.get(i).getEnemyImage().getHeight(null));

            g.setColor(Color.black);
            g.fillRect(620, 37, 110, 35);
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 27));
            g.drawString(Integer.toString(GamePanel.getInstance().getPoints()),630, 65);
        }
    }

    public void newGame(){
        this.player.setDead(false);
        this.coordinate = new Point(370,478);
        this.playerSprite.setCoordinate(this.coordinate);
        this.rectangle = new Rectangle(370, 478, this.playerSprite.getPlayerImage().getWidth(null), this.playerSprite.getPlayerImage().getHeight(null));
        this.playerSprite.setPlayerCollider(this.rectangle);
        this.enemies.clear();
        this.points = 0;
        this.enemiesGenerator = new EnemiesGenerator(this, this.player);
        this.mapAnimation = new MapAnimation();
        this.timer = new CollisionThread(1);
        this.mapAnimation.start();
        this.enemiesGenerator.start();
        this.timer.start();
    }

    public void update() {
        if (Y < 600) {
            Y += velocita;
            Y2 += velocita;
        } else {
            Y = 0;
            Y2 = -600;
        }
    }

    public void updateSpeed() {
        velocita = 1 + (points / 1350);
    }

    private void initListener() {
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                super.keyTyped(e);
            }

            @Override
            public void keyPressed(KeyEvent ke) {
                super.keyPressed(ke);
                switch (ke.getKeyCode()) {
                    case KeyEvent.VK_W:
                        if (playerSprite.isCanMove() && playerSprite.getCoordinate().y > 315) {
                            playerSprite.getCoordinate().y -= 20;
                            playerSprite.getPlayerCollider().setBounds(playerSprite.getCoordinate().x, playerSprite.getCoordinate().y, playerSprite.getPlayerImage().getWidth(null), playerSprite.getPlayerImage().getHeight(null));
                        }
                        break;

                    case KeyEvent.VK_S:
                        if (playerSprite.isCanMove() && playerSprite.getCoordinate().y < 478) {
                            playerSprite.getCoordinate().y += 20;
                            playerSprite.getPlayerCollider().setBounds(playerSprite.getCoordinate().x, playerSprite.getCoordinate().y, playerSprite.getPlayerImage().getWidth(null), playerSprite.getPlayerImage().getHeight(null));
                        }

                        break;
                    case KeyEvent.VK_D:
                        if (playerSprite.isCanMove() && playerSprite.getCoordinate().x < 470) {
                            playerSprite.getCoordinate().x += 103;
                            playerSprite.getPlayerCollider().setBounds(playerSprite.getCoordinate().x, playerSprite.getCoordinate().y, playerSprite.getPlayerImage().getWidth(null), playerSprite.getPlayerImage().getHeight(null));
                        }

                        break;
                    case KeyEvent.VK_A:
                        if (playerSprite.isCanMove() && playerSprite.getCoordinate().x > 270) {
                            playerSprite.getCoordinate().x -= 103;
                            playerSprite.getPlayerCollider().setBounds(playerSprite.getCoordinate().x, playerSprite.getCoordinate().y, playerSprite.getPlayerImage().getWidth(null), playerSprite.getPlayerImage().getHeight(null));                        }
                        break;

                    default:
                        break;
                }
                repaint();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.repaint();
    }

}


package it.unimol.traffic_racer.gui.sprites;

import it.unimol.traffic_racer.gui.thread.EnemyAnimation;
import it.unimol.traffic_racer.gui.utils.Images;
import it.unimol.traffic_racer.gui.utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class EnemySprite {

    private BufferedImage enemyImage;
    private Point coordinate;
    private Rectangle enemieCollider;
    private Random random;
    private int speed;
    private EnemyAnimation enemyAnimation;

    private String[] machinetype;
    private int[] lanes;

    public EnemySprite() {
       initEnemySprite();
    }

    public Image getEnemyImage() {
        return enemyImage;
    }

    public void setEnemyImage(BufferedImage enemyImage) {
        this.enemyImage = enemyImage;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public Rectangle getEnemieCollider() {
        return enemieCollider;
    }

    public void setEnemieCollider(Rectangle enemieCollider) {
        this.enemieCollider = enemieCollider;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public String[] getMachinetype() {
        return machinetype;
    }

    public void setMachinetype(String[] machinetype) {
        this.machinetype = machinetype;
    }

    public int[] getLanes() {
        return lanes;
    }

    public void setLanes(int[] lanes) {
        this.lanes = lanes;
    }

    private void initEnemySprite(){
      this.machinetype = new String[] {"arancione", "rossa", "polizia", "pullman", "verde", "ambulanza", "celeste"};
      this.lanes = new int[] {270, 370, 470};
      this.speed = 5;
      this.coordinate = new Point();
      this.random = new Random();
      this.enemyImage = Images.loadImage("macchina_" + machinetype[random.nextInt(machinetype.length)] + ".png");
      this.coordinate.x = lanes[random.nextInt(lanes.length)];
      this.coordinate.y = -75;
      this.enemieCollider = new Rectangle(this.coordinate.x, this.coordinate.y, this.enemyImage.getWidth(null), this.enemyImage.getHeight(null));
      this.enemyAnimation = new EnemyAnimation(this);
      this.enemyAnimation.start();
    }

}

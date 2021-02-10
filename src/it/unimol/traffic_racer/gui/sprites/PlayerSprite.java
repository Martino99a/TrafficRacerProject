package it.unimol.traffic_racer.gui.sprites;

import it.unimol.traffic_racer.gui.utils.Images;
import it.unimol.traffic_racer.gui.utils.Resources;

import java.awt.*;
import java.awt.image.BufferedImage;

public class PlayerSprite {

     private Rectangle playerCollider;
     private Point coordinate;
     private BufferedImage playerImage;
     private boolean canMove;

    public PlayerSprite() {
        this.playerImage = Images.loadImage("macchina_player.png");
        this.coordinate = new Point(370, 478);
        this.playerCollider = new Rectangle(this.coordinate.x, this.coordinate.y, this.playerImage.getWidth(null), this.playerImage.getHeight(null));
        this.canMove = (true);
    }

    public boolean isCanMove() {
        return canMove;
    }

    public void setCanMove(boolean canMove) {
        this.canMove = canMove;
    }

    public Rectangle getPlayerCollider() {
        return playerCollider;
    }

    public void setPlayerCollider(Rectangle playerCollider) {
        this.playerCollider = playerCollider;
    }

    public Point getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point coordinate) {
        this.coordinate = coordinate;
    }

    public Image getPlayerImage() {
        return playerImage;
    }

    public void setPlayerImage(BufferedImage playerImage) {
        this.playerImage = playerImage;
    }

}

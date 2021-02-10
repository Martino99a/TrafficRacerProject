package it.unimol.traffic_racer.app;

public class Player {

    private boolean dead;

    public Player() {
        this.dead = false;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
}
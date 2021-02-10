package it.unimol.traffic_racer.gui.panels;

import java.awt.*;
import java.awt.event.MouseEvent;

public class ClickArea extends Rectangle {

    public ClickArea(int x, int y, int width, int height) {
        this.setBounds(x, y, width, height);
    }

    public boolean isClicked(MouseEvent e) {
        return this.contains(e.getPoint());
    }
}

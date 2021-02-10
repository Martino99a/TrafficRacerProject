package it.unimol.traffic_racer.gui.frames;

import it.unimol.traffic_racer.gui.panels.*;

import javax.swing.*;

public class MainFrame extends JFrame {
    private static final MainFrame instance = new MainFrame();

    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    public static MenuPanel menuPanel;
    public static InfoPanel infoPanel;
    public static CreditsPanel creditsPanel;
    public static RecordPanel recordPanel;
    public static GamePanel gamePanel;
    public static GameOverPanel gameOverPanel;

    private MainFrame(){
        initFrame();
    }

    public static MainFrame getInstance() {
        return instance;
    }

    private void initFrame(){
        this.setTitle("Traffic Racer");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH,HEIGHT);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(null);

        menuPanel = MenuPanel.getInstance();
        this.getContentPane().add(menuPanel);

        infoPanel = InfoPanel.getInstance();
        this.getContentPane().add(infoPanel);

        creditsPanel = CreditsPanel.getInstance();
        this.getContentPane().add(creditsPanel);

        recordPanel = RecordPanel.getInstance();
        this.getContentPane().add(recordPanel);

        gamePanel = GamePanel.getInstance();
        this.getContentPane().add(gamePanel);

        gameOverPanel = GameOverPanel.getInstance();
        this.getContentPane().add(gameOverPanel);


    }
}

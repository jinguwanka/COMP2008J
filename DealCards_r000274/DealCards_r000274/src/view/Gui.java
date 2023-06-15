package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DealCard.Controller;
import DealCard.Observer;
import DealCard.Player;

public class Gui extends JFrame {

    private JPanel contentPane;
    private Controller controller = new Controller();
    private JPanel panelMain;
    private ImagePanel rubbishPanel = new ImagePanel(null);
    private List<PlayerPanel> playerPanels = new ArrayList<>();

    private Observer observer = new Observer();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Gui frame = new Gui();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    /**
     * Create the frame.
     */
    public Gui() {
        initializeFrame();
        initializeContentPane();
        initializeLeftPanel();
        initializeMainPanel();
        controller.setGui(this);
    }

    private void initializeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1118, 704);
    }

    private void initializeContentPane() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
    }

    private void initializeLeftPanel() {
        JPanel panelLeft = new JPanel();
        contentPane.add(panelLeft, BorderLayout.WEST);
        panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));
        ImagePanel imagePanel = new ImagePanel("back/back.jpg");
        panelLeft.add(imagePanel);
        panelLeft.add(rubbishPanel);
    }

    private void initializeMainPanel() {
        panelMain = new JPanel();
        contentPane.add(panelMain, BorderLayout.CENTER);
        panelMain.setLayout(new BoxLayout(panelMain, BoxLayout.Y_AXIS));
    }

    public void addPlayer(Player player) {
        PlayerPanel panel = new PlayerPanel(player);
        observer.add(player, panel.getInfJLabel());
        player.setObserver(observer);
        panelMain.add(panel);
        playerPanels.add(panel);
    }

    public void displayPlayerPanels() {
        for (PlayerPanel playerPanel : playerPanels) {
            playerPanel.display();
            playerPanel.repaint();
        }
    }

    public void setRubbishImage(String imageString) {
        if (imageString == null) {
            return;
        }
        rubbishPanel.setImageString(imageString);
        rubbishPanel.repaint();
    }

}

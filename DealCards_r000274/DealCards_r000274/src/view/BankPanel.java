package view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import DealCard.Card;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

public class BankPanel extends JPanel {

    private JPanel cardPanel;
    private JScrollPane scrollPane;

    /**
     * Create the panel.
     */
    public BankPanel() {
        setPreferredSize(new Dimension(200, 120));

        cardPanel = new JPanel();
        cardPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        scrollPane = new JScrollPane(cardPanel);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        scrollPane.setPreferredSize(new Dimension(200, 120));

        add(scrollPane);
    }


}

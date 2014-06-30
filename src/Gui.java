import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

/**
 * @author Greg Hilston
 */
public class Gui extends JFrame {
    private static final int NUMCOLS = GameOfLifeApp.getNumCols();
    private static final int NUMROWS = GameOfLifeApp.getNumRows();
    public static JButton[][]buttons;

    public Gui() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();
        infoPanel = new JPanel();
        generationLabel = new JLabel();
        hSpacer1 = new JPanel(null);
        populationLabel = new JLabel();

        buttons = new JButton[NUMROWS][NUMCOLS];

        for(int row = 0; row < NUMROWS; row++) {
            for(int col = 0; col < NUMCOLS; col++)
            {
                Cell curCell = GameOfLifeApp.readBoard[row][col];
                JButton curButton = new JButton();

                Border emptyBorder = BorderFactory.createEmptyBorder();
                curButton.setBorder(emptyBorder);

                if(curCell.getAlive()) {
                    curButton.setBackground(GameOfLifeApp.getAliveColor());
                } else {
                    curButton.setBackground(GameOfLifeApp.getDeadColor());
                }

                buttons[row][col] = curButton;
                panel.add(buttons[row][col]);
            }
        }

        //======== this ========
        setTitle("Game of Life");
        setVisible(true);
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== panel ========
        {
            panel.setPreferredSize(new Dimension(700, 700));
            panel.setLayout(new GridLayout(GameOfLifeApp.getNumRows(), GameOfLifeApp.getNumCols()));
        }
        contentPane.add(panel, BorderLayout.CENTER);

        //======== infoPanel ========
        {
            infoPanel.setLayout(new FlowLayout());

            //---- generationLabel ----
            generationLabel.setText("Generation: ");
            infoPanel.add(generationLabel);
            infoPanel.add(hSpacer1);

            //---- populationLabel ----
            populationLabel.setText("Population: ");
            infoPanel.add(populationLabel);
        }
        contentPane.add(infoPanel, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel;
    private JPanel infoPanel;
    public static JLabel generationLabel;
    private JPanel hSpacer1;
    public static JLabel populationLabel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

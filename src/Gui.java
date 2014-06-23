import java.awt.*;
import javax.swing.*;

/**
 * @author Greg Hilston
 */
public class Gui extends JFrame {
    private static final int SIZE = GameOfLifeApp.SIZE;
    public static JButton[][]buttons;

    public Gui() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        initComponents();
    }
    /*
        JButton[][]buttons;
        buttons = new JButton[SIZE][SIZE];

        for(int col = 0; col < SIZE; col++) {
            for(int row = 0; row < SIZE; row++)
            {
                Cell curCell = GameOfLifeApp.board[col][row];
                JButton curButton = new JButton();
                if(curCell.isAlive) {
                    curButton.setBackground(Color.GREEN);
                } else {
                    curButton.setBackground(Color.BLACK);
                }

                buttons[col][row] = curButton;
                panel.add(buttons[col][row]);
            }
        }

     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        panel = new JPanel();


        buttons = new JButton[SIZE][SIZE];

        for(int col = 0; col < SIZE; col++) {
            for(int row = 0; row < SIZE; row++)
            {
                Cell curCell = GameOfLifeApp.board[col][row];
                JButton curButton = new JButton();
                if(curCell.isAlive) {
                    curButton.setBackground(Color.GREEN);
                } else {
                    curButton.setBackground(Color.BLACK);
                }

                buttons[col][row] = curButton;
                panel.add(buttons[col][row]);
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
            panel.setLayout(new GridLayout(GameOfLifeApp.SIZE, GameOfLifeApp.SIZE));
        }
        contentPane.add(panel, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel panel;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

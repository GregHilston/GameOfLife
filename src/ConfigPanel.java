import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.*;

/**
 * @author Greg Hilston
 */
public class ConfigPanel extends JFrame {
    private String aboutString = "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970.\n" +
            "\n" +
            "The \"game\" is a zero-player game, meaning that its evolution is determined by its initial state, requiring no further input. One interacts with the Game of Life by creating an initial configuration and observing how it evolves.\n\n" +
            "The Simulation follows these four rules: " +
            "\n" +
            "\t1. Any live cell with fewer than two live neighbours dies, as if caused by loneliness.\n" +
            "\t2. Any live cell with two or three live neighbours lives on to the next generation.\n" +
            "\t3. Any live cell with more than three live neighbours dies, as if by overcrowding.\n" +
            "\t4. Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.";


    public ConfigPanel() {
        initComponents();
    }

    // Unknown string defaults to Color.BLACK
    private Color stringToColor(String string) {
        if(string.equals("Black")) {
            return Color.BLACK;
        }
        else if(string.equals("Blue")) {
            return Color.BLUE;
        }
        else if(string.equals("Cyan")) {
            return Color.CYAN;
        }
        else if(string.equals("Gray")) {
            return Color.GRAY;
        }
        else if(string.equals("Magenta")) {
            return Color.MAGENTA;
        }
        else if(string.equals("Orange")) {
            return Color.ORANGE;
        }
        else if(string.equals("Pink")) {
            return Color.PINK;
        }
        else if(string.equals("Red")) {
            return Color.RED;
        }
        else if(string.equals("White")) {
            return Color.WHITE;
        }
        else if(string.equals("Yellow")) {
            return Color.YELLOW;
        }
        else {
            return Color.BLACK;
        }
    }

    private void okButtonActionPerformed(ActionEvent e) {
        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }

    private void cancelButtonActionPerformed(ActionEvent e) {
        System.exit(-1);
    }

    private void updateNumRows(int rows) {
        GameOfLifeApp.setNumRows(rows);
    }

    private void numRowsSliderStateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if(!source.getValueIsAdjusting()) {
            updateNumRows((int)source.getValue());
        }
    }

    private void updateNumCols(int cols) {
        GameOfLifeApp.setNumCols(cols);
    }

    private void numColsSliderStateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if(!source.getValueIsAdjusting()) {
            updateNumCols((int)source.getValue());
        }
    }

    private void updateLivePercentage(int livePercentage) {
        GameOfLifeApp.setLivePercentage(livePercentage);
    }

    private void livePercentageSliderStateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if(!source.getValueIsAdjusting()) {
            updateLivePercentage((int)source.getValue());
        }
    }

    private void updateGenerationTimer(int generationTimer) {
        GameOfLifeApp.setGenerationTimer(generationTimer);
    }

    private void generationTimerSliderStateChanged(ChangeEvent e) {
        JSlider source = (JSlider) e.getSource();
        if(!source.getValueIsAdjusting()) {
            updateGenerationTimer((int)source.getValue());
        }
    }

    private void updateAliveColor(String aliveColor) {
        GameOfLifeApp.setAliveColor(stringToColor(aliveColor));
    }

    private void aliveColorListValueChanged(ListSelectionEvent e) {
        JList source = (JList) e.getSource();
        String colorSelected = (String) source.getSelectedValue();
        updateAliveColor(colorSelected);
    }

    private void updateDeadColor(String deadColor) {
        GameOfLifeApp.setDeadColor(stringToColor(deadColor));
    }

    private void deadColorListValueChanged(ListSelectionEvent e) {
        JList source = (JList) e.getSource();
        String colorSelected = (String) source.getSelectedValue();
        updateDeadColor(colorSelected);
    }

    private void aboutButtonActionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this, aboutString);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        dialogPane = new JPanel();
        acknowledgementPanel = new JPanel();
        okButton = new JButton();
        cancelButton = new JButton();
        hSpacer1 = new JPanel(null);
        aboutButton = new JButton();
        configurablePanel = new JPanel();
        numRowsLabel = new JLabel();
        numRowsSlider = new JSlider();
        numColLabel = new JLabel();
        numColsSlider = new JSlider();
        livePercentageLabel = new JLabel();
        livePercentageSlider = new JSlider();
        generationTimerLabel = new JLabel();
        generationTimerSlider = new JSlider();
        aliveColorLabel = new JLabel();
        aliveColorPane = new JScrollPane();
        aliveColorList = new JList();
        deadColorLabel = new JLabel();
        deadColorPane = new JScrollPane();
        deadColorList = new JList();

        //======== this ========
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new Dimension(32, 76));
        setTitle("Game of Life Configuration Panel");
        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //======== dialogPane ========
        {
            dialogPane.setBorder(new EmptyBorder(12, 12, 12, 12));
            dialogPane.setPreferredSize(new Dimension(598, 598));
            dialogPane.setLayout(new BorderLayout());

            //======== acknowledgementPanel ========
            {
                acknowledgementPanel.setLayout(new FlowLayout());

                //---- okButton ----
                okButton.setText("Ok");
                okButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        okButtonActionPerformed(e);
                    }
                });
                acknowledgementPanel.add(okButton);

                //---- cancelButton ----
                cancelButton.setText("Cancel");
                cancelButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        cancelButtonActionPerformed(e);
                    }
                });
                acknowledgementPanel.add(cancelButton);
                acknowledgementPanel.add(hSpacer1);

                //---- aboutButton ----
                aboutButton.setText("About");
                aboutButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        aboutButtonActionPerformed(e);
                    }
                });
                acknowledgementPanel.add(aboutButton);
            }
            dialogPane.add(acknowledgementPanel, BorderLayout.SOUTH);

            //======== configurablePanel ========
            {
                configurablePanel.setLayout(new BoxLayout(configurablePanel, BoxLayout.Y_AXIS));

                //---- numRowsLabel ----
                numRowsLabel.setText("Number of Rows: ");
                configurablePanel.add(numRowsLabel);

                //---- numRowsSlider ----
                numRowsSlider.setMajorTickSpacing(10);
                numRowsSlider.setMinimum(10);
                numRowsSlider.setPaintTicks(true);
                numRowsSlider.setSnapToTicks(true);
                numRowsSlider.setPaintLabels(true);
                numRowsSlider.setMinorTickSpacing(2);
                numRowsSlider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        numRowsSliderStateChanged(e);
                    }
                });
                configurablePanel.add(numRowsSlider);

                //---- numColLabel ----
                numColLabel.setText("Number of Cols: ");
                configurablePanel.add(numColLabel);

                //---- numColsSlider ----
                numColsSlider.setForeground(Color.black);
                numColsSlider.setMajorTickSpacing(10);
                numColsSlider.setMinimum(10);
                numColsSlider.setPaintTicks(true);
                numColsSlider.setSnapToTicks(true);
                numColsSlider.setPaintLabels(true);
                numColsSlider.setMinorTickSpacing(2);
                numColsSlider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        numColsSliderStateChanged(e);
                    }
                });
                configurablePanel.add(numColsSlider);

                //---- livePercentageLabel ----
                livePercentageLabel.setText("Alive Cells Percentage: ");
                configurablePanel.add(livePercentageLabel);

                //---- livePercentageSlider ----
                livePercentageSlider.setMinimum(10);
                livePercentageSlider.setMaximum(50);
                livePercentageSlider.setMajorTickSpacing(5);
                livePercentageSlider.setSnapToTicks(true);
                livePercentageSlider.setPaintTicks(true);
                livePercentageSlider.setPaintLabels(true);
                livePercentageSlider.setMinorTickSpacing(1);
                livePercentageSlider.setValue(25);
                livePercentageSlider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        livePercentageSliderStateChanged(e);
                    }
                });
                configurablePanel.add(livePercentageSlider);

                //---- generationTimerLabel ----
                generationTimerLabel.setText("Generation Timer (ms)");
                configurablePanel.add(generationTimerLabel);

                //---- generationTimerSlider ----
                generationTimerSlider.setMaximum(1000);
                generationTimerSlider.setMinimum(250);
                generationTimerSlider.setMajorTickSpacing(250);
                generationTimerSlider.setPaintTicks(true);
                generationTimerSlider.setSnapToTicks(true);
                generationTimerSlider.setPaintLabels(true);
                generationTimerSlider.setMinorTickSpacing(50);
                generationTimerSlider.setValue(500);
                generationTimerSlider.setForeground(Color.black);
                generationTimerSlider.addChangeListener(new ChangeListener() {
                    @Override
                    public void stateChanged(ChangeEvent e) {
                        generationTimerSliderStateChanged(e);
                    }
                });
                configurablePanel.add(generationTimerSlider);

                //---- aliveColorLabel ----
                aliveColorLabel.setText("Alive Color");
                configurablePanel.add(aliveColorLabel);

                //======== aliveColorPane ========
                {

                    //---- aliveColorList ----
                    aliveColorList.setModel(new AbstractListModel() {
                        String[] values = {
                            "Black",
                            "Blue",
                            "Cyan",
                            "Gray",
                            "Magenta",
                            "Orange",
                            "Pink",
                            "Red",
                            "White",
                            "Yellow"
                        };
                        @Override
                        public int getSize() { return values.length; }
                        @Override
                        public Object getElementAt(int i) { return values[i]; }
                    });
                    aliveColorList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    aliveColorList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            aliveColorListValueChanged(e);
                            aliveColorListValueChanged(e);
                        }
                    });
                    aliveColorPane.setViewportView(aliveColorList);
                }
                configurablePanel.add(aliveColorPane);

                //---- deadColorLabel ----
                deadColorLabel.setText("Dead Color");
                configurablePanel.add(deadColorLabel);

                //======== deadColorPane ========
                {

                    //---- deadColorList ----
                    deadColorList.setModel(new AbstractListModel() {
                        String[] values = {
                            "Black",
                            "Blue",
                            "Cyan",
                            "Gray",
                            "Magenta",
                            "Orange",
                            "Pink",
                            "Red",
                            "White",
                            "Yellow"
                        };
                        @Override
                        public int getSize() { return values.length; }
                        @Override
                        public Object getElementAt(int i) { return values[i]; }
                    });
                    deadColorList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                    deadColorList.addListSelectionListener(new ListSelectionListener() {
                        @Override
                        public void valueChanged(ListSelectionEvent e) {
                            deadColorListValueChanged(e);
                        }
                    });
                    deadColorPane.setViewportView(deadColorList);
                }
                configurablePanel.add(deadColorPane);
            }
            dialogPane.add(configurablePanel, BorderLayout.CENTER);
        }
        contentPane.add(dialogPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents

        // Get initial/default values
        updateNumRows(numRowsSlider.getValue());
        updateNumCols(numColsSlider.getValue());
        updateLivePercentage(livePercentageSlider.getValue());
        updateGenerationTimer(generationTimerSlider.getValue());
        // updateAliveColor((String)aliveColorList.getSelectedValue()); // Nothing selected by default
        // updateDeadColor((String)deadColorList.getSelectedValue()); // Nothing selected by default
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    private JPanel dialogPane;
    private JPanel acknowledgementPanel;
    private JButton okButton;
    private JButton cancelButton;
    private JPanel hSpacer1;
    private JButton aboutButton;
    private JPanel configurablePanel;
    private JLabel numRowsLabel;
    private JSlider numRowsSlider;
    private JLabel numColLabel;
    private JSlider numColsSlider;
    private JLabel livePercentageLabel;
    private JSlider livePercentageSlider;
    private JLabel generationTimerLabel;
    private JSlider generationTimerSlider;
    private JLabel aliveColorLabel;
    private JScrollPane aliveColorPane;
    private JList aliveColorList;
    private JLabel deadColorLabel;
    private JScrollPane deadColorPane;
    private JList deadColorList;
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}

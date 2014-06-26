import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameOfLifeApp {
    public static Cell board[][];
    private static Object lock = new Object();

    // Set by configuration panel
    private static int numRows = 50;
    private static int numCols = 50;
    private static int livePercentage = 10;
    private static int generationTimer = 500;
    private static Color aliveColor = Color.BLACK;
    private static Color deadColor = Color.WHITE;

    public static void main(String args[]) {
        final ConfigPanel configPanel = new ConfigPanel();

        // Wait on configPanel
        Thread t = new Thread() {
            public void run() {
                synchronized(lock) {
                    while (configPanel.isVisible())
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                }
            }
        };
        t.start();

        configPanel.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                synchronized (lock) {
                    configPanel.setVisible(false);
                    lock.notify();
                }
            }
        });
        try {
            t.join();
        } catch (InterruptedException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        // End of waiting on configPanel

        board = new Cell[numRows][numCols];
        Boolean isAlive;
        Random generator = new Random();
        int randomNumber;

        for(int row = 0; row < numRows; row++) {
            for(int col = 0; col < numCols; col++) {
                randomNumber = generator.nextInt(100);

                if(randomNumber < livePercentage) {
                    isAlive = true;
                }
                else {
                    isAlive = false;
                }

                board[row][col] = new Cell(row, col, isAlive);
            }
        }

        Gui gui = new Gui();

        ActionListener updateEveryCell = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for(int row = 0; row < numRows; row++) {
                    for(int col = 0; col < numCols; col++) {
                        board[row][col].update();
                    }
                }
            }
        };
        Timer updateTimer = new Timer(generationTimer, updateEveryCell);
        updateTimer.start();
    }

    public static int getNumCols() {
        return numCols;
    }

    public static int getNumRows() {
        return numRows;
    }

    public static Color getDeadColor() {
        return deadColor;
    }

    public static Color getAliveColor() {
        return aliveColor;
    }

    public static void setNumRows(int numRows) {
        GameOfLifeApp.numRows = numRows;
    }public static void setNumCols(int numCols) {
        GameOfLifeApp.numCols = numCols;
    }public static void setLivePercentage(int livePercentage) {
        GameOfLifeApp.livePercentage = livePercentage;
    }public static void setGenerationTimer(int generationTimer) {
        GameOfLifeApp.generationTimer = generationTimer;
    }public static void setAliveColor(Color aliveColor) {
        GameOfLifeApp.aliveColor = aliveColor;
    }public static void setDeadColor(Color deadColor) {
        GameOfLifeApp.deadColor = deadColor;
    }
}

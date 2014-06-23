import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Random;

public class GameOfLifeApp {
    public static int SIZE = 50;
    public static Cell board[][];
    private static final int timerIntervals = 250;
    //private static Object lock = new Object();


    public static void main(String args[]) {
        board = new Cell[SIZE][SIZE];
        Boolean isAlive;
        Random generator = new Random();
        int randomNumber;
        int aliveCount = 0;

        for(int col = 0; col < SIZE; col++) {
            for(int row = 0; row < SIZE; row++) {
                randomNumber = generator.nextInt(12);

                if(randomNumber == 0) {
                    isAlive = true;
                }
                else {
                    isAlive = false;
                }

                board[col][row] = new Cell(col, row, isAlive);
            }
        }

        Gui gui = new Gui();

        ActionListener updateEveryCell = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                for(int col = 0; col < SIZE; col++) {
                    for(int row = 0; row < SIZE; row++) {
                        board[col][row].update();
                    }
                }
            }
        };
        Timer updateTimer = new Timer(timerIntervals, updateEveryCell);
        updateTimer.start();
    }
}

/*
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
*/
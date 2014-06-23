import java.awt.*;

public class Cell implements UpdateAble{
    private int row, col, aliveNeighborsCount;
    Boolean isAlive;

    public Cell(int row, int col, Boolean isAlive) {
        this.row = row;
        this.col = col;
        this.isAlive = isAlive;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Boolean getAlive() {
        return isAlive;
    }

    public void setAlive(Boolean alive) {
        isAlive = alive;
    }

    public int getAliveNeighborsCount() {
        return aliveNeighborsCount;
    }

    private void calculateAliveNeighbors() {
        final int MIN_X = 0;
        final int MIN_Y = 0;
        final int MAX_X = GameOfLifeApp.SIZE - 1;
        final int MAX_Y = GameOfLifeApp.SIZE - 1;

        int startPosX = (getRow() - 1 < MIN_X) ? getRow() : getRow() - 1;
        int startPosY = (getCol() - 1 < MIN_Y) ? getCol() : getCol() - 1;
        int endPosX =   (getRow() + 1 > MAX_X) ? getRow() : getRow() + 1;
        int endPosY =   (getCol() + 1 > MAX_Y) ? getCol() : getCol() + 1;

        aliveNeighborsCount = 0;

        // See how many are alive
        for (int rowNum = startPosX; rowNum <= endPosX; rowNum++) {
            for (int colNum = startPosY; colNum <= endPosY; colNum++) {
                if(GameOfLifeApp.board[rowNum][colNum].getAlive()) {
                    aliveNeighborsCount++;
                }
            }
        }
    }

    /*
        Any live cell with fewer than two live neighbours dies, as if caused by loneliness.
        Any live cell with two or three live neighbours lives on to the next generation.
        Any live cell with more than three live neighbours dies, as if by overcrowding.
        Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
     */
    @Override
    public void update() {
        calculateAliveNeighbors();

        if(getAlive()) { // This cell is alive
            if(getAliveNeighborsCount() < 2) {
                setAlive(false); // Death by loneliness
                Gui.buttons[row][col].setBackground(Color.BLACK);
            }
            else if(getAliveNeighborsCount() > 3) {
                setAlive(false); // Death by overcrowding
                Gui.buttons[row][col].setBackground(Color.BLACK);
            }
        }
        else { // This cell is dead
            if(getAliveNeighborsCount() == 3) {
                setAlive(true); // Life by reproduction
                Gui.buttons[row][col].setBackground(Color.GREEN);
            }
        }
    }

    @Override
    public String toString() {
        return getRow() + "," + getCol();
    }
}

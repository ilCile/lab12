package it.unibo.es2;

public class LogicsImpl implements Logics{

    private boolean[][] grid;
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        grid = new boolean[size][size];
    }

    public int getSize() {
        return this.size;
    }

    @Override
    public boolean toQuit() {
        boolean horWin, verWin;
        for (int i = 0; i < grid.length; i++) {
            horWin = true;
            verWin = true;
            for (int j = 0; j < grid[i].length; j++) {
                if (!grid[i][j] || !horWin) {
                    horWin = false;
                }
                if (!grid[j][i] || !verWin) {
                    verWin = false;
                }
            }
            if (verWin || horWin) return true;
        }

        return false;
    }

    @Override
    public String buttonClicked(Pair<Integer, Integer> position) {
        if (this.grid[position.getX()][position.getY()]) {
            this.grid[position.getX()][position.getY()] = false;
            return "";
        }else {
            this.grid[position.getX()][position.getY()] = true;
            return "*";
        }
    }

}

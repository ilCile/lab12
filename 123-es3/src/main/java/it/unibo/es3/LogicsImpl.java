package it.unibo.es3;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LogicsImpl implements Logics{

    private final int width;
    private final boolean[][] grid;

    public LogicsImpl(int width) {
        this.width = width;
        grid = new boolean[width][width];
    }

    @Override
    public boolean toQuit() {
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (!grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public List<Pair<Integer, Integer>> update() {
        List<Pair<Integer, Integer>> toUpdate = new ArrayList<>(toBeUpdated());
        for (var elem : toUpdate) {
            grid[elem.getX()][elem.getY()] = true;
        }
        return new ArrayList<>(toUpdate);
    }

    @Override
    public List<Pair<Integer, Integer>> start(int n) {
        final Random ran = new Random();
        List<Pair<Integer, Integer>> start = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            Pair<Integer, Integer> newElem = new Pair<>(ran.nextInt(width), ran.nextInt(width));
            if (!start.contains(newElem)) {
                start.add(newElem);
                grid[newElem.getX()][newElem.getY()] = true;
            }else {
                i--;
            }  
        }
        return new ArrayList<>(start);
    }

    @Override
    public int getWidth() {
        return this.width;
    }

     /**
     * support method fot update()
     * @return the list of position to be updated both internally (in grid) and externally
     */
    private List<Pair<Integer, Integer>> toBeUpdated() {
        List<Pair<Integer, Integer>> list = new ArrayList<>();
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (grid[i][j]) {            
                    if (i > 0) {
                        list.add(new Pair<Integer,Integer>(i-1,j));
                    }
                    if (i < width - 1) {
                        list.add(new Pair<Integer,Integer>(i+1,j));
                    }
                    if (j > 0) {
                        list.add(new Pair<Integer,Integer>(i,j-1));
                    }
                    if (j < width - 1) {
                        list.add(new Pair<Integer,Integer>(i,j+1));
                    }
                    if (i > 0 && j > 0) {
                        list.add(new Pair<Integer,Integer>(i-1,j-1));
                    }
                    if (i < width - 1 && j < width - 1) {
                        list.add(new Pair<Integer,Integer>(i+1,j+1));
                    }
                    if (i > 0 && j < width - 1) {
                        list.add(new Pair<Integer,Integer>(i-1,j+1));
                    }
                    if (i < width - 1 && j > 0) {
                        list.add(new Pair<Integer,Integer>(i+1,j-1));
                    }
                }
            }
        }
        return list;
    }
}

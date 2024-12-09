package it.unibo.es3;

import java.util.List;

public class LogicsImpl implements Logics{

    private final int width;

    public LogicsImpl(int width) {
        this.width = width;
    }

    @Override
    public boolean toQuit() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'toQuit'");
    }

    @Override
    public List<Pair<Integer, Integer>> update() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Pair<Integer, Integer>> start() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'start'");
    }

    @Override
    public int getWidth() {
        return this.width;
    }

}

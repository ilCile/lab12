package it.unibo.es2;

public interface Logics {
    boolean toQuit();

    String buttonClicked(Pair<Integer, Integer> position);

    int getSize();
}

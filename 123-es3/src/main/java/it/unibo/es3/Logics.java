package it.unibo.es3;

import java.util.List;

public interface Logics {

    /**
     * 
     * @return wheter or not to exit the program
     */
    boolean toQuit();
    
    /**
     * 
     * @return the list of position to be updated externally
     */
    List<Pair<Integer, Integer>> update();

    /**
     * @param n the number of starting position to be updated
     * @return a list of n position that inditicates the starting elements
     */
    List<Pair<Integer, Integer>> start(int n);

    /**
     * 
     * @return width
     */
    int getWidth();
}

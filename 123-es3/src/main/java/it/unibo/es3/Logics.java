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
     * @return the list of position to be updated
     */
    List<Pair<Integer, Integer>> update();

    /**
     * 
     * @return a list of 3 position that inditicates the starting elements
     */
    List<Pair<Integer, Integer>> start();

    /**
     * 
     * @return width
     */
    int getWidth();
}

package it.unibo.es3;

import javax.swing.*;
import java.awt.*;
import java.util.*;

public class GUI extends JFrame {
    
    private final Map<Pair<Integer, Integer>, JButton> cells = new HashMap<>();
    private final Logics logics;
    private final static int STARTING_ELEMENTS = 3;
    
    public GUI(int width) {
        logics = new LogicsImpl(width);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(70*width, 70*width);
        
        JPanel panel = new JPanel(new GridLayout(width,width));           
        for (int i=0; i<width; i++){
            for (int j=0; j<width; j++){
                final JButton jb = new JButton();
                cells.put(new Pair<>(i, j), jb);          
                panel.add(jb);
            }
        }

        logics.start(STARTING_ELEMENTS).stream().forEach(x -> cells.get(x).setText("*"));

        final JButton button = new JButton(">");
        this.getContentPane().add(BorderLayout.CENTER,panel);
        this.getContentPane().add(BorderLayout.SOUTH,button);
        this.setVisible(true);

        button.addActionListener(e -> {
            logics.update().stream().forEach(x -> cells.get(x).setText("*"));
            if (logics.toQuit()) {
                System.exit(0);
            }
        });
    }
    
}
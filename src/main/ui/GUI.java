package ui;

import javax.swing.*;
import java.awt.*;

public class GUI {

    public GUI() {
        System.out.println("RUNNING");
        JFrame frame = new JFrame();

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(90, 90, 10, 30));
        panel.setLayout(new GridLayout(0, 1));

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("UBC Wonderful Worklists");
        frame.pack();
        frame.setVisible(true);
    }

}

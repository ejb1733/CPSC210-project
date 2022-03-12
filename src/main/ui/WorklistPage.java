package ui;

import javax.swing.*;

public class WorklistPage {
    JFrame frame;
    JPanel panel;
    JLabel label = new JLabel("Enter a name for your new worklist");
    JTextField enterName = new JTextField(20);
    JButton enter = new JButton("Next");

    WorklistPage() {
        frame = new JFrame();
        panel = new JPanel();

        frame.setSize(300, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(panel);

        label.setBounds(35, 45, 250, 25);
        panel.add(label);

        enterName.setBounds(25, 20, 250, 25);
        panel.add(enterName);
        enter.setBounds(25, 100, 250, 50);
        panel.add(enter);

        frame.setTitle("Create a New Worklist");
        frame.setVisible(true);
    }
}

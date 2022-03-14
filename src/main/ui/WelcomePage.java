package ui;

import model.Courses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WelcomePage extends Courses implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton buttonNewWorklist = new JButton("Create a New Worklist!");
    JButton buttonNewCourse = new JButton("Create a New Course");
    JButton buttonEditWorklists = new JButton("Edit your Worklists");
    JButton buttonLoadWorklists = new JButton("Load your Worklists");
    JButton buttonSaveWorklists = new JButton("Save your Worklists");
    JButton buttonQuit = new JButton("Quit");

    public WelcomePage() {
        try {
            setupGUI();
        } catch (IOException e) {
            wll.getWll();
        }
        buttonQuit.addActionListener(
                e -> System.exit(1)
        );
        buttonNewWorklist.addActionListener(this);
        buttonEditWorklists.addActionListener(this);
        buttonSaveWorklists.addActionListener(this);
        buttonLoadWorklists.addActionListener(this);
    }

    void setupGUI() throws IOException {
        frame = new JFrame();
        setPanels();
        setFrame();

    }

    void setPanels() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(50, 20, 10, 20));
        panel.setLayout(new GridLayout(0, 1));
        JLabel picLabel = new JLabel(new ImageIcon("/Users/ejb/Desktop/UBCV/2021W2/CPSC 210/projekt/ubclog.png"));
        panel.add(picLabel);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(buttonNewWorklist);
        panel.add(buttonNewCourse);
        panel.add(buttonEditWorklists);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(buttonLoadWorklists);
        panel.add(buttonSaveWorklists);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(buttonQuit);
    }

    void setFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("UBC Wonderful Worklists");
        frame.pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNewWorklist) {
            new WorklistPage();
        } else if (e.getSource() == buttonEditWorklists) {
            if (wll.size() > 0) {
                new EditPage();
            } else {
                emptyWorklistList();
            }
        } else if (e.getSource() == buttonSaveWorklists) {
            new SaveLoad("save");
        } else if (e.getSource() == buttonLoadWorklists) {
            new SaveLoad("load");
        }
    }

    void emptyWorklistList() {
        String message = "You have no worklists, silly!";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
}

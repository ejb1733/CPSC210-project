package ui;

import model.Courses;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        setupGUI();

        buttonQuit.addActionListener(
                e -> System.exit(1)
        );
        buttonNewWorklist.addActionListener(this);
        buttonEditWorklists.addActionListener(this);
    }

    void setupGUI() {
        frame = new JFrame();
        setPanels();
        setFrame();
    }

    void setPanels() {
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(100, 100, 10, 100));
        panel.setLayout(new GridLayout(0, 1));
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
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNewWorklist) {
            new WorklistPage();
            frame.dispose();
        } else if (e.getSource() == buttonEditWorklists) {
            System.out.println("lol");
            if (wll.size() > 0) {
                new EditPage();
                frame.dispose();
            } else {
                emptyWorklistList();
            }
        }
    }

    void emptyWorklistList() {
        String message = "You have no worklists, silly!";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
}

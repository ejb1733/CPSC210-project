package ui;

import model.Courses;
import model.Event;
import model.EventLog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Represents the GUI's welcome page when the program is run
public class WelcomePage extends Courses implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton buttonNewWorklist = new JButton("Create a New Worklist!");
    JButton buttonNewCourse = new JButton("Create a New Course");
    JButton buttonEditWorklists = new JButton("Edit your Worklists");
    JButton buttonLoadWorklists = new JButton("Load your Worklists");
    JButton buttonSaveWorklists = new JButton("Save your Worklists");
    JButton buttonQuit = new JButton("Quit");

    Color ubcColour = new Color(12, 35, 68);

    // EFFECTS: creates a new page
    public WelcomePage() {
        try {
            setupGUI();
        } catch (IOException e) {
            wll.getWll();
        }
        buttonQuit.addActionListener(
                e -> {
                    System.out.println();
                    System.out.println("----------EVENT LOG----------");
                    for (Event event : EventLog.getInstance()) {
                        System.out.println(event.getDescription());
                    }
                    System.exit(1);
                }
        );
        buttonNewWorklist.addActionListener(this);
        buttonNewCourse.addActionListener(e -> new CreateCoursePage());
        buttonEditWorklists.addActionListener(this);
        buttonSaveWorklists.addActionListener(this);
        buttonLoadWorklists.addActionListener(this);
    }

    // EFFECTS: sets up the page
    void setupGUI() throws IOException {
        frame = new JFrame();
        setPanels();
        setFrame();
    }

    // EFFECTS: sets up the panels
    void setPanels() {
        ImageIcon logo = new ImageIcon("/Users/ejb/Desktop/UBCV/2021W2/CPSC 210/projekt/yay.jpeg");
        Image scaleImage = logo.getImage().getScaledInstance(425, 120, Image.SCALE_SMOOTH);
        panel = new JPanel();
        panel.setBorder(BorderFactory.createMatteBorder(20, 40, 20, 40, ubcColour));
        panel.setLayout(new GridLayout(0, 1));
        JLabel picLabel = new JLabel(new ImageIcon(scaleImage));
        panel.add(picLabel);
        panel.add(buttonNewWorklist);
        panel.add(buttonNewCourse);
        panel.add(buttonEditWorklists);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(buttonLoadWorklists);
        panel.add(buttonSaveWorklists);
        panel.add(Box.createHorizontalStrut(10));
        panel.add(buttonQuit);
    }

    // EFFECTS: sets up the frame
    void setFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("UBC Wonderful Worklists");
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    // EFFECTS: parses the input from buttons
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonNewWorklist) {
            new NewWorklistPage(0);
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

    // EFFECTS: creates an error pop-up window if the user clicks Edit Worklists when they have no worklists on file
    void emptyWorklistList() {
        String message = "You have no worklists, silly!";
        JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                JOptionPane.ERROR_MESSAGE);
    }
}

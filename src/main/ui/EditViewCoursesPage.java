package ui;

import model.Course;
import model.Worklist;

import javax.swing.*;
import java.awt.*;

// Represents the Edit -> View courses page
public class EditViewCoursesPage {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton back = new JButton("Back to Edit Menu");
    Worklist worklist;

    int count = 0;

    // EFFECTS: contructs a new page
    EditViewCoursesPage(Worklist wl) {
        worklist = wl;
        viewCourses();
    }

    // EFFECTS: displays the courses in worklist
    void viewCourses() {
        setFrame();
        for (Course c : worklist.getWorklistEntries()) {
            panel.add(new JButton(c.getCourseName()));
            count++;
        }
        label = new JLabel("Number of courses in worklist: " + count, SwingConstants.CENTER);
        panel.add(label);
        panel.add(back);
        frame.setVisible(true);
    }

    // EFFECTS: sets up the frame
    void setFrame() {
        frame = new JFrame();
        panel = new JPanel();
        back.addActionListener(e -> frame.dispose());
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(0, 1));
    }


}

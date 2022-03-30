package ui;

import model.Course;
import model.Worklist;

import javax.swing.*;
import java.awt.*;

// Represents the Edit -> View courses page
public class EditView extends JComponent {
    JFrame frame;
    JPanel panel;
    JLabel label;
    JButton next;
    JButton back = new JButton("Back to Edit Menu");

    int count = 0;

    // EFFECTS: constructs a new page
    EditView(Worklist wl) {
        viewCourses(wl);
    }

    // EFFECTS: displays the courses in worklist
    void viewCourses(Worklist worklist) {
        setFrame();
        for (Course c : worklist.getWorklistEntries()) {
            panel.add(next = new JButton(c.getCourseName()));
            next.addActionListener(e -> new DrawTree(c));
            count++;
        }
        label = new JLabel("Number of courses in worklist: " + count, SwingConstants.CENTER);
        panel.add(label);
        panel.add(back);
        frame.setVisible(true);
    }

//    void viewTree(Course course) {
//        ArrayList<Course> list = new ArrayList<>();
//        for (Course c : course.getPrereqs()) {
//            System.out.println(c.getCourseName());
//            list.add(course);
//        }
//        renderTree(list);
//    }
//
//    void renderTree(ArrayList<Course> list) {
//        int size = list.size();
//        System.out.println(size);
//        setTreeFrame();
//        Drawing myTree = new Drawing();
//        frame2.add(myTree);
//        frame2.setVisible(true);
//    }
//
//    void setTreeFrame() {
//        frame2 = new JFrame();
//        back2.addActionListener(e -> frame2.dispose());
//        frame2.setSize(800, 800);
//        frame2.setLocationRelativeTo(null);
//        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//    }

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

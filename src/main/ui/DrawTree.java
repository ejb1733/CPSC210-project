package ui;

import model.Course;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;

// Draws a JTree for a Course's requisites
public class DrawTree {
    JPanel pane;
    JFrame frame;
    JButton nextButton;
    JButton back;

    Color ubcColour = new Color(12, 35, 68);

    // constructs DrawTree
    DrawTree(Course c) {
        paint(c);
    }

    // EFFECTS: instantiates a new frame and pane to be in it.
    void paint(Course c) {
        frame = new JFrame();
        nextButton = new JButton(c.getCourseName());
        back = new JButton("BACK");

        pane = new JPanel(new GridBagLayout());
        pane.setBorder(BorderFactory.createMatteBorder(10, 30, 10, 30, ubcColour));
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.gridx = 0;
        constraints.gridy = 0;
        pane.add(nextButton, constraints);

        DefaultMutableTreeNode course = addPrereqs(c);
        JTree jt = new JTree(course);

        constraints.ipady = 50;
        constraints.gridy = 1;
        pane.add(jt, constraints);

        constraints.ipady = 0;
        constraints.gridy = 2;
        back.addActionListener(e -> frame.dispose());
        pane.add(back, constraints);

        frame.add(pane);
        frame.setSize(300, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

//    void addPrereqs(Course c) {
//        if (!c.getPrereqs().isEmpty()) {
//            DefaultTableModel model = new DefaultTableModel();
//            table = new JTable(model);
//            for (int i = 0; c.getPrereqs().size() < i; i++) {
//                Course prereq = c.getPrereqs().get(i);
//                more = new JButton(prereq.getCourseName());
//                table.setValueAt(c.getCourseName(), 1, i);
//            }
//            panel.add(table);
//        }
//    }

    // EFFECTS: iterates through a course and its pre-requisites to create a JTree
    DefaultMutableTreeNode addPrereqs(Course c) {
        if (!c.getPrereqs().isEmpty()) {
            DefaultMutableTreeNode head = new DefaultMutableTreeNode(c.getCourseName());
            for (Course prereq : c.getPrereqs()) {
                DefaultMutableTreeNode child = addPrereqs(prereq);
                head.add(child);
            }
            return head;
        }
        return new DefaultMutableTreeNode("CPSC 110");
    }

//    void addPrereqs(Course c) {
//        if (!c.getPrereqs().isEmpty()) {
//            panels = new JPanel();
//            panels.add(Box.createHorizontalStrut(frame.getWidth()));
//            for (Course prereq : c.getPrereqs()) {
//                more = new JButton(prereq.getCourseName());
//                panels.add(more);
//                if (!prereq.getPrereqs().isEmpty()) {
//                    addPrereqs(prereq);
//                }
//            }
//            panel.add(panels);
//        }
//    }

//    void addPrereqs(Course c) {
//        if (!c.getPrereqs().isEmpty()) {
//            for ()
//            DefaultMutableTreeNode n = new DefaultMutableTreeNode()
//        }
//    }

}

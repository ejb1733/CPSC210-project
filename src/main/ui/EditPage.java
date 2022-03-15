package ui;

import model.Course;
import model.Worklist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Courses;

public class EditPage extends Courses implements ActionListener {
    JFrame frame1;
    JFrame frame2;
    JFrame frame3;
    JPanel panel1;
    JPanel panel99;
    JPanel panel2;
    JPanel panel3;
    JLabel headerLabel = new JLabel("Please select from:", SwingConstants.CENTER);

    JButton nextButton;
    JButton goBack = new JButton("Back to Main Menu");
    JButton goBack2 = new JButton("Back to Worklist Options");
    JButton goBack3 = new JButton("Back to Worklist Options");
    JButton view;
    JButton add;
    JButton remove;
    JButton editName;
    JButton delete;

    EditPage() {
        firstPage();
    }

    void firstPage() {
        frame1 = new JFrame();
        panel1 = new JPanel();

        frame1.setSize(300, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel1);
        panel1.setLayout(new GridLayout(0, 1));

        panel1.add(headerLabel);

        for (Worklist wl : Courses.wll.getWll()) {
            nextButton = new JButton(wl.getWorklistName());
            nextButton.addActionListener(
                    e -> editWorklist(wl)
            );
            panel1.add(nextButton);
        }
        goBack.addActionListener(this);
        panel1.add(Box.createHorizontalStrut(10));
        panel1.add(goBack);
        frame1.setTitle("Select a Worklist to Edit");
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true);

    }

    void editWorklist(Worklist wl) {
        setFrame2(wl);
        view = new JButton("View courses");
        add = new JButton("Add a course");
        remove = new JButton("Remove a course");
        editName = new JButton("Edit " + wl.getWorklistName() + "'s name");
        delete = new JButton("Delete worklist");
        panel2.add(view);
        panel2.add(add);
        panel2.add(remove);
        panel2.add(editName);
        panel2.add(delete);
        panel2.add(Box.createHorizontalStrut(10));
        panel2.add(goBack2);
        editButtons(wl);
    }

    void editButtons(Worklist wl) {
        view.addActionListener(e -> new ViewCourses(wl));
        add.addActionListener(
                e -> {
                    WorklistPage p = new WorklistPage(1);
                    p.secondPage(wl);
                }
        );
        remove.addActionListener(e -> new RemoveCourse(wl));
        editName.addActionListener(
                e -> {
                    new EditName(wl);
                    frame2.dispose();
                    frame1.dispose();
                }
        );
        delete.addActionListener(
                e -> {
                    wll.removeWorklist(wl);
                    String message = "Your worklist - " + wl.getWorklistName()
                            + " - has been successfully deleted.";
                    JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
                            JOptionPane.ERROR_MESSAGE);
                    frame2.dispose();
                    frame1.dispose();
                }
        );
    }

    void setFrame2(Worklist wl) {
        frame2 = new JFrame();
        frame2.setTitle("Options for editing " + wl.getWorklistName());
        panel2 = new JPanel();
        goBack2.addActionListener(this);

        frame2.setSize(300, 300);
        frame2.setLocationRelativeTo(null);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(panel2);
        panel2.setLayout(new GridLayout(0, 1));
        frame2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == goBack) {
            frame1.dispose();
        } else if (e.getSource() == goBack2) {
            frame2.dispose();
        } else if (e.getSource() == goBack3) {
            frame3.dispose();
        }
    }
}

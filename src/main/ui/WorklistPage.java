package ui;

import model.Course;
import model.Courses;
import model.Worklist;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class WorklistPage extends Courses implements ActionListener {
    JFrame frame1;
    JPanel panel1;
    JLabel enterLabel = new JLabel("Enter a name for your new worklist");
    JTextField enterNameField = new JTextField(20);
    JButton nextButton = new JButton("Next");

    Worklist worklist;

    JFrame frame2;
    JPanel panel2;
    JButton firstYearButton = new JButton("First year courses");
    JButton secondYearButton = new JButton("Second year courses");
    JButton thirdYearButton = new JButton("Third year courses");
    JButton fourthYearButton = new JButton("Fourth year courses");

    JFrame frame3;
    JPanel panel3;

    WorklistPage(int i) {
        if (i == 0) {
            firstPage();
        }
    }

    void firstPage() {
        frame1 = new JFrame();
        panel1 = new JPanel();

        frame1.setSize(300, 125);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel1);

        panel1.add(enterLabel);

        enterNameField.setBounds(25, 20, 250, 25);
        panel1.add(enterNameField);
        nextButton.setBounds(25, 100, 250, 50);
        panel1.add(nextButton);

        frame1.setLocationRelativeTo(null);
        frame1.setTitle("Create a New Worklist");
        frame1.setVisible(true);

        nextButton.addActionListener(
                e -> {
                    String name = enterNameField.getText();
                    worklist = new Worklist(name);
                    wll.add(worklist);
                    secondPage(worklist);
                    frame1.dispose();
                }
        );
    }

    public void secondPage(Worklist wl) {
        worklist = wl;
        JLabel selectYearsLabel = new JLabel("To add courses to - " + worklist.getWorklistName()
                + " - please select from the following:");

        frame2 = new JFrame();
        panel2 = new JPanel();

        frame2.setSize(500, 200);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(panel2);

        panel2.add(selectYearsLabel);
        panel2.add(firstYearButton);
        panel2.add(secondYearButton);
        panel2.add(thirdYearButton);
        panel2.add(fourthYearButton);

        firstYearButton.addActionListener(this);
        secondYearButton.addActionListener(this);
        thirdYearButton.addActionListener(this);
        fourthYearButton.addActionListener(this);

        frame2.setTitle("Select Course Years");
        frame2.setVisible(true);
    }

    void coursePages(ArrayList<Course> year) {
        setPage3();
        JButton jb;
        JButton goBack = new JButton("Back to main menu");

        for (Course c : year) {
            panel3.add(jb = new JButton(c.getCourseName()));
            jb.addActionListener(
                    e -> worklist.addCourse(c)
            );
        }

        panel3.add(Box.createHorizontalStrut(10));
        panel3.add(goBack);
        goBack.addActionListener(
                e -> {
                    frame3.dispose();
                    frame2.dispose();
                }
        );

        frame3.setTitle("Courses from year " + year);
        frame3.setVisible(true);
    }

    void setPage3() {
        frame3 = new JFrame();
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(0, 1));
        frame3.setSize(350, 600);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.add(panel3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == firstYearButton) {
            coursePages(firstYears);
        } else if (e.getSource() == secondYearButton) {
            coursePages(secondYears);
        } else if (e.getSource() == thirdYearButton) {
            coursePages(thirdYears);
        } else if (e.getSource() == fourthYearButton) {
            coursePages(fourthYears);
        }
    }
}
package ui;

import model.Course;
import model.Courses;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCoursePage extends Courses implements ActionListener {
    JFrame frame;
    JPanel panel;
    JButton setName;
    JLabel label;
    JTextField enterName;

    JFrame frame2;
    JPanel panel2;
    JLabel label2;
    JComboBox yearList;
    JButton finish;

    Course course;

    CreateCoursePage() {
        setupGUI();
    }

    void setupGUI() {
        enterName = new JTextField(20);
        setName = new JButton("next");
        label = new JLabel("Enter a name for your new Course!", SwingConstants.CENTER);
        frame = new JFrame();
        panel = new JPanel();
        setName.addActionListener(this);


        panel.add(label);
        panel.add(enterName);
        panel.add(setName);
        frame.add(panel);
        frame.setSize(300, 125);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void setupGUI2() {
        frame2 = new JFrame();
        panel2 = new JPanel();
        label2 = new JLabel("Select a year for - " + course.getCourseName() + " - to be listed as:",
                SwingConstants.CENTER);
        yearList = new JComboBox(yearOptions.toArray());
        finish = new JButton("Done");
        yearList.setSelectedIndex(0);

        panel2.add(label2);
        panel2.add(yearList);
        finish.addActionListener(this);
        panel2.add(finish);
        panel2.setBorder(BorderFactory.createEmptyBorder(0, 50,0, 50));
        frame2.add(panel2);
        frame2.setSize(350, 100);
        frame2.setLocationRelativeTo(null);
        frame2.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == setName) {
            course = new Course(enterName.getText(), noPrereqs);
            setupGUI2();
            frame.dispose();
        } else if (e.getSource() == finish) {
            int year = yearList.getSelectedIndex() + 1;
            if (year == 1) {
                firstYears.add(course);
            } else if (year == 2) {
                secondYears.add(course);
            } else if (year == 3) {
                thirdYears.add(course);
            } else if (year == 4) {
                fourthYears.add(course);
            }
            frame2.dispose();
        }
    }
}

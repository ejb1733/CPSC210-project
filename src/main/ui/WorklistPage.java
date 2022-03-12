package ui;

import model.Courses;
import model.Worklist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    WorklistPage() {
        firstPage();
    }

    void firstPage() {
        frame1 = new JFrame();
        panel1 = new JPanel();

        frame1.setSize(300, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel1);

        enterLabel.setBounds(35, 45, 250, 25);
        panel1.add(enterLabel);

        enterNameField.setBounds(25, 20, 250, 25);
        panel1.add(enterNameField);
        nextButton.setBounds(25, 100, 250, 50);
        panel1.add(nextButton);

        frame1.setTitle("Create a New Worklist");
        frame1.setVisible(true);

        nextButton.addActionListener(this);
    }

    void secondPage() {
        JLabel selectYearsLabel = new JLabel("To add courses to " + worklist.getWorklistName()
                + ", please select from the following:");

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

    void coursePages(int year) {
        setPage3();
        if (year == 1) {
            for (int i = 0; i < firstYears.size(); i++) {
                panel3.add(new JButton(firstYears.get(i).getCourseName()));
            }
        } else if (year == 2) {
            for (int i = 0; i < secondYears.size(); i++) {
                panel3.add(new JButton(secondYears.get(i).getCourseName()));
            }
        } else if (year == 3) {
            for (int i = 0; i < secondYears.size(); i++) {
                panel3.add(new JButton(thirdYears.get(i).getCourseName()));
            }
        } else if (year == 4) {
            for (int i = 0; i < fourthYears.size(); i++) {
                panel3.add(new JButton(fourthYears.get(i).getCourseName()));
            }
        }
        frame3.setTitle("Courses from year " + year);
        frame3.setVisible(true);
    }

    void setPage3() {
        frame3 = new JFrame();
        panel3 = new JPanel();
        frame3.setSize(500, 500);
        frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame3.add(panel3);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = enterNameField.getText();
        worklist = new Worklist(name);
        secondPage();
        frame1.dispose();
        if (e.getSource() == firstYearButton) {
            coursePages(1);
        } else if (e.getSource() == secondYearButton) {
            coursePages(2);
        } else if (e.getSource() == thirdYearButton) {
            coursePages(3);
        } else if (e.getSource() == fourthYearButton) {
            coursePages(4);
        }
    }
}

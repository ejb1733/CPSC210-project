package ui;

import model.Worklist;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.Courses;

public class EditPage extends Courses implements ActionListener {
    JFrame frame1;
    JPanel panel1;
    JLabel headerLabel = new JLabel("Please select from the following worklists:");
    JButton nextButton;

    EditPage() {
        firstPage();
    }

    void firstPage() {
        frame1 = new JFrame();
        panel1 = new JPanel();

        frame1.setSize(300, 300);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(panel1);

        headerLabel.setBounds(35, 45, 250, 25);
        panel1.add(headerLabel);

        for (Worklist wl : Courses.wll.getWll()) {
            nextButton = new JButton(wl.getWorklistName());
            panel1.add(nextButton);
            nextButton.addActionListener(
                    e -> editWorklist(wl)
            );
        }

        frame1.setTitle("Create a New Worklist");
        frame1.setVisible(true);

//        nextButton.addActionListener(this);
    }

    void editWorklist(Worklist wl) {
        JFrame frame2 = new JFrame();
        JPanel panel2 = new JPanel();

        frame2.setSize(300, 300);
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.add(panel2);

//        JButton
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

package ui;

import javax.swing.*;

public class EditPage {
    JFrame frame1;
    JPanel panel1;
    JLabel enterLabel = new JLabel("Please select from the following worklists:");
    JButton nextButton = new JButton("Next");

    EditPage() {
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

//        enterNameField.setBounds(25, 20, 250, 25);
//        panel1.add(enterNameField);
        nextButton.setBounds(25, 100, 250, 50);
        panel1.add(nextButton);

        frame1.setTitle("Create a New Worklist");
        frame1.setVisible(true);

//        nextButton.addActionListener(this);
    }

}

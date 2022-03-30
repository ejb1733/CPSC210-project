package ui;

import model.Worklist;

import javax.swing.*;

// Represents the page for editing a course's name
public class EditName {
    JFrame frame;
    JPanel panel;
    JTextField name = new JTextField(20);
    JButton enter = new JButton("Enter");

    // EFFECTS: constructs a new page
    EditName(Worklist wl) {
        editName(wl);
    }

    // EFFECTS: designs the page
    void editName(Worklist worklist) {
        JLabel label = new JLabel("Please enter a new name for " + worklist.getWorklistName());
        frame = new JFrame();
        panel = new JPanel();
        panel.add(label);
        panel.add(name);
        enter = new JButton("Enter");
        enter.addActionListener(
                e -> {
                    String newName = name.getText();
                    String message = "Your worklists' name has been successfully changed from - "
                            + worklist.getWorklistName() + " - to - " + newName;
                    JOptionPane.showMessageDialog(new JFrame(), message, "Success!",
                            JOptionPane.INFORMATION_MESSAGE);
                    worklist.setWorklistName(newName);
                    frame.dispose();
                }
        );
        panel.add(enter);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel);
        frame.setSize(300, 125);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

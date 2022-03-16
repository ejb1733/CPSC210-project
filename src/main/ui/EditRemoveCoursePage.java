package ui;

import model.Course;
import model.Worklist;

import javax.swing.*;
import java.awt.*;

public class EditRemoveCoursePage {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JButton nextButton;
    JButton back;

    EditRemoveCoursePage(Worklist wl) {
        removeCourse(wl);
    }

    void removeCourse(Worklist wl) {
        setFrame(wl);
        for (Course c : wl.getWorklistEntries()) {
            nextButton = new JButton(c.getCourseName());
            nextButton.addActionListener(
                    e -> {
                        wl.removeCourse(c);
                        String message = c.getCourseName() + " has been successfully removed from - "
                                +  wl.getWorklistName();
                        JOptionPane.showMessageDialog(new JFrame(), message, "Success!",
                                JOptionPane.INFORMATION_MESSAGE);
                        frame.dispose();
                    }
            );
            panel.add(nextButton);
        }
        panel.add(Box.createHorizontalStrut(10));
        back = new JButton("Back to Edit Options");
        back.addActionListener(e -> frame.dispose());
        panel.add(back);
        errorScreen(wl);
    }

    void setFrame(Worklist wl) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panel.setLayout(new GridLayout(0, 1));
        frame.add(panel);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setTitle("Remove a course from " + wl.getWorklistName());
        frame.setVisible(true);
    }

    void errorScreen(Worklist wl) {
        if (wl.getWorklistSize() == 0) {
            String s = "Worklist is empty!";
            JOptionPane.showMessageDialog(new JFrame(), s, "Oopsies!", JOptionPane.ERROR_MESSAGE);
            frame.dispose();
        }
    }
}

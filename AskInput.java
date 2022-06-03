// Kaustav Mitra
// JFrame extension to get input from the user by displaying radio buttons.

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AskInput extends JFrame {
    private String selection;

    public String getSelection() {
        return selection;
    }

    public AskInput(String title, String[] buttons, Game game) {
        setTitle(title);
        setSize(300, 40);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setVisible(true);
        panel.setBackground(Color.yellow);
        panel.add(new JLabel(title, SwingConstants.CENTER), BorderLayout.CENTER);

        JFrame frame = this;
        setAlwaysOnTop(true);
        setUndecorated(true);
        setVisible(true);
        for (String s: buttons) {
            JRadioButton button = new JRadioButton(s);
            button.setBackground(Color.YELLOW);
            //from web (https://stackoverflow.com/questions/71808817/how-to-implement-button-addactionlistenernew-actionlistener#:~:text=true)%3B%0A%20%20%20%20%20%20%20%20lionButton.-,addActionListener(new,-ActionListener()%20%7B%0A%20%20%20%20%20%20%20%20%20%20%20%20%40Override
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    selection = e.getActionCommand();
                    frame.setVisible(false);
                }});
                panel.add(button);
        }

        frame.add(panel);
        setVisible(true);

        while (selection == null) {
            game.delay(true);
        }

        frame.dispose();
    }
}

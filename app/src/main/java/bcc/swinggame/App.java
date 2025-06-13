package bcc.swinggame;

import javax.swing.*;
import java.awt.*;

public class App extends JFrame {
    private int secretNumber = (int) (Math.random() * 100) + 1;
    private JTextField inputField;
    private JLabel messageLabel;

    public App() {
        super("Guess the Number");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 160);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS)); 

        JLabel title = new JLabel("🎯 Guess a number between 1 and 100:");
        inputField = new JTextField();
        JButton guessButton = new JButton("Guess");
        messageLabel = new JLabel("Enter your guess above.");
        messageLabel.setForeground(Color.BLUE);

        add(title, "w:100%");
        add(inputField, "w:100%");
        add(guessButton, "w:100%,h:30");
        add(messageLabel, "w:100%");

        guessButton.addActionListener(e -> checkGuess());
        inputField.addActionListener(e -> checkGuess()); 

        setVisible(true);
    }

    private void checkGuess() {
        try {
            int guess = Integer.parseInt(inputField.getText().trim());
            if (guess < 1 || guess > 100) {
                messageLabel.setText("Please enter a number between 1 and 100.");
            } else if (guess < secretNumber) {
                messageLabel.setText("Too low! Try again.");
            } else if (guess > secretNumber) {
                messageLabel.setText("Too high! Try again.");
            } else {
                messageLabel.setText("🎉 Correct! You guessed it!");
            }
        } catch (NumberFormatException ex) {
            messageLabel.setText("Invalid input. Please enter a number.");
        }
        inputField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(App::new);
    }
}

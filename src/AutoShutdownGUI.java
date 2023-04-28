import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AutoShutdownGUI extends Shutdown{
    public JPanel panel;
    public JTextArea secondsTextArea;
    private JButton clickButton;
    public JTextField outputTextField;
    private JButton cancelButton;
    private JButton secondsButton;
    private JButton hourButton;
    private JButton minutesButton;
    public String textInputValue;

public AutoShutdownGUI() {
    clickButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textInputValue =  secondsTextArea.getText();
            outputTextField.setText("Done!");
            try {
                int seconds = Integer.parseInt(textInputValue);
                ShutdownWithTimer(seconds);
            } catch (Exception ex) {
                outputTextField.setText("Wrong input type entered!");
            }
        }
    });
    cancelButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            CancelShutdownTimer();
        }
    });
    secondsTextArea.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
            if(!Character.isDigit(e.getKeyChar())) {
                e.consume();
            }
        }
    });
    secondsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            outputTextField.setText("Time Unit changed to Second.");
            timeUnitMode = TimeUnitMode.SECONDS;
        }
    });
    minutesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            outputTextField.setText("Time Unit changed to Minute.");
            timeUnitMode = TimeUnitMode.MINUTE;
        }
    });
    hourButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            outputTextField.setText("Time Unit changed to Hour.");
            timeUnitMode = TimeUnitMode.HOUR;
        }
    });
}
}

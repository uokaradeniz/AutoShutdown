import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class AutoShutdownGUI extends Shutdown{
    public JPanel panel;
    public JTextArea secondsTextArea;
    private JButton shutdownButton;
    public JTextField outputTextField;
    private JButton cancelButton;
    private JButton secondsButton;
    private JButton hourButton;
    private JButton minutesButton;
    private JButton restartButton;
    public String textInputValue;

public AutoShutdownGUI() {
    shutdownButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textInputValue =  secondsTextArea.getText();
            outputTextField.setText("Shutdown sequence started successfully!");
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
            try {
                CancelShutdownTimer();
                if(exitValue != 0)
                    outputTextField.setText("No sequence is scheduled.");
                else
                    outputTextField.setText("Sequence cancelled successfully!");

            } catch (Exception ex) {
                outputTextField.setText("Exception: " + ex);
            }
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
    restartButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            textInputValue =  secondsTextArea.getText();
            outputTextField.setText("Restart sequence started successfully!");
            try {
                int seconds = Integer.parseInt(textInputValue);
                RestartWithTimer(seconds);
            } catch (Exception ex) {
                outputTextField.setText("Wrong input type entered!");
            }
        }
    });
}
}

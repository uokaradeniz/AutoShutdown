import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Auto Shutdown");
        frame.setContentPane(new AutoShutdownGUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = screenSize.width / 2;
        int y = screenSize.height / 2;
        frame.setLocation(x, y);
        frame.setResizable(false);
        frame.pack();

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
        frame.setVisible(true);
    }
}


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.security.Key;

public class BrowserVault {
    public static void main(String[] args) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        JFrame frame = new JFrame("BrowserVault");
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        frame.setVisible(true);
        frame.pack();
        device.setFullScreenWindow(frame);
        secTab.create(frame).run();
    }
}

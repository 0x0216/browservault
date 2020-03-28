import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.net.URL;


public class BrowserVault {
    public static void main(String[] args) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        JFrame frame = new JFrame("BrowserVault");
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel contentPane = new contentPane();
        frame.add(contentPane);

        frame.setVisible(true);
        frame.pack();
        device.setFullScreenWindow(frame);
        secTab.create(frame).run();
    }
}

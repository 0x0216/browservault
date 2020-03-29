import javafx.application.Platform;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

import java.net.URL;


public class BrowserVault {
    public static void browser(String link) {
        boolean working = true;

        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        JFrame frame = new JFrame("BrowserVault");
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        if (link == null) {
            link = "https://3axes.github.io/browservault/";
        }

        JPanel contentPane = new contentPane(link);
        frame.add(contentPane);

        frame.setVisible(true);
        frame.pack();
        device.setFullScreenWindow(frame);

//        Platform.runLater(new Runnable() {
//            @Override
//            public void run() {
//                secTab.create(frame).run();
//            }
//        });

        while (working) {
            if (javax.swing.FocusManager.getCurrentManager().getFocusedWindow() == null) {
                System.out.println("Active Window not BrowserVault");
                System.exit(-2);
            }
        }
    }
}

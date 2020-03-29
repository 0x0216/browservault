import java.awt.*;
import javax.swing.*;

public class BrowserVault {

    private static JFrame frame;

    public static void browser(String link) {
        GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = graphics.getDefaultScreenDevice();

        frame = new JFrame("BrowserVault");
        frame.setAlwaysOnTop(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        if (link.equals("http://Link") || link.equals("http://")) {
            link = "https://3axes.github.io/browservault/";
        }

        JPanel contentPane = new contentPane(link);
        frame.add(contentPane);

        frame.setVisible(true);
        frame.pack();
        device.setFullScreenWindow(frame);
    }

    public static void secureStart() {
        (new secWindow(frame)).run();
    }
}

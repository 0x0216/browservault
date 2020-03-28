import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class secTab implements Runnable
{
    private boolean working = true;
    private JFrame frame;

    public secTab(JFrame frame)
    {
        this.frame = frame;
    }

    public void stop()
    {
        working = false;
    }

    public static secTab create(JFrame frame)
    {
        secTab stopper = new secTab(frame);
        new Thread(stopper, "Alt-Tab Stopper").start();
        return stopper;
    }

    public void run()
    {
        try
        {
            Robot robot = new Robot();
            while (working)
            {
                robot.keyRelease(KeyEvent.VK_ALT);
                robot.keyRelease(KeyEvent.VK_TAB);
                frame.requestFocus();
                try { Thread.sleep(5); } catch(Exception e) {}
            }
        } catch (Exception e) { e.printStackTrace(); System.exit(-1); }
    }
}

import javax.swing.*;

public class secWindow implements Runnable {

    private boolean working = true;
    private JFrame window;

    public secWindow(JFrame window) {
        this.window = window;
        new Thread(this, "Secure Window").start();
    }

    public void stop() {
        working = false;
    }

    public void run() {
        while(working) {
            if (!window.isActive()) {
                System.out.println("BrowserVault not Active Window.");
                System.exit(-2);
                try {Thread.sleep(10);} catch(Exception e){e.printStackTrace();}
            }
        }
    }
}

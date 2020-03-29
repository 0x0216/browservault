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
        Thread splitThread = new Thread(new Runnable() {
            @Override
            public void run() {
                while(working) {
                    try {Thread.sleep(1000);} catch(Exception e){e.printStackTrace();}
                    if (!window.isActive()) {
                        System.out.println("BrowserVault not Active Window.");
                        System.exit(-2);
                    }
                }
            }
        });

        splitThread.start();
    }
}

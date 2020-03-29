import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class contentPane extends JPanel {

//    private JEditorPane editPane;
    private JFXPanel editPane;
    private JTextField locationInput;

    public contentPane(String link) {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout(1,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        editPane = new JFXPanel();
//        editPane.setEditable(false);
//        editPane.addHyperlinkListener(new contentPane.LinkListener());
        add(new JScrollPane(editPane),BorderLayout.CENTER);

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);

        add(toolbar,BorderLayout.NORTH);
        locationInput = new JTextField(link);
        locationInput.setEditable(false);

        JButton closeButton = new JButton(new AbstractAction("Exit") {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        toolbar.add(closeButton);
        toolbar.add(new JLabel(" URL: "));
        toolbar.add(locationInput);
        toolbar.addSeparator(new Dimension(5,0));
//        try {
//            loadURL(new URL(link));
//        }
//        catch(Exception e) {
//            JOptionPane.showMessageDialog(contentPane.this, "URL does not exist.");
//            System.exit(-1);
//        }

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebView wv = new WebView();
                editPane.setScene(new Scene(wv));
                wv.getEngine().load(link);
            }
        });
    }

//    private class LinkListener implements HyperlinkListener {
//        public void hyperlinkUpdate(HyperlinkEvent evt) {
//            if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
//                loadURL(evt.getURL());
//            }
//        }
//    }

//    private void loadURL(URL url) {
//        try {
//            editPane.setPage(url);
//        } catch (Exception e) {
//            editPane.setContentType("text/plain");
//            editPane.setText("Sorry, the requested document was not found\n"
//                    + "or cannot be displayed.\n\nError:" + e);
//        }
//    }
}

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Scene;
import javafx.scene.web.WebView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class contentPane extends JPanel {

    private JFXPanel editPane;
    private JTextField locationInput;

    public contentPane(String link) {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout(1,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK,2));

        editPane = new JFXPanel();
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

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                WebView wv = new WebView();
                editPane.setScene(new Scene(wv));
                wv.getEngine().load(link);
            }
        });
    }
}

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class contentPane extends JPanel {

    private JEditorPane editPane;
    private JTextField locationInput;

    public contentPane() {
        setBackground(Color.BLACK);
        setLayout(new BorderLayout(1,1));
        setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        editPane = new JEditorPane();
        editPane.setEditable(false);
        editPane.addHyperlinkListener(new contentPane.LinkListener());
        add(new JScrollPane(editPane),BorderLayout.CENTER);

        JToolBar toolbar = new JToolBar();
        toolbar.setFloatable(false);
        add(toolbar,BorderLayout.NORTH);
        ActionListener goListener = new contentPane.GoListener();
        locationInput = new JTextField("https://3axes.github.io/browservault/", 40);
        locationInput.addActionListener(goListener);
        JButton goButton = new JButton(" Go ");
        goButton.addActionListener(goListener);
        toolbar.add( new JLabel(" Location: "));
        toolbar.add(locationInput);
        toolbar.addSeparator(new Dimension(5,0));
        toolbar.add(goButton);
    }

    private class LinkListener implements HyperlinkListener {
        public void hyperlinkUpdate(HyperlinkEvent evt) {
            if (evt.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                loadURL(evt.getURL());
            }
        }
    }

    private class GoListener implements ActionListener {
        public void actionPerformed(ActionEvent evt) {
            URL url;
            try {
                String location = locationInput.getText().trim();
                if (location.length() == 0)
                    throw new Exception();
                if (! location.contains("://"))
                    location = "http://" + location;
                url = new URL(location);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(contentPane.this,
                        "The Location input box does not\nccontain a legal URL.");
                return;
            }
            loadURL(url);
            locationInput.selectAll();
            locationInput.requestFocus();
        }
    }

    private void loadURL(URL url) {
        try {
            editPane.setPage(url);
        } catch (Exception e) {
            editPane.setContentType("text/plain");
            editPane.setText("Sorry, the requested document was not found\n"
                    + "or cannot be displayed.\n\nError:" + e);
        }
    }
}

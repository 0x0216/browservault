import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Program {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }
        catch (Exception e) {
            System.out.println("not found.");
        }

        JFrame frame = new JFrame("BrowserVault");
        JPanel panel = new JPanel(new GridLayout(0, 1));

        panel.setSize(360, 160);

        Border border = BorderFactory.createEmptyBorder(15, 15, 20, 15);
        panel.setBorder(border);

        JLabel welcomeLabel = new JLabel("Please paste the provided link in the text field below, then press GO.");

        JTextField linkField = new JTextField("Link");

        JPanel miniPanel = new JPanel(new GridLayout(1, 0, 3, 1));
        JPanel namePanel = new JPanel();
        JPanel goPanel = new JPanel();

        JTextField nameField = new JTextField("Name                                                      ");
        JButton goButton = new JButton("GO");

        miniPanel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

        namePanel.add(nameField);
        goPanel.add(goButton);
        goPanel.add(Box.createHorizontalStrut(60));
        miniPanel.add(namePanel);
        miniPanel.add(goPanel);


        AbstractAction onPress = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String link = linkField.getText();
                if (!link.startsWith("http")) {
                    link = "http://" + link;
                }
                BrowserVault.browser(link);
                BrowserVault.secureStart();
            }
        };

        goButton.addActionListener(onPress);
        linkField.addActionListener(onPress);

        panel.add(welcomeLabel);
        panel.add(linkField);
        panel.add(miniPanel);

        frame.add(panel);
        frame.setSize(500, 200);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

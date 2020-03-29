import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.KeyCombination;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.web.WebView;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class webView extends Application{

    Stage mainStage = new Stage();
    WebView web = new WebView();
    public static String link = "3axes.github.io/browservault";

    @Override
    public void start(Stage stage) throws Exception {
        mainStage.setTitle("BrowserVault: " + link);
        web.getEngine().load(link);

        Menu menu = new Menu("Operations");

        MenuItem refreshItem = new MenuItem("Refresh");
        refreshItem.setAccelerator(KeyCombination.keyCombination("Ctrl+R"));
        refreshItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                web.getEngine().load(link);
            }
        });
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                System.exit(0);
            }
        });

        menu.getItems().addAll(refreshItem, exitItem);

        VBox box = new VBox(web);
        Scene mainScene = new Scene(box);
        mainStage.setScene(mainScene);

        mainStage.setFullScreen(true);
        mainStage.setResizable(false);
        mainStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {

            }
        });

        mainStage.show();
    }

    public void setLink(String link) {
        this.link = link;
        web.getEngine().load(link);
    }
}
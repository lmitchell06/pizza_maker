import javafx.stage.*;
import au.edu.uts.ap.javafx.ViewLoader;
import model.Pizzeria;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class PizzeriaApplication extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    //private final Label title = new Label();
    
    @Override
    public void start(Stage stage) throws Exception {
        //title.setText("Main menu");
        //title.setAlignment(Pos.CENTER_LEFT);
        //title.setTextAlignment(TextAlignment.LEFT);
        ViewLoader.showStage(new Pizzeria(), "/view/pizzeria.fxml", "Main menu", stage);
        
    }
}

package controller;

import au.edu.uts.ap.javafx.Controller;
import au.edu.uts.ap.javafx.ViewLoader;
import java.io.IOException;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.ObjectProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import model.Customer;
import model.Pizzeria;

public class PizzeriaController extends Controller<Pizzeria> {
    @FXML private ListView<Customer> customersLV;
    //@FXML private ToggleButton on;
    @FXML private Button serveBtn;
    @FXML private Button reportBtn;
    @FXML private Button addCustomerBtn;
    //private final Label title = new Label("Serve customer");
    
    
    @FXML public void initialize() {
        customersLV.getSelectionModel().selectedItemProperty().addListener(
 (o, oldBtn, newBtn) -> serveBtn. setDisable(getSelectedCustomer() == null));
    }
    
    
    /*public final ObjectProperty<EventHandler<? super MouseEvent>> onMouseClickedProperty() {
        
    }*/

    public final Pizzeria getPizzeria() {
        return model;
    }
    
    private Customer getSelectedCustomer() {
        return customersLV.getSelectionModel().getSelectedItem();
    }
    
    public final double getReportIncome() {
        return model.getKitchen().getIncome();
    }
    
    @FXML public void serveCustomer(ActionEvent event) throws IOException {
        ViewLoader.showStage(getSelectedCustomer(), "/view/serve.fxml", "Serve customer", new Stage());
    }
    
    @FXML public void viewReport(ActionEvent event) throws IOException {
        ViewLoader.showStage(model.getKitchen(), "/view/report.fxml", "Income report", new Stage());
    }
    
    @FXML public void addCustomer(ActionEvent event) throws IOException {
        ViewLoader.showStage(getPizzeria(), "/view/customer_add.fxml", "Add customer", new Stage());
    }
    
}

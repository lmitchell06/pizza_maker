package controller;

import javafx.collections.*;
import javafx.event.*;
import javafx.fxml.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.stage.*;
import javafx.beans.property.*;
import java.io.*;
import java.text.*;
import au.edu.uts.ap.javafx.*;
import javafx.beans.binding.*;
import model.*;

public class ServeController extends Controller<Customer> {
    @FXML private Text orderTotalTxt;
    @FXML private ComboBox<Pizza> pizzaCmb;
    @FXML private Button createBtn;
    @FXML private Button selectBtn;
    @FXML private Button submitBtn;
    @FXML private Button cancelBtn;
    @FXML private ListView<Pizza> order;
    double sum;
    
    @FXML public void initialize() {
        //orderTotalTxt.setText("$" + formatted(getCash()));
        //orderTotalTxt.textProperty().bind(getCustomer().getCashProperty().asString("$%.2f"));
        //orderTotalTxt.textProperty().bindBidirectional(getCustomer().getCashProperty().asString("$%.2f"));
        //(model.getCashProperty().asString("$%.2f")));
        orderTotalTxt.setText(formatted(model.getOrderPrice()));
        //double ordPrice = model.OrderPrice();
        //orderTotalTxt.setText(formatted(ordPrice));
        pizzaCmb.getSelectionModel().selectedItemProperty().addListener(
 (o, oldBtn, newBtn) -> selectBtn.setDisable(getPastPizza() == null));
        
        order.getSelectionModel().selectedItemProperty().addListener(
 (o, oldBtn, newBtn) -> submitBtn.setDisable(model.getOrder().isEmpty()));
        
    }
    

    public final Customer getCustomer() { return model; }
    private final double getCash() {
        return model.getCash();
    }

    private final void setCash(double value) {
        orderTotalTxt.setText(new DecimalFormat("###,##0.00").format(model.getOrderPrice()));
    }  
    
    @FXML private Pizza getPastPizza() {
        return pizzaCmb.getSelectionModel().getSelectedItem();
    }
    
    private double getTotal() {
        return Double.parseDouble(orderTotalTxt.getText());
    }
    
    public void setTotalTxt(double value) {
        orderTotalTxt.setText("$" + String.valueOf(formatted(model.getOrderPrice())));
    }
    
    private String formatted(double n) {
        return new DecimalFormat("$###,##0.00").format(n);
    }
    
    @FXML public void createPizza(ActionEvent event) throws IOException {
        ViewLoader.showStage(model.createPizza(), "/view/pizza.fxml", "Create pizza", new Stage());
    }
    
    @FXML public void select() { 
        double ord = getPastPizza().getPrice();
        sum += ord;
        getPastPizza().order();
        submitBtn.setDisable(false);
        pizzaCmb.getSelectionModel().clearSelection();
        orderTotalTxt.setText(formatted(model.getOrderPrice()));
        //model.getOrder();
    }
    
    @FXML public void handleSubmit() {
        if (getCustomer().getOrder().isEmpty()) {
            submitBtn.setDisable(true);
        } else {
          model.submitOrder();  
          stage.close();  
        }
        
    }

    @FXML public void handleCancel() {
        if (!getCustomer().getOrder().isEmpty()) {
            model.cancelOrder();
            stage.close();
        } else {
            stage.close();
        }
    }
}
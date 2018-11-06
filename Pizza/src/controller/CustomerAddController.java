package controller;

import au.edu.uts.ap.javafx.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Customer;
import model.Pizza;
import model.Pizzeria;

public class CustomerAddController extends Controller<Pizzeria> {
    @FXML private Label phoneTxt;
    @FXML private TextField phoneTf;
    @FXML private Label nameTxt;
    @FXML private TextField nameTf;
    @FXML private Button addCustBtn;
    @FXML private Button cancelBtn;
    @FXML private Text message;
    
    private String getPhone() { return phoneTf.getText(); }
    
    private void setPhone(String phone) { phoneTf.setText(phone); }
    
    private String getName() { return nameTf.getText(); }
    
    private void setName(String name) { nameTf.setText(name); }
    
    @FXML public void initialize() {
        phoneTf.textProperty().addListener((o, oldText, newText) ->
           btnUpdate());
        nameTf.textProperty().addListener((o, oldText, newText) ->
           btnUpdate());
    }
    
    public final Pizzeria getPizzeria() { return model; }
    
    private boolean fieldCheck() {
        return getPhone().length()>0 && getName().length()>0;
    }
    
    private void btnUpdate() {
        addCustBtn.setDisable(!fieldCheck());
    }
    
    @FXML public void handleAddCustomer() throws Exception {
        try {
            Customer c = model.addCustomer(getPhone(), getName());
            if (c == null)
                model.addCustomer(getPhone(), getName());
            stage.close();
        } catch (Exception e) {
            message.setText("Customer already exists");
        }
    }
    
    @FXML public void handleCancel() { 
        stage.close();
    }
    
}

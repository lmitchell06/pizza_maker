package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.text.Text;
import model.Ingredient;
import model.Pizza;
import javafx.beans.binding.*;

public class PizzaController extends Controller<Pizza> {

    @FXML private Text availableTxt;
    @FXML private ListView<Ingredient> ingredientsLv;
    @FXML private ListView<Ingredient> selectedIngredientsLv;
    @FXML private Button createBtn;
    @FXML private Button addIngredientBtn;
    @FXML private Button removeIngredientBtn;
    @FXML private Button cancelBtn;
    @FXML private Text priceTxt;
    @FXML private Text message;
    double sum;

    @FXML public void initialize() {
        ingredientsLv.getSelectionModel().selectedItemProperty().addListener(
                (o, oldIng, newIng) -> addIngredientBtn.setDisable(getSelectedIngredient() == null));
        selectedIngredientsLv.getSelectionModel().selectedItemProperty().addListener(
                (o, oldIng, newIng) -> removeIngredientBtn.setDisable(getIngredientSelected() == null));
//        selectedIngredientsLv.getSelectionModel().selectedItemProperty().addListener(
//                (o, oldBtn, newBtn) -> createBtn.setDisable(!model.meetsMinimumRequirements()));
        //priceTxt.textProperty().bind(getPizza().priceProperty().asString("$%.2f"));
        createBtn.setDisable(!getPizza().meetsMinimumRequirements());
        priceTxt.setText(formatted(0.00));
        message.setText(model.getStatusString());
        message.setVisible(!getPizza().meetsMinimumRequirements());
    }

    public final Pizza getPizza() {
        return model;
    }

    public ListView<Ingredient> getIngredientsLv() {
        return ingredientsLv;
    }

    private Ingredient getSelectedIngredient() {
        return ingredientsLv.getSelectionModel().getSelectedItem();
    }
    
    public ListView<Ingredient> getSelectedIngredientsLv() {
        return selectedIngredientsLv;
    }

    private Ingredient getIngredientSelected() {
        return selectedIngredientsLv.getSelectionModel().getSelectedItem();
    }
    
    private double getAmount() {
	return Double.parseDouble(priceTxt.getText());
    }
    
    private void setAmount(double amount) {
	priceTxt.setText("" + amount);
    }
    
    private String formatted(double n) {
        return new DecimalFormat("$###,##0.00").format(n);
    }
    
    @FXML public void handleAdd() {
        double ing = getSelectedIngredient().getPrice();
        sum += ing;
        if (model.canAdd(getSelectedIngredient())) {
            model.add(getSelectedIngredient());
            priceTxt.setText(formatted(sum));
            createBtn.setDisable(!getPizza().meetsMinimumRequirements());
            message.setText(model.getStatusString());
            message.setVisible(!getPizza().meetsMinimumRequirements());
        }
        //setAmount(getAmount() + model.getPrice());
        //(getSelectedIngredient().priceProperty().asString("$%.2f"));
    }
    
    @FXML public void handleRemove() {
        double ing = getIngredientSelected().getPrice();
        sum -= ing;
        model.remove(getIngredientSelected());
        //setAmount(sum);
        createBtn.setDisable(!getPizza().meetsMinimumRequirements());
        message.setText(model.getStatusString());
        message.setVisible(!getPizza().meetsMinimumRequirements());
        priceTxt.setText(formatted(sum));
    }
    
    @FXML public void handleCreate() {
            model.order();
            stage.close();  
    }
    
    @FXML public void handleCancel() {
        this.model.getCustomer().cancelOrder();
        stage.close();
    }
}

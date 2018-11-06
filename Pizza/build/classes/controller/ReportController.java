package controller;

import au.edu.uts.ap.javafx.Controller;
import java.text.DecimalFormat;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import model.Ingredient;
import model.Kitchen;
import javafx.beans.binding.*;
import javafx.scene.control.Button;
import model.Pizza;

public class ReportController extends Controller<Kitchen> {
    @FXML private TableView<Ingredient> reportTv;
    @FXML private TableColumn<Ingredient, String> ingredientClm;
    //@FXML private PropertyValueFactory<Kitchen, ObservableList<Ingredient>> ingredientClmFct;
    @FXML private TableColumn<Ingredient, String> priceClm;
    @FXML private TableColumn<Ingredient, String> soldClm;
    @FXML private TableColumn<Ingredient, String> incomeClm;
    @FXML private Text totalInc;
    @FXML private Button closeBtn;     
    
    public final Kitchen getKitchen() { return model; }
    
    @FXML private void initialize() {
        //incomeClm.textProperty().bind(getIngredient().getIngredients()
       reportTv.setItems(model.getIngredients());
        //ingredientClm.setCellValueFactory(cellData -> cellData.getValue().ingStringProperty());
        //ingredientClmFct.call((TableColumn.CellDataFeatures<Ingredient, ObservableList<Ingredient>>) kitchen.getIngredients());
        //reportTv.setItems(kitchen.getIngredients());
        ingredientClm.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        priceClm.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asString("$%.2f"));
        soldClm.setCellValueFactory(cellData -> cellData.getValue().soldProperty().asString());
        incomeClm.setCellValueFactory(cellData -> cellData.getValue().getIncomeProperty().asString("$%.2f"));
        //incomeClm.setCellValueFactory(cellData -> cellData.getValue().getIncome();
        //totalInc.textProperty().bind(observable);
        double inc = model.getIncome();
        totalInc.setText(formatted(inc));
        

    }
    
    private String formatted(double n) {
        return new DecimalFormat("$###,##0.00").format(n);
    }
    
    @FXML public void handleClose() { 
        stage.close();
    }
    
}

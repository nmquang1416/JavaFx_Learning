package tutorial.video17;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    @Override
    public void start(Stage stage) throws IOException {
        window = stage;
        window.setTitle("Video 17 - 18 - 19");
//        window.setResizable(false);

        //Name columns
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price columns
        TableColumn<Product, Double> namePrice = new TableColumn<>("Price");
        namePrice.setMinWidth(200);
        namePrice.setCellValueFactory(new PropertyValueFactory<>("price"));

        //quantity columns
        TableColumn<Product, String> nameQuantity = new TableColumn<>("Quantity");
        nameQuantity.setMinWidth(200);
        nameQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(200);

        //price input
        priceInput = new TextField();
        priceInput.setPromptText("price");
        priceInput.setMinWidth(200);

        //quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("quantity");
        quantityInput.setMinWidth(200);

        //Button
        Button addButton = new Button("Add");
        Button deleteButton = new Button("Delete");

        HBox hBox = new HBox();
        hBox.setPadding(new Insets(10, 10, 10, 10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, namePrice, nameQuantity);

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.getChildren().addAll(table);

        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.show();
    }

    //get all of the products
    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("laptop", 859.00, 20));
        products.add(new Product("Bouncy Ball", 2.49, 198));
        products.add(new Product("Msi", 99.00, 74));
        products.add(new Product("asus", 19.99, 12));
        products.add(new Product("corn", 1.49, 856));
        return products;
    }

    public static void main(String[] args) {
        launch();
    }
}
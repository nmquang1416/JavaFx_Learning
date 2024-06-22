package tutorial.video20;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.security.auth.callback.Callback;
import java.io.IOException;

public class
Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    Stage window;
    TableView<Product> table;
    TextField nameInput, priceInput, quantityInput;

    @Override
    public void start(Stage primaryStage) throws IOException {
        window = primaryStage;
        window.setTitle("Video 20");

        //Name columns
        TableColumn<Product, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        //Price columns
        TableColumn<Product, String> priceColumn = new TableColumn<>("Price");
        priceColumn.setMinWidth(200);
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));

        //quantity column
        TableColumn<Product, String> quantityColumn = new TableColumn<>("Quantity");
        quantityColumn.setMinWidth(200);
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));

        //name input
        nameInput = new TextField();
        nameInput.setPromptText("Name");
        nameInput.setMinWidth(200);

        //price input
        priceInput = new TextField();
        priceInput.setPromptText("Price");
        priceInput.setMinWidth(200);

        //quantity input
        quantityInput = new TextField();
        quantityInput.setPromptText("Quantity");
        quantityInput.setMinWidth(200);

        //Button
        Button addButton = new Button("Add");
        addButton.setOnAction(event -> addButtonClicked());
        Button deleteButton = new Button("Delete");
        deleteButton.setOnAction(event -> deleteButtonClicked());

        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 10, 10, 10));
        hbox.setSpacing(8);
        hbox.getChildren().addAll(nameInput, priceInput, quantityInput, addButton, deleteButton);

        table = new TableView<>();
        table.setItems(getProduct());
        table.getColumns().addAll(nameColumn, priceColumn, quantityColumn);

        VBox vbox = new VBox();
        vbox.getChildren().addAll( table ,hbox);
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }

    private void deleteButtonClicked() {
        ObservableList<Product> productSelectedm, allProducts;
        allProducts = table.getItems();
        productSelectedm = table.getSelectionModel().getSelectedItems();
        productSelectedm.forEach(allProducts::remove);
    }

    private void addButtonClicked() {
        Product product = new Product();
        product.setName(nameInput.getText());
        product.setPrice(Double.parseDouble(priceInput.getText()));
        product.setQuantity(Integer.parseInt(quantityInput.getText()));
        table.getItems().add(product);
        nameInput.clear();
        priceInput.clear();
        quantityInput.clear();
    }

    public ObservableList<Product> getProduct(){
        ObservableList<Product> products = FXCollections.observableArrayList();
        products.add(new Product("Quang", 999, 99));
        products.add(new Product("Minh", 999, 99));
        products.add(new Product("Nguyen", 999, 99));
        products.add(new Product("Minh Quang", 999, 99));
        products.add(new Product("Quang Minh", 999, 99));
        return products;
    }
}
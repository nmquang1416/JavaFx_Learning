package tutorial.video08;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    static Boolean answer;
    public static Boolean display(String title, String message){
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label(message);
        label.setText(message);

        Button btnYes = new Button("Yes");
        Button btnNo = new Button("No");

        btnYes.setOnAction(actionEvent -> {
            answer = true;
            window.close();
        });

        btnNo.setOnAction(actionEvent -> {
            answer = false;
            window.close();
        });

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(label, btnYes, btnNo);
        vBox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vBox);
        window.setScene(scene);
        window.showAndWait();
        return answer;
    }
}
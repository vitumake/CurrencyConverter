package view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;
import controller.ConvController;

public class ConvGui extends Application{

    private Label result = new Label("0.0");
    Spinner<Double> amount = new Spinner<Double>(0, 1000000000, 0, 0.1);
    private ConvController controller;
    private ObservableList<String> currencies;
    private ComboBox<String> from;
    private ComboBox<String> to;
    private String updateStatus;

    public void start(Stage window) {
        GridPane pane = new GridPane();
        TilePane resultPane = new TilePane();
        Label info = new Label("Select currencies and amount to convert.");
        Label toLabel = new Label("To");
        Label fromLabel = new Label("From");
        Label amountLabel = new Label("Amount");
        Label resultLabel = new Label("Result:");
        Button convButton = new Button("Convert");
        Button infoButton = new Button("Info");
        Button updateButton = new Button("Update rates");
        Label result = this.result;
        
        Dialog<String> infoDialog = new Dialog<>();
        ButtonType okButton = new ButtonType("OK", ButtonData.OK_DONE);
        infoDialog.getDialogPane().getButtonTypes().add(okButton);
        infoDialog.setTitle("Info");
        infoDialog.setContentText("This application uses data from the Polish national bank API.\n" +
                                    "The rates are updated daily at 11:45 CET.\n" +
                                    "The application will automatically update the rates\n" +
                                    "when it is launched for the first time.\n" +
                                    "If you want to update the rates manually, click the\n" +
                                    "Update rates button.\n" +
                                    "The application will save the rates in a CSV file\n" +
                                    "in the same directory as the JAR file.\n" +
                                    "The application will use the CSV file if the API\n" +
                                    "is unavailable.\n");

        Dialog<String> updateDialog = new Dialog<>();
        updateDialog.getDialogPane().getButtonTypes().add(okButton);
        updateDialog.setTitle("Update rates");

        pane.add(info, 1, 0);
        pane.add(amount, 1, 2);
        pane.add(toLabel, 2, 1);
        pane.add(fromLabel, 0, 1);
        pane.add(amountLabel, 1, 1);
        pane.add(from, 0, 2);
        pane.add(to, 2, 2);
        pane.add(convButton, 1, 3);
        pane.add(resultPane, 1, 4);
        pane.add(infoButton, 0, 4);
        pane.add(updateButton, 2, 4);


        resultPane.getChildren().add(resultLabel);
        resultPane.getChildren().add(result);
        resultPane.setPadding(new Insets(0, 5, 0, 5));
        resultPane.setAlignment(Pos.CENTER);

        pane.setMinSize(400, 200);
        pane.setVgap(10);
        pane.setHgap(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setGridLinesVisible(false);
        pane.setAlignment(Pos.CENTER);

        // Event handlers
        convButton.setOnAction((event) -> {
            controller.convert(to.getValue(), amount.getValue(), from.getValue());
        });

        infoButton.setOnAction((event) -> {
            infoDialog.showAndWait();
        });

        updateButton.setOnAction((event) -> {
            updateStatus = controller.updateRates();
            updateDialog.setContentText(updateStatus);
            updateDialog.showAndWait();
        });

        Scene view = new Scene(pane);
        view.getStylesheets().add("style.css");
        window.setTitle("Currency converter");
        window.setScene(view);
        window.show();
    }

    public void init() {
        // Initialize controller
        controller = new ConvController(this);
        currencies = FXCollections.observableArrayList(controller.getCurrencies());
        from = new ComboBox<String>(currencies);
        to = new ComboBox<String>(currencies);
        amount.setEditable(true);
    }

    public void updateResult(double result) {
        this.result.setText(String.valueOf(result));
    }
}

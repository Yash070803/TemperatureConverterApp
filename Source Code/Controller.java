import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;
    @FXML
    public TextField userInputField;
    @FXML
    public Button convertButton;
    private static final String C_TO_F = "Celsius to Fahrenheit";
    private static final String F_TO_C = "Fahrenheit to Celsius";

    private boolean isC_TO_F = true;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox.getItems().add(C_TO_F);
        choiceBox.getItems().add(F_TO_C);

        choiceBox.setValue(C_TO_F); //TO set a default value

        choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {
            //System.out.println(t1); //Tracking which label is selected.
            if(t1.equals(C_TO_F)){ //If user has selected "Celsius to Fahrenheit"
                isC_TO_F=true;
            } else{
                isC_TO_F=false; //Else user has selected "Fahrenheit to Celsius"
            }
        });
        convertButton.setOnAction(actionEvent -> {
            convertTo();
        });


    }

    private void convertTo() {
        String input = userInputField.getText();
        float enteredTemp =0.0f;
        try{
             enteredTemp= Float.parseFloat(input);
        } catch(Exception e){
            warnUser();
            return; //no code is executed
        }
        float newTemp= 0.0f;
        if(isC_TO_F){
            newTemp = (enteredTemp*9/5)+32;
        } else {
            newTemp = (enteredTemp-32)*5/9;
        }
        display(newTemp);
    }

    private void warnUser() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Occurred");
        alert.setHeaderText("Invalid Temperature Entered");
        alert.setContentText("Please enter a valid temperature");
        alert.show();
    }

    private void display(float newTemp){
        String unit = isC_TO_F?"F":"C";
        System.out.println("The temperature is: "+ newTemp+" "+unit);

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Result");
        alert.setContentText("The temperature is: "+ newTemp+" "+unit);
        alert.show();
    }
}

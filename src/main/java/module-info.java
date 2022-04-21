module com.example.buttonsquare {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buttonsquare to javafx.fxml;
    exports com.example.buttonsquare;
}
module com.brianmanesis.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.brianmanesis.tictactoe to javafx.fxml;
    exports com.brianmanesis.tictactoe;
}
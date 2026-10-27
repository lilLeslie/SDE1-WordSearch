module dk.sea.wordsearch {
    requires javafx.controls;
    requires javafx.fxml;


    opens dk.sea.wordsearch to javafx.fxml;
    exports dk.sea.wordsearch;
}
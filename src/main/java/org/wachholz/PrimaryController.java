package org.wachholz;

import java.io.IOException;
import javafx.fxml.FXML;

public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        /*App.setRoot("secondary");*/
        App.setRoot("ProgrammingCalc");
    }
}

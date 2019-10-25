import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
    public class Controller {

        @FXML
        Button indexBtn;

        @FXML
        Button refreshBtn;

        @FXML
        Button addBtn;

        @FXML
        Button deleteBtn;

        @FXML
        Button searchBtn;

        @FXML
        TextField inputField;

        @FXML
        ListView textPane;

        @FXML
        ListView namePane;

        @FXML
        ListView sizePane;

        @FXML
        ListView datePane;

        @FXML
        ListView libraryListView;


        @FXML
        TableView<Documents> resultsTable;

    }

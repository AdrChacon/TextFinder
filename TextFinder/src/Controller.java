import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;

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

    //tabla
    @FXML
    TableColumn textColumn;
    @FXML
    TableColumn nameColumn;
    @FXML
    TableColumn sizeColumn;
    @FXML
    TableColumn dateColumn;

    //ordenamiento
    @FXML
    Button textUpBtn;
    @FXML
    Button textDownBtn;
    @FXML
    Button nameUpBtn;

    @FXML
    Button sizeUpBtn;
    @FXML
    Button sizeDownBtn;
    @FXML
    Button dateUpBtn;
    @FXML
    Button dateDownBtn;

    @FXML
    AnchorPane searchPane;

    @FXML
    VBox libraryPane;

    Searcher searcher;

    File[] documentsOnSearchPane;

    ArrayList<File> documents;

    ArrayList<String[][]> contents;

    DocumentsDoublyLinkedList dl = new DocumentsDoublyLinkedList();

    public Controller(){}
}

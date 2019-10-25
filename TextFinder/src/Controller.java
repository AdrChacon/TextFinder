import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.net.MalformedURLException;
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

    @FXML
    public void initialize(){
        documents = new ArrayList<>();
        addBtn.setOnMouseClicked(this::ButtonPlusAction);
        deleteBtn.setOnMouseClicked(this::ButtonMinus);
        indexBtn.setOnMouseClicked(this::ButtonIndex);
        searchBtn.setOnMouseClicked(this::ButtonSearch);
        namePane.setOnMouseClicked(this::ListViewClic);

        nameUpBtn.setOnMouseClicked(this::buttonNameUp);
        //nameDownBtn.setOnMouseClicked(this::buttonNameDown);

        dateUpBtn.setOnMouseClicked(this::buttonDateUp);
        dateDownBtn.setOnMouseClicked(this::buttonDateDown);

        searcher=new Searcher(this);
        inputField.setPromptText("Insert a word or phrase");
        //deleteBtn.setGraphic(new ImageView(new Image("imgs/icon1.png")));
        textColumn.setResizable(false);
        nameColumn.setResizable(false);
        sizeColumn.setResizable(false);
        dateColumn.setResizable(false);
    }

    public void updateSearchPane(ArrayList<File> documents,String[] text, String[] names, String[] dates, String [] sizes) {
        this.clearSearchPane();
        this.documentsOnSearchPane = documents.toArray(new File[documents.size()]);
        for (int i = 0; i < text.length; i++) {
            try {
                dl.addLast(new Documents(text[i], names[i], sizes[i], dates[i].substring(0, 10)));
            } catch (MalformedURLException e) {
                AlertBoxes.displayAlertBox("Exception", "An error occurred with the file");
            }
            this.updateResultTable();
        }

        //reinicio de panel
        private void clearSearchPane () {
            textPane.getItems().clear();
            namePane.getItems().clear();
            datePane.getItems().clear();
            sizePane.getItems().clear();
        }
    }
}

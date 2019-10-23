package interfaz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import logica.Documento;

public class ScreenController {

    
    private TableColumn<Documento, Double> sizeColumn;
    private MenuItem importFilesMenuItem;
    private MenuItem sizeSort;
    private TextField searchField;
    private MenuItem dateSort;
    private TableView<Documento> libraryTable;
    private TableColumn<?, ?> dateColumn;
    private MenuItem nameSort;
    private Button textFindButton;
    private TableColumn<Documento, String> fileNameColumn;


}

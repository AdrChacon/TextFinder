package interfaz;

import java.util.ArrayList;

import estructuras.BinaryTree;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import logica.Documento;

public class ScreenController {

	@FXML
	private TableColumn<Documento, Double> sizeColumn;

	@FXML
	private MenuItem importFilesMenuItem;

	@FXML
	private MenuItem sizeSort;

	@FXML
	private TextField searchField;

	@FXML
	private MenuItem dateSort;

	@FXML
	private TableView<Documento> libraryTable;

	@FXML
	private TableColumn<?, ?> dateColumn;

	@FXML
	private MenuItem nameSort;

	@FXML
	private Button textFindButton;

	@FXML
	private TableColumn<Documento, String> fileNameColumn;

	private ArrayList filesList;
	private BinaryTree wordTree;

	public void initialize() {
		
	}
	
	@FXML
	public void importFiles() {
		

	}

	@FXML
	public void sortBySize() {

	}

	@FXML
	public void sortByName() {

	}

	@FXML
	public void sortByDate() {

	}

}

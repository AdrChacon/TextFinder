package interfaz;

import java.awt.Desktop;
import java.io.File;
import java.util.ArrayList;

import estructuras.BinaryTree;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import logica.Biblioteca;
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

	private Biblioteca library = Biblioteca.getInstance();
	private BinaryTree wordTree;

	public void initialize() {
		System.out.println("Good morning, Vault Tec calling!");
		populateColumns();
	}
	
	private void populateColumns() {
		ObservableList<Documento> oList = getOList();
		fileNameColumn.setCellValueFactory(new PropertyValueFactory<>("fileName"));;
		sizeColumn.setCellValueFactory(new PropertyValueFactory<>("fileSize"));
		libraryTable.setItems(oList);
	}
	private ObservableList<Documento> getOList(){
		ObservableList<Documento> oList = FXCollections.observableArrayList();
		library.getfileList().forEach(documento -> oList.add(documento));
		return oList;
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
	
	@FXML
	public void openSelectedFile() throws Exception{
		File doc = new File(libraryTable.getSelectionModel().getSelectedItem().getPath().toString());
		Desktop.getDesktop().open(doc);
	}
	

}

package logica;

import java.io.File;
import java.text.Normalizer;
import java.util.ArrayList;

import estructuras.BinaryTree;

public class Biblioteca {
	
	private static Biblioteca instance = new Biblioteca();
	private ArrayList<Documento> fileList;
	private BinaryTree wordTree;
	
	public static Biblioteca getInstance() {
		return instance;
	}
	
	private Biblioteca() {
		wordTree = new BinaryTree();
		fileList = new ArrayList<Documento>();
		this.startUp();
	}
	
	public ArrayList<Documento> getfileList() {
		return this.fileList;
	}
	public BinaryTree getWordTree() {
		return this.wordTree;
	}
	
	public void getFiles() {
		
	}
	
	private void startUp() {
		listFilesForFolder();
		fileList.forEach(c -> populateTree(c));
	}
	private void populateTree(Documento doc) {
		String documentText = doc.getContent();
		documentText = Normalizer.normalize(documentText, Normalizer.Form.NFD);
		documentText = documentText.replaceAll("\n| +", " ").replaceAll("[^a-zA-Z ]", "").toLowerCase();
		String[] splitText = documentText.split(" ");
		System.out.println(documentText);
		for (int i = 0; i < splitText.length; i++) {
			wordTree.insert(splitText[i]);
		}
	}
	private void listFilesForFolder() {
		File folder = new File("src/documentos");
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            addFileToList(fileEntry);
	            System.out.println(fileEntry.getPath());
	        }
	    }
	}
	private void listFilesForFolder(File folder) {
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	        	addFileToList(fileEntry);
	            System.out.println(fileEntry.getPath());
	        }
	    }
	}
	
	private void addFileToList(File file) {
		String type = getFileType(file.getName());
		if (type.equals("txt")) {
			Documento doc = new TxtDoc(file.getPath());
			fileList.add(doc);
		} else if (type.equals("pdf")) {
			Documento doc = new PdfDoc(file.getPath());
			fileList.add(doc);
		} else {
			System.out.println("File type not supported");
		}
	}

	private String getFileType(String fileName) {
		int dotIndex = fileName.lastIndexOf('.');
		return (dotIndex == -1) ? "" : fileName.substring(dotIndex + 1);
	}
	public static void main(String[] args) {
		Biblioteca library = Biblioteca.getInstance();
		
	}
}

package logica;

import java.util.ArrayList;

public class Biblioteca {
	
	private static Biblioteca instance = new Biblioteca();
	private ArrayList fileList;
	
	public Biblioteca getInstance() {
		return instance;
	}
	
	private Biblioteca() {
		fileList = new ArrayList();
		this.getFiles();
	}
	
	public void getFiles() {
	}
}

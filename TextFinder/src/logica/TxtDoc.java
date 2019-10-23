package logica;


import java.nio.file.Path;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TxtDoc extends Documento {

	public TxtDoc(String path) {
		super(Paths.get(path));
		readDocument();
	}
	
	public void readDocument() {
		try {
		this.content = Files.readString(this.path);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

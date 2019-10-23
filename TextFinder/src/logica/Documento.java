package logica;

import java.nio.file.Path;
import java.io.File;

public abstract class Documento {
	protected String fileName;
	protected Path path;
	protected String content;
	private File file;
	protected double fileSize;
	
	public Documento(Path filePath) {
		this.path = filePath;
		file = new File(this.path.toString());
		this.fileName = path.getFileName().toString();
		this.fileSize = this.megabyteSize();
	}
	
	public double megabyteSize() {
		return ((this.file.length()/1024)/1024);
		
	}
	
	public abstract void readDocument();
	
	public String getContent() {
		return this.content;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

}
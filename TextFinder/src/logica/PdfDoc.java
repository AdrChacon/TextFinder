package logica;

import java.io.File;
import java.nio.file.Paths;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

public class PdfDoc extends Documento{
	
	public PdfDoc(String path) {
		super(Paths.get(path));
		readDocument();
	}
	
	/**
	 * Lectura de archivos pdf. Este código fue tomado de: https://www.mkyong.com/java/pdfbox-how-to-read-pdf-file-in-java/
	 */
	public void readDocument() {
		try (PDDocument doc = PDDocument.load(new File(this.path.toString()))) {
			PDFTextStripperByArea stripper = new PDFTextStripperByArea();
			stripper.setSortByPosition(true);

			PDFTextStripper tStripper = new PDFTextStripper();

			this.content = tStripper.getText(doc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

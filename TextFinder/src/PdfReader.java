import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.io.File;
import java.io.IOException;

/**
 * Esta clase permite leer el contenido de archivos de formato .pdf
 *
 */
public class PdfReader {

	/**
	 * Retorna un String[] con el texto extra�do del documento .pdf
	 * @param path
	 * @return String[] texto
	 * @throws IOException
	 */
    public static String[] pdfReader (String path) throws IOException {
        PDDocument document = PDDocument.load(new File(path));
        if (!document.isEncrypted()) {
            PDFTextStripperByArea stripper = new PDFTextStripperByArea();
            stripper.setSortByPosition(true);
            PDFTextStripper tStripper = new PDFTextStripper();
            String pdfFileInText = tStripper.getText(document);
            String[] lines = pdfFileInText.split("\\r?\\n");
            return lines;
        }
        return null;
    }
}

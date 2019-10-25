import java.io.File;
import java.io.IOException;

public class PdfReader {

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

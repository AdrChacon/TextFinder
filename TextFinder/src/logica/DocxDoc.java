package logica;

import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Paths;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;

public class DocxDoc extends Documento{

	public DocxDoc(String path) {
		super(Paths.get(path));
		readDocument();
	}
	
	public void readDocument() {
		try {
			File file = new File(this.path.toString());
			FileInputStream fis = new FileInputStream(file.getAbsolutePath());
			XWPFDocument doc = new XWPFDocument(fis);
			List<XWPFParagraph> paragraphs = doc.getParagraphs();
			String docText = "";
			for(XWPFParagraph para : paragraphs) {
				docText += para.getText() + "\n";
			}
			this.content = docText;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

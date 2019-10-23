package estructuras;

import  java.nio.file.Path;
import java.nio.file.Paths;
import java.text.Normalizer;
import logica.PdfDoc;
import logica.TxtDoc;

public class MainForTests {
	public static void main (String[] args) {
		BinaryTree tree = new BinaryTree();
		
		String path = "src/documentos/helloworld.txt";
		String path2 = "src/documentos/TareaConflictos.pdf";
		
		
		PdfDoc tareaconflictos = new PdfDoc(path2);
		TxtDoc helloWorld = new TxtDoc(path);
		
		
		System.out.println(tareaconflictos.getContent());
		System.out.print(helloWorld.getContent());
		String data = helloWorld.getContent().replaceAll("\n| +", " ").replaceAll("[^a-zA-Z ]", "").toLowerCase();
		String data2 = tareaconflictos.getContent();
		data2 = Normalizer.normalize(data2, Normalizer.Form.NFD);
		System.out.println(data2);
		data2 = data2.replaceAll("[^a-zA-Z ]", "").replaceAll("\n| +", " ").toLowerCase();
		System.out.println(data + "\n");
		System.out.println(data2 + "\n");
		String[] split = data.split(" ");
		String[] split2 = data2.split(" ");		
		for (int i = 0; i < split.length; i++) {
			tree.insert(split[i]);
		}
		for (int i = 0; i< split2.length; i++) {
			tree.insert(split2[i]);
		}
		
		System.out.println("Success:     " + tree.contains("Success"));
		System.out.println("world:       " + tree.contains("world"));
		System.out.println("revoir:      " + tree.contains("revoir"));
		System.out.println("Hello:       " + tree.contains("Hello"));
		System.out.println("example      " + tree.contains("example"));
		System.out.println("finalmente:  " + tree.contains("finalmente"));
		System.out.println("tambien:     " + tree.contains("tambien"));
		System.out.println("raices:      " + tree.contains("raices"));
		System.out.println("ejemplo:     " + tree.contains("ejemplo"));
		System.out.println("el:          " + tree.contains("el"));
		System.out.println("ella:        " + tree.contains("ella"));
		System.out.println("txt:         " + tree.contains("txt"));
		System.out.println("helloworld.txt size: " + helloWorld.getFileSize());
			
	}
}

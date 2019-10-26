import java.io.File;

/**
 * Esta clase corresponde a una implementaci�n de un arbol binario de b�squeda
 *
 */
public class Tree {

	/**
	 * Ra�z del arbol
	 */
    private Node root= null;
    /**
     * Instancia del �rbol (Singleton)
     */
    private static Tree instance;

    /**
     * Elimina el contenido del �rbol
     */
    public void clear(){
        this.root=null;
    }

    /**
     * A�ade una palabra al �rbol
     * @param word
     * @param document
     * @param lineNumber
     * @param linePos
     */
    public void add(String word,File document, int lineNumber, int linePos){
        root=this.add(word, document,  lineNumber,  linePos, this.root);
    }

    /**
     * A�ade una palabra al �rbol
     * @param word
     * @param document
     * @param lineNumber
     * @param linePos
     * @param current
     * @return
     */
    private Node add(String word, File document, int lineNumber, int linePos, Node current){
        if(current==null){
            Node node= new Node(word);
            this.addOcurrence(node.getWordOcurrences(),document,lineNumber,linePos);
            return node;
        }else if(current.getWord().equals(word)){
            this.addOcurrence(current.getWordOcurrences(),document,lineNumber,linePos);
        }else if(current.getWord().compareTo(word)>0){
            current.setLeft(this.add(word, document,  lineNumber,  linePos, current.getLeft()));
        }else{
            current.setRigth(this.add(word, document,  lineNumber,  linePos, current.getRigth()));
        }
        return current;

    }

    /**
     * A�ade una ocurrencia a la palabra, en caso de que la palabra ya exista en el �rbol
     * @param wordOcurrences
     * @param document
     * @param lineNumber
     * @param linePos
     */
    private void addOcurrence(WordOcurrences wordOcurrences, File document, int lineNumber, int linePos){
        wordOcurrences.getDocuments().add(document);
        wordOcurrences.getLineNumber().add(lineNumber);
        wordOcurrences.getLinePos().add(linePos);
    }

    /**
     * Obtiene las instancias de una palabra
     * @param word
     * @return
     */
    public WordOcurrences getOcurrences(String word){
        return this.getOcurrences(word, root);
    }

    /**
     * Obtiene las instancias de una palabra
     * @param word
     * @param root
     * @return
     */
    private WordOcurrences getOcurrences(String word, Node root){
        if(root==null){
            return null;
        }else if(root.getWord().equals(word)){
            return root.getWordOcurrences();
        }else if(root.getWord().compareTo(word)>0){
            return this.getOcurrences(word, root.getLeft());
        }else{
            return this.getOcurrences(word, root.getRigth());
        }
    }

    /**
     * Retorna la �nica instancia posible de la clase (Singleton)
     * @return
     */
    public static Tree getInstance(){
        if(instance==null){
            instance=new Tree();
        }
        return instance;
    }
}

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;


public class Searcher {

    Tree tree;

    Controller controller;

    public Searcher(Controller controller){
        this.tree=Tree.getInstance();
        this.controller=controller;
    }

    public void search(String phrase){
        String[] splitPhrase = this.decomposePhrase(phrase);
        if(splitPhrase.length>=1){

            WordOcurrences wordOcurrences= this.searchWord(splitPhrase[0]);
            if( wordOcurrences!= null) {
                wordOcurrences = this.getRealOcurrences(wordOcurrences, splitPhrase);

                String[] context = this.getContext(wordOcurrences);
                String[] names = this.getNames(wordOcurrences.getDocuments());

                String[] dates;
                try {
                    dates = this.getDates(wordOcurrences.getDocuments());
                } catch (IOException e) {
                    dates = null;
                }

                String[] sizes;
                try {
                    sizes = this.getSizes(wordOcurrences.getDocuments());
                } catch (IOException e) {
                    sizes = null;
                }
                controller.updateSearchPane(wordOcurrences.getDocuments(), context, names, dates, sizes);
            }else{
                AlertBoxes.displayAlertBox("Error", "No encontrado");
            }
        }else{
            AlertBoxes.displayAlertBox("Error", "No se ingreso palabras");
        }
    }

    private String[] getNames(ArrayList<File> documents){
        String[] names = new String[documents.size()];
        for (int i = 0; i<documents.size();i++){
            names[i]=documents.get(i).getName();
        }
        return names;
    }

    private String[] getSizes(ArrayList<File> documents) throws IOException {
        String[] sizes = new String[documents.size()];
        for (int i = 0; i<documents.size();i++){
            sizes[i]= documents.get(i).length() +" bytes";
        }
        return sizes;
    }

    private String[] getDates(ArrayList<File> documents) throws IOException {
        String[] dates = new String[documents.size()];
        for (int i = 0; i<documents.size();i++){
            dates[i]= Files.readAttributes(documents.get(i).toPath(), BasicFileAttributes.class).creationTime().toString();
        }
        return dates;
    }

    private WordOcurrences searchWord(String word){
        WordOcurrences ocurrenceList= this.tree.getOcurrences(word);
        return ocurrenceList;
    }

    public WordOcurrences getRealOcurrences(WordOcurrences wordOcurrences, String[] phrase){
        int size = wordOcurrences.getDocuments().size();
        File document;
        int lineNumber;
        int linePos;
        boolean error=false;

        ArrayList<File> finalDocs = new ArrayList<>();
        ArrayList<Integer> finalLineNumber = new ArrayList<>();
        ArrayList<Integer>  finalLinePos = new ArrayList<>();

        for(int i = 0; i < size; i++){
            document = wordOcurrences.getDocuments().get(i);
            String[][] content =this.getContent(document);
            lineNumber=wordOcurrences.getLineNumber().get(i);
            linePos=wordOcurrences.getLinePos().get(i);

            int index1= lineNumber;
            int index2= linePos;
            for(int j=0;j<phrase.length;j++){
                try {
                    error= !content[index1][index2].equals(phrase[j]);
                    if (error){
                        break;
                    }
                    index2++;
                }catch (IndexOutOfBoundsException e){
                    index1++;
                    if(index1<content.length) {

                        index2 = 0;
                        j--;
                    }else{
                        error=true;
                        break;
                    }
                }
            }

            if(!error){
                finalDocs.add(document);
                finalLineNumber.add(lineNumber);
                finalLinePos.add(linePos);
            }
        }

        WordOcurrences result=new WordOcurrences();
        result.setDocuments(finalDocs);
        result.setLineNumber(finalLineNumber);
        result.setLinePos(finalLinePos);
        return result;
    }

    protected String[] getContext(WordOcurrences wordOcurrences){
        int size = wordOcurrences.getDocuments().size();
        String[] contexts= new String[size];
        for(int i=0;i<size;i++){
            contexts[i]=this.getContext(wordOcurrences.getDocuments().get(i),wordOcurrences.getLineNumber().get(i),wordOcurrences.getLinePos().get(i));
        }
        return contexts;
    }

    private String[][] getContent(File document){
        int index= controller.getDocuments().indexOf(document);
        String[][] content = controller.getContents().get(index);
        return content;
    }

    private String getContext(File document, int lineNumber, int linePos){
        String[][] content =this.getContent(document);
        String context="...";

        for(int j=linePos-5;j<linePos+5;j++){
            try {


                if (content[lineNumber][j] != null) {
                    context += content[lineNumber][j]+" ";
                }
            }catch (IndexOutOfBoundsException e){

            }
        }

        return context+"...";
    }

    private String[] decomposePhrase(String phrase){
        String[] split=phrase.split(" ");
        ArrayList<String> noSpacesSplit=new ArrayList<>();
        for(String word: split){
            if(!word.equals("")){
                noSpacesSplit.add(word);
            }
        }
        split= noSpacesSplit.toArray(split);
        return split;
    }
}
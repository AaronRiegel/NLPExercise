import java.util.*;
import java.io.*;



public class Main {

    /*
    Word: strings separated by spaces
    Sentence: sequence of tokens which ends with a ".", "?", or "!" followed by a space OR sequence of tokens
    which ends with a ".", "?", or "!" followed by a "\"" and a space
    Paragraph: if the line is blank
     */


    public static void main(String args[] ){

        Scanner in = new Scanner(System.in);
        System.out.print("Input path to file: ");
        String path = in.nextLine();
        File file = new File(path);

        try{
            FileInputStream fileStream = new FileInputStream(file);
            InputStreamReader input = new InputStreamReader(fileStream);
            BufferedReader reader = new BufferedReader(input);

            count(reader);



        }
        catch(FileNotFoundException e) {
            System.out.println("Error: Location: " + path + " does not exist.");
        }

        catch(Exception e){
            System.out.println("Error occurred.");
        }

    }


    private static void count(BufferedReader reader) throws IOException {
        String line;
        List<String> wordList = new ArrayList<>();
        List<String> sentenceList = new ArrayList<>();


        int paragraphCount = 1;

        while((line = reader.readLine()) != null) {

            if(line.equals(""))
                paragraphCount++;

            else {

                String[] words = line.split("\\s+");
                wordList.addAll(Arrays.asList(words));

                String[] sentences = line.split("[.?!]+ |[.?!]+[\"] ");
                sentenceList.addAll(Arrays.asList(sentences));

            }
        }


        System.out.println("Word Count: " + wordList.size());
        System.out.println("Sentence Count: " +sentenceList.size());
        System.out.println("Paragraph Count: " + paragraphCount);
    }


}

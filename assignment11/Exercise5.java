import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Scanner;

public class Exercise5 {
    public static void main(String[] args) {
        
        // create scanner object
        Scanner input = new Scanner(System.in);
        System.out.print("Enter file name: ");
        String file = input.nextLine();

        input.close(); // close scanner
        // object to create new files
        File testFile = new File(file);
        int i; // use to read file character by character

        // hashmap to map every alphabet and its count
        HashMap<Character, Integer> letters = new HashMap<>();

        // map every single alpahabet into the hashmap
        for(int ascii = 97; ascii < 123; ascii++){
            letters.put((char) ascii, 0);
        }

        try {
            // create file
            testFile.createNewFile();

            // create object to write file
            FileWriter writer = new FileWriter(file);

            // write to file
            writer.write("Hello, How Are You?\nHi!");

            writer.close(); // close writer

            // create an object reader
            FileReader reader = new FileReader(file);

            // read file character by character
            while((i = reader.read()) != -1){
                // convert each character to lowercase  
                char character = Character.toLowerCase((char) i);
                // check if its a letter and count it 1 by 1 in hashmap
                if(Character.isLetter(character)){
                    letters.put(character, letters.get(character) + 1);
                }
            }

            // loop through the hashmap and print every characters and its count
            for(int ascii = 97; ascii < 123; ascii++){
                int count = letters.get((char)ascii);
                System.out.print("Numbers of " + (char) ascii + ": " + count + "\n");
            }
            // closes the reader
            reader.close();    
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

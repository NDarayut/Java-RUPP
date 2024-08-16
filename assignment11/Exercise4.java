import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class Exercise4 {
    public static void main(String[] args) {
        // object to create new files
        File file = new File("Scores.txt");
        String line; // string to store line that is read from files
        String[] scores = null; // Array to store a string of scores
        int total = 0; 
        int nScores = 0; // variable to keep tracks of n of score

        try {
            // create file
            file.createNewFile();

            // create object to read and write file
            FileWriter writer = new FileWriter("Scores.txt");
            BufferedReader reader = new BufferedReader(new FileReader("Scores.txt"));
           
            // write to file
            writer.write("100 90 50 69 25 89 \n100 90 20 11");

            writer.close(); // close writer

            // read line by line and separate by space
            while((line = reader.readLine()) != null){
                scores = line.split(" ");
                // each line gets converted to int and added to total
                for(String number : scores){
                    total += Integer.parseInt(number);
                    nScores++;
                }
            }
            
            System.out.println("Total: " + total);
            System.out.println("Average: " + (double)total/nScores);

           
            reader.close(); // close reader
        } 
        catch (Exception e) {
            System.out.println(e);
        }
    }
}

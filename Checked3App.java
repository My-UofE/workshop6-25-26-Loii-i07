// import libraries from io (input/output)
// package to handle file streams
import java.io.*;

public class Checked3App {
    public static void main(String[] args) {
        System.out.println("### Enter main() ...");

        if (args.length > 0) {
            readTxtFile(args[0]);
        }
        
        System.out.println("### Exit main()!");
    }

    public static void readTxtFile(String fileName) {
        System.out.println("### Enter readTxtFile() ...");
        try {
            // open a file for reading and pass to a buffer 
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            
            // define a variable which will store the lines as we load them
            String line;
        
            // loop to read and print lines until file end
            line = String.format("Contents of '%s'", fileName);
            while(line != null) {
                System.out.println(line);
                line = bufferedReader.readLine();
            } 
            
            // close buffer/file io stream
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("### FileNotFoundException caught"); 
            System.out.println("### message: " + e.getMessage()); 
        } catch (IOException e) {
            System.out.println("### IOException caught"); 
            System.out.println("### message: " + e.getMessage()); 
        }

        System.out.println("### Exit readTxtFile()!");
    }
}
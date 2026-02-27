// import libraries from io (input/output)
// package to handle file streams
import java.io.*;

public class Checked2App{
    public static void main(String[] args)  {
        System.out.println("### Enter main() ...");

        if (args.length == 0) return;

        try {
            readTxtFile(args[0]);
        } catch (FileNotFoundException e) {
            System.out.println("### Error: File not found - " + e.getMessage()); 
        } catch (IOException e) {
            System.out.println("### Error: Reading failed - " + e.getMessage()); 
        }
        System.out.println("### Exit main()!");
    }

       
        public static void readTxtFile(String fileName) throws IOException  {
        System.out.println("### Enter readTxtFile() ...");
    
        // open a file for reading and pass to a buffer 
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
        
        // define a variable which will store the lines as we load them
        String line;
    
        // loop to read and print lines until file end
        line = String.format("Contents of '%s'", fileName);
        while(line!=null) {
            System.out.println(line);
            line = bufferedReader.readLine();
        } 
        
        // close buffer/file io stream
        bufferedReader.close();
        System.out.println("### Exit readTxtFile()!");

    }
}
/*
 * This was going to be a helper class to easily read text from a text file 
 * This class may just go into the bin because we can alternatively hard code the 
 * Script 
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScriptReader {
    BufferedReader reader;

    public ScriptReader(){

    }

    //reads a scriptFile
    public String readScript(String fileLocation){
        try{
            reader = new BufferedReader(new FileReader(fileLocation));
            StringBuilder sb = new StringBuilder();
            int next; 
            while((next = reader.read())!=-1){
                sb.append((char)next);
            }
            reader.close();
            return sb.toString();
        } catch(IOException e){
            System.out.println(e);
            return "Error unable to read script file";
        }
    }
}

// Get an input from the user using DataInputStream and print the same.

import java.io.IOException;
import java.io.DataInputStream;

public class DataInputStreamRead {
    public static void main(String[] args){
        DataInputStream dataInputStream=new DataInputStream(System.in);
        try{
            System.out.print("Enter something : ");
            String userInput = dataInputStream.readLine();
            System.out.println("You Entered : "+userInput);
        }
        catch(IOException e){
            System.out.println("Error reading input: " + e.getMessage());
        } 
        finally {
            try {
                dataInputStream.close();
            } 
            catch (IOException e){
                System.out.println("Error closing DataInputStream: " + e.getMessage());
            }
        }
    }
    
}


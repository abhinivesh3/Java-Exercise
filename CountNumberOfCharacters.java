//Write a program to count the numbers of characters entered through stdin. The program exits upon entering Ctrl+Z
//in mac ctrl+D
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountNumberOfCharacters{
    public static void main(String[] arg){
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(inputStreamReader);
        int count = 0;
        try{
            int character;
            while((character=reader.read())!=-1){
                count++;
            }
        }
        catch(IOException e){
            System.out.println("Error "+e);
        }
        System.out.println("Number of characters entered : "+count);
    }
}


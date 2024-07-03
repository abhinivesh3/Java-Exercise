//Write a program to accept a filename and print the contents of the file along with the line numbers. Also catch the required exceptions.

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class ReadFileWithLineNumbers {
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the file name : ");
        String fileName=scanner.next();
        FileInputStream fileInputStream=null;
        try{
            fileInputStream=new FileInputStream(fileName);
            int lineNumber=0;
            int character;
            StringBuffer line= new StringBuffer();
            System.out.println("Content of file : "+fileName);
            while(fileInputStream.available()!=0){
                character=fileInputStream.read();
                if(character=='\n'){
                    System.out.println("Line "+lineNumber+":"+line.toString());
                    line.setLength(0);
                    lineNumber++;
                }
                else{
                    line.append((char)character);
                }
            }
            if(line.length()>0){
                System.out.println("Line "+lineNumber+":"+line.toString());
            }
        }
        catch(IOException e){
            System.out.println("Error : "+e);
        }
        finally{
            try{
                if(fileInputStream!=null){
                    fileInputStream.close();
                }
            }
            catch(IOException e){
                System.out.println("Error closing Stream : "+e);
            }
        }
    }
}
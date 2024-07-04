//Write a program to perform a file copy operation using the file streams of java. Get the file names as command line parameters. Throw required errors and catch required exceptions.

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: java FileCopy <source_file> <destination_file>");
            System.exit(1);
        }

        String sourceFile = args[0];
        String destinationFile = args[1];

        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try{
            // fileInputStream=new FileInputStream("/Users/abhi-21739/Documents/programFileStream/inputFile.txt");
            // fileOutputStream=new FileOutputStream("/Users/abhi-21739/Documents/programFileStream/outputFile.txt");
            
            fileInputStream=new FileInputStream(sourceFile);
            fileOutputStream=new FileOutputStream(destinationFile);
            
            int c;
            while((c=fileInputStream.read())!=-1){
                fileOutputStream.write(c);
            }
            System.out.println("Copied the file Successfully!");
        }
        catch(IOException e){
            System.out.println("Error : "+e);
        }
        finally{
            try{
                if(fileInputStream!=null){
                    fileInputStream.close();
                }
                if(fileOutputStream!=null){
                    fileOutputStream.close();
                }
            }
            catch(IOException e){
                System.out.println("Error closing stream : "+e);
            }
        }

    }
}
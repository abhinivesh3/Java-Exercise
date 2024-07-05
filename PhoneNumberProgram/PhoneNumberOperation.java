package PhoneNumberProgram;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class PhoneNumberOperation {
    private Hashtable<String,String> phoneBook;
    private String fileName;

    public PhoneNumberOperation(String fileName) {
        this.fileName = fileName;
        phoneBook = new Hashtable<>();
        readFromFile();
    }
    
    public void addNumber(String name,String number){
        phoneBook.put(name, number);
        writeToFile();
        System.out.println(name + "'s number added successfully.");
    }
    
    public void deleteNumber(String name){
        if(phoneBook.containsKey(name)){
            phoneBook.remove(name);
            writeToFile();
            System.out.println(name + "'s number deleted successfully.");
        }
        else{
            System.out.println("No entry found for " + name);
        }
    }

    public void listAll(){
        if(phoneBook.isEmpty()){
            System.out.println("Phone book is empty.");
        }
        else{
            System.out.println("Phone Book:");
            for(Map.Entry<String,String> entry: phoneBook.entrySet()){
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
    }

    public void search(String name){
        if(phoneBook.containsKey(name)){
            System.out.println(name +": "+phoneBook.get(name));
        }
        else {
            System.out.println("No entry found for " + name);
        }
    }

    private void readFromFile(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = reader.readLine())!=null){
                String[] parts =line.split(",");
                if(parts.length==2){
                    phoneBook.put(parts[0],parts[1]);
                }
            }
        }
        catch(IOException e){
            System.out.println("Error reading from file: "+e.getMessage());
        }
    }

    private void writeToFile(){
        try{
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(fileName));
            for(Map.Entry<String,String> entry : phoneBook.entrySet()){
                bufferedWriter.write(entry.getKey()+","+entry.getValue()+"\n");
            }
        }
        catch(IOException e){
            System.out.println("Error writing to file : "+e.getMessage());
        }
    }


}

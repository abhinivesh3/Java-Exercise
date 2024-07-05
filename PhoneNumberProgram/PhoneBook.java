package PhoneNumberProgram;

import java.util.Scanner;

public class PhoneBook {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
        System.out.println("Phone Book");
        boolean flag=true;
        PhoneNumberOperation phoneNumberOperation=new PhoneNumberOperation("PhoneBook.txt");
        while(flag){
            System.out.println("1.Add Numbers\n2.Delete Numbers\n3.List all\n4.Search\n5.Exit");
            System.out.print("Enter your Choice : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Adding Phone Number : ");
                    System.out.print("Enter a name : ");
                    String name=scanner.next();
                    System.out.print("Enter the phone number : ");
                    String phoneNumber=scanner.next();
                    phoneNumberOperation.addNumber(name,phoneNumber);
                    break;
                case 2:
                    System.out.println("Delete the phone number : ");
                    System.out.print("Enter name to delete : ");
                    String delName=scanner.next();
                    phoneNumberOperation.deleteNumber(delName);
                    break;
                case 3:
                    phoneNumberOperation.listAll();
                    break;
                case 4:
                    System.out.println("Enter name to search:");
                    System.out.print("Enter name to search : ");
                    String searchName=scanner.next();
                    phoneNumberOperation.search(searchName);
                    break;
                case 5:
                    System.out.println("Exit");
                    flag=false;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
                    break;
            }

        }
    }
}

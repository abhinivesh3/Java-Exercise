package QueueFunction;

import java.util.Scanner;

public class QueueOperation {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Queue Implementation");
        boolean flag=true;
        Queue queue=new Queue();
        while(flag){
            System.out.println("1.Enqueue\n2.Dequeue\n3.List\n4.Exit");
            System.out.print("Enter your Choice : ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enqueue Operation ");
                    System.out.print("Enter the value to enqueue : ");
                    int value=scanner.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    System.out.println("Dequeue Operation ");
                    queue.dequeue();
                    break;
                case 3:
                    System.out.println("List Operation ");
                    queue.display();
                    break;
                case 4:
                    System.out.println("Exit");
                    flag=false;
                    break;
                default:
                    break;
            }

        }

    }

}


// Implement a Queue.
// [TIP] Extend Vector and add additional methods to perform enqueue and dequeue.
// Display a menu like below and allow user to perform enqueue and dequeue.
//     1.Enqueue
//     2.Dequeue
//     3.List
// Enter your Choice:

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
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
                    break;
            }

        }

    }

}


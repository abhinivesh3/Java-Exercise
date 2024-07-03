//Program to print Fibonacci series of a number using recursion. Get the number through command line argument. Throw proper errors for wrong inputs.
// 0 1 1 2 3
import java.util.Scanner;

public class Fibonacci{
    public static int fib(int n){
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
        
    }
    // static int a=0,b=1,c=0;
    // public static void fib1(int n){
    //     if(n>0){
    //         c=a+b;
    //         a=b;
    //         b=c;
    //         System.out.print(c+" ");
    //         fib1(n-1);
    //     }
    // }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the value : ");
        int n;
        try {
            n=scanner.nextInt();
            if (n < 0) {
                throw new IllegalArgumentException("Number must be non-negative.");
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid number format.");
            return;
        }
        System.out.print("Fibonacci up to "+n+" : ");
        //fib1(n);
        for(int i=0;i<=n;i++){
            System.out.print(fib(i)+" ");
        }
    }
}
// Write a simple thread to print prime numbers from 1 to 100 every one second.

class MyThread extends Thread{
    public void run(){
        for(int i=1;i<=100;i++){
            if(isPrime(i)){
                System.out.println(i+ " ");
                try{
                    Thread.sleep(1000);
                }
                catch(InterruptedException e){
                    System.out.println(e);
                }
            }
        }
    }
    public boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i=2;i*i<=n;i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    
}

public class PrimeNumberThread {
    public static void main(String[] args){
        MyThread myThread=new MyThread();
        myThread.start();
    }

    
}

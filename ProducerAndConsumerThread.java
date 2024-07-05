// Write a simple thread program that starts two threads(producer and consumer), where the producer thread enques a random number in a Queue and the consumer thread de-queues the queue and prints whether the number is prime or not.

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

class Producer extends Thread{
    private Queue<Integer> queue;
    private Random random=new Random();

    public Producer(Queue<Integer> q){
        this.queue=q;
    }

    @Override
    public void run(){
        while(true){
            synchronized(queue){
                int n=random.nextInt(100);
                queue.add(n);
                System.out.println("Producer produced: " + n);
                queue.notify();
            }
            try {
                Thread.sleep(1000); 
            } catch (InterruptedException e) {
                System.out.println("Error producer : "+e);
            }
        }
    }
}

class Consumer extends Thread{
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> q){
        this.queue=q;
    }

    @Override
    public void run(){
        while(true){
            synchronized(queue){
                while(queue.isEmpty()){
                    try{
                        queue.wait();
                    }
                    catch(InterruptedException e){
                        System.out.println(e);
                    }
                }
                int n=queue.poll();
                System.out.println("Consumer consumed: " + n);
                if(isPrime(n)){
                    System.out.println(n+ " is Prime");
                } 
                else{
                    System.out.println(n + " is Not Prime");
                }
            }
            try {
                Thread.sleep(1000);
            } 
            catch(InterruptedException e) {
                System.out.println("Error consumer : "+e);
            }
        }
    }
    private boolean isPrime(int n){
        if(n<=1){
            return false;
        }
        for(int i = 2; i*i <=n; i++){
            if (n%i == 0){
                return false;
            }
        }
        return true;
    }
}

public class ProducerAndConsumerThread {
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();

        Producer producer=new Producer(queue);
        Consumer consumer=new Consumer(queue);

        producer.start();
        consumer.start();
    }
}

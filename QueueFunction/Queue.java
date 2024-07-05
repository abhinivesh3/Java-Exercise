package QueueFunction;

public class Queue {
    int size=5;
    int front=-1;
    int rear=-1;
    int[] items=new int[size];

    boolean isFull(){
        if(rear==size-1){
            return true;
        }
        return false;
    }

    boolean isEmpty(){
        if(front==-1 && rear==-1){
            return true;
        }
        return false;
    }

    void enqueue(int value){
        if(isFull()){
            System.out.println("Queue is Full");
        }
        else if(front==-1 || rear==-1){
            front=rear=0;
            items[rear]=value;
        }
        else{
            rear++;
            items[rear]=value;
        }
    }

    void dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
        }
        else if(front==rear){
            front=rear=-1;
        }
        else{
            front++;
        }
    }

    void display(){
        System.out.println("Items present in Queue :");
        for(int i=front;i<=rear;i++){
            System.out.print(items[i]+" ");
        }
    }
    
}


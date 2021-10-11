import java.util.*;


class queue{
    private static Scanner scan = new Scanner(System.in);
    private static node front;
    private static node rear;

    private static class node{
        private node next;
        private int data;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private static void enqueue() {
        System.out.println("Enter the data to insert : ");
        int data = scan.nextInt();
        node temp = new node(data);
        if(front == null){
            front = temp;
        }else{
            rear.next = temp;
        }
        rear = temp;
        System.out.println("Successfully inserted !!");
    }
    private static void deque(){
        if(front == null){
            System.out.println("empty");
            rear = null;
            return;
        }else{
            System.out.println("Element removed is : "+front.data);
            front = front.next;
        }        
        
    }
    private static void print(){
        node current = front;
        while(current != null){
            System.out.print(current.data+"=>");
            current = current.next;
        }
        System.out.print("null");
    }
    private void frontelement(){
        if(front != null){
            System.out.println("front element is : "+front.data);
            return;
        }
        System.out.println("empty");
       
    }

    private void rearelement(){
        if(rear != null){
            System.out.println("rear element is : "+rear.data);
            return;
        }
        System.out.println("empty");
       
    }
    public static void main(String[] args) {
        queue q = new queue();
        while(true){
            System.out.println("\n1. Enqueue \n2. Dequeue \n3. print \n4. front element \n5. rear element \n6. break ");
        int n = scan.nextInt();
        switch(n){
            case 1:
                q.enqueue();
                break;
            case 2:
                q.deque();
                break;
            case 3:
                q.print();
                break;
            case 4:
                q.frontelement();
                break;
            case 5:
                q.rearelement();
                break;
            case 6:
                System.exit(0);
        }
        }
        
    }

   
}
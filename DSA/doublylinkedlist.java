
import java.util.*;

//import introduction.staticinit;

public class doublylinkedlist {

    // -----------creation of node-------------------
    private node head; 
    private int length = 0;      
    private static Scanner scan = new Scanner(System.in);

    private static class node{
        private int data;
        private node next;
        private node previous;

        public node(int data){
            this.data = data;           
        }
    }
  

//----------End of node creation and we create simple constructor to assign the head and tail at null at start
 
    
    public void display(){
        node current = head;       
        while(current != null){
            System.out.print(current.data+"=>");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();
    }
    public void displaylast(){
        node current = head;
        while(current.next != null){
            current = current.next;
        }
        System.out.println("Displaying from last");
        while(current != null){
            System.out.print(current.data+"=>");
            current = current.previous;
        }
        System.out.print("null");
        System.out.println();
    }
    public void insertfirst(){
        if(head ==  null){
            System.out.println("Empty List");
            return;
        }
        System.out.println("Enter the data to insert at first: ");
        int data = scan.nextInt();
        node newnode = new node(data);
        head.previous = newnode;
        newnode.next = head;
        head = newnode;       
    }
    public void insertatend(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        System.out.println("Enter the data to insert at end: ");
        int data = scan.nextInt();
        node newnode = new node(data);
        node current = head;
        while(current.next != null){
            current = current.next;
         //   System.out.print(current.data+"=>");
        }
        newnode.previous = current;
        current.next = newnode;

    }
    public void deletefirstnode(){
        if(head == null){
            System.out.println("Empty list");
            return;
        }
        else{          
            head = head.next;

        }
    }
    public void deletenodelast(){
        if(head == null){
            System.out.println("Empty list");
            return;
        }
        if(head.next == null){ // this loop is to delete node if the list has only one element
            head = head.previous;
            return;
        }
        else{
            node current = head;
            while(current.next != null){
                current = current.next;
            }
            current = current.previous;
            current.next = null;
        }
    
    }
    public static void main(String[] args) {
        doublylinkedlist dll = new doublylinkedlist();
        dll.head = new node(10);
        node second = new node(11);
        node three = new node(12);
        node four = new node(13);
        dll.head.next = second;
        second.previous = dll.head;
        second.next = three;
        three.previous = second;
        three.next = four;
        four.previous = three;        
        while(true){
            System.out.println("\n1. Display Data from first \n2. Display data from last \n3. Insert At First \n4. Insert at End \n5. Delete the first node \n6. Delete the last node \n7. break");
            int n = scan.nextInt();
            switch(n){
                case 1:
                    dll.display();
                    break;
                case 2:
                    dll.displaylast();
                    break;
                case 3:
                    dll.insertfirst();
                    dll.display();
                    break;
                case 4:
                    dll.insertatend();
                    dll.display();
                    break;
                case 5:
                    dll.deletefirstnode();
                    dll.display();
                    break;
                case 6:
                    dll.deletenodelast();
                    dll.display();
                    break;
                case 7:
                    System.exit(0);
            }
        }   
    }
}

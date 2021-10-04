import java.util.*;


public class circularsinglyll {

    private node last;
    private static Scanner scan = new Scanner(System.in);

    private static class node{
        private int data;
        private node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public void createcircularlinkedlist(){
        node first = new node(10);
        node second = new node(11);
        node third = new node(12);
        node four = new node(13);
        first.next = second;
        second.next = third;
        third.next = four;
        four.next = first;

        last = four;
       // last = null; use this if u want to use the empty circular list.

    }

    public void insertnodefirst(){
        System.out.println("enter the element to insert at first");
        int data = scan.nextInt();
        node newnode = new node(data);
        if(last == null){
            last = newnode;
            last.next = last;
        }
        else{           
            node current = last.next;
            last.next = newnode;
            newnode.next = current;
        }
        
    }
    public void insertnodeatlast(){
        System.out.println("enter the element to insert at first");
        int data = scan.nextInt();
        node newnode = new node(data);
        if(last == null){
            last = newnode;
            last.next = last;
        }else{
            newnode.next = last.next;
            last.next = newnode;
            last = newnode;  ///this is for updation of the last pointer to the newnode
        }
    }

    public void printlist(){
        if(last == null){
            System.out.println("null");
            return;
        }
        node current = last.next;
        while(current != last){
            System.out.print(current.data+"=>");
            current = current.next;
        }
        System.out.print(current.data+"=>null");
        System.out.println();
    }

    public void deletefirstnode(){
        if(last == null){            
            System.out.println("Empty list");
        }
        else if(last.next == last){ // because it is circular linked list
            last = null;
        }
        else{
            last.next = last.next.next;
        }
    }
    public static void main(String[] args) {
        circularsinglyll cll = new circularsinglyll();
        cll.createcircularlinkedlist();
      //  cll.last = new node(10);
      //  cll.last.next = cll.last; this for only one element representation
      while(true){
        System.out.println("\n1. print the list \n2. Insert node at first \n3. Insert node at last \n4. Delete the first node \n5. break");
        int n = scan.nextInt();
        switch(n){
            case 1:
                cll.printlist();
                break;
            case 2:
                cll.insertnodefirst();
                cll.printlist();
                break;
            case 3:
                cll.insertnodeatlast();
                cll.printlist();
                break;
            case 4:
                cll.deletefirstnode();
                cll.printlist();
                break;
            case 5:
                System.exit(0);
        }
      }
        

    }
}

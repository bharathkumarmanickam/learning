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

    }

    public void printlist(){
        node current = last.next;
        while(current != last){
            System.out.print(current.data+"=>");
            current = current.next;
        }
        System.out.print(current.data+"=>null");
        System.out.println();
    }
    public static void main(String[] args) {
        circularsinglyll cll = new circularsinglyll();
        cll.createcircularlinkedlist();
      //  cll.last = new node(10);
      //  cll.last.next = cll.last; this for only one element representation
        System.out.println("\n1. print the list");
        int n = scan.nextInt();
        switch(n){
            case 1:
                cll.printlist();
                break;
        }

    }
}

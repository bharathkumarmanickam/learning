import java.util.*;
public class singlylinkedlist {
    private static Scanner scan = new Scanner(System.in);  
    private static int length = 0;    
    private node head; //generic type first we assign and use the static class to implement

    private static class node{
        private int data;
        private node next;
        
        public node(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static void length(singlylinkedlist list){
        node current = list.head; // head is the root so we point the head
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        length = count;
        System.out.println("count of the data => "+count);
    }
    public static void display(singlylinkedlist n){
        node current = n.head;
        while(current != null){
            System.out.print(current.data+"=>");
            current = current.next;
        }
        System.out.print("null");
        System.out.println();

    }

    public static void insertbegin(int data,singlylinkedlist list){
        node newnode = new node(data);
        newnode.next = list.head;
        list.head = newnode;
    }

    public void insertend(){
        System.out.println("Enter the value to insert at end");
        int data = scan.nextInt();
        node newnode = new node(data);
        if(head == null){
            head = newnode;
            return;
        }
        node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newnode; //because while creating new node, the new node always points to null so we have to connect only the last node to newnode
                
    }

    public void insertpos(){
        System.out.println("Enter the new data to be inserted");
        int data = scan.nextInt();
        node newnode = new node(data);
        System.out.println("Enter the position to insert the node");
        int pos = scan.nextInt();
        if(pos <= 1){
            System.out.println("Position cannot be less than 1");
        }
        if(head == null){
            System.out.println("List Empty try to insert something");
            return;
        }
        else if(pos == 1){
            newnode.next = head;
            head = newnode;
        }else{
            node previous = head;
            int count = 1;
            while(count < pos-1){
                previous = previous.next;
                count++;
            }
            node temp = previous.next;
            newnode.next = temp;
            previous.next = newnode;
        }

    }

    public void deletefirstnode(){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        else{
            node temp = head;
            head = head.next;
            temp.next=null;
            System.out.println("Deleted Node : "+temp.data);
        }
    }

    public void deletelastnode(){
        if(head == null){
            System.out.println("List is empty");
        }
        else if(head.next == null){
            System.out.println(head.data);
        }
        else{
            node previous = null;
            node current = head;
            while(current.next != null){
                previous = current;
                current = current.next;              
            }
            previous.next = null;
            System.out.println(current);
        }
    }

    public void deleteatpos(){        
        System.out.println("Enter the position to delete");
        int pos = scan.nextInt();
        if(length > pos && pos > 0 ){
            if(pos == 1){
                head = head.next;
            }else{
                node previous = head;
                int count = 0;
                while(count < (pos-1)){
                    previous = previous.next;
                    count++;
                }
                node current = previous.next;
                previous.next = current.next;
                System.out.println("Deleted Value => "+current.data);
            }
        }else{
            System.out.println("Length should be valid"); //checking the legth
        }
    }

    public void search(){
        System.out.println("Enter data to be search in the list ..");
        int data = scan.nextInt();
        node current = head;
        int count = 1;
        while(current.next != null){
            if(current.data == data){
                System.out.println("Your element "+data+" is present in "+count+" position in the list");
                return;
            }
            count++;
            current = current.next;
        }
        System.out.println("Your element "+data+" is not present in the list");
        return;
    }

    public void reversenode(){
        //beware of the reverse the node if u want to really change the rotate the list do the below code otherwise take
        //copy of the list and do.
        if(head == null){
            System.out.println("List is empty");
        } 
        node current = head;       
        node previous = null;
        node nextnode = null;
        while(current != null){
            nextnode = current.next;
            current.next = previous;
            previous = current;
            current = nextnode;  
        }

        //printing the data
        node pre = previous;
        while(pre != null){
            System.out.print(pre.data+"=>");
            pre = pre.next;
        }
        System.out.print("null");
    }

    public void findmid(){
        node slowptr = head;
        node fastptr = head;
        while(fastptr !=null && fastptr.next != null ) //first one for even and second for odd
        {
            slowptr = slowptr.next;
            fastptr = fastptr.next.next;
        }
        System.out.println("The middle element of the list => "+slowptr.data);
    }

    public void fintfromlast(){        
        System.out.println("Enter the position to be find the element");
        int pos = scan.nextInt();
        if((pos >= length) == true){
            System.out.println("invalid node position");
            return;
        }else{
            node ref = head;
            node mainptr = head;
            int count = 0;
            while(count < pos){
                ref = ref.next;
                count++;
            }
            while(ref != null){
                ref = ref.next;
                mainptr = mainptr.next;
            }
            System.out.println("The element in the "+pos+" is => "+mainptr.data);
        }

    }
    public void removedupfromsortedlist(){ // removes the duplicates from the sorted list
        node current = head;
        while(current != null && current.next !=null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
        
    }

    public void insertatsortedlist(){
        System.out.println("Enter the new value to be inserted");
        int data = scan.nextInt();
        node newnode = new node(data);
        if(head == null){
            System.out.print("List empty");
            return;
        }else{
            node current = head;
            node temp = null;
            while(current != null && current.data < data){
                temp = current;
                current = current.next;
            }
            newnode.next = current;
            temp.next = newnode;
        }
        

       
    }

    public void deletegivenkey(){
        System.out.println("Enter the key to delete : ");
        int key = scan.nextInt();
        node current = head;
        node pre = null;
        while(current != null && current.data != key){
            pre = current;
            current = current.next;            
        }
        if(current == null){ System.out.println("No key found"); return;}
        pre.next = current.next;
        System.out.println("Deleted succcessfully");
    }
    public void detectloop(){
        node fastptr = head;
        node slowptr = head;
        while(fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(fastptr == slowptr){
                System.out.println("Loop detected");
                return;
            }
        }
        System.out.println("No Loop detected....");
    }

    public void detectloopfirstelement(){
        node fastptr = head;
        node slowptr = head;
        while(fastptr != null && fastptr.next != null){
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(fastptr == slowptr){                
                System.out.println("Starting Element of the loop is : "+getstartingelement(slowptr).data);
                return;
            }
        }
        System.out.println("No Loop detected....");
    }

    public node getstartingelement(node slowptr){

        node temp = head;
        while(temp != slowptr){
            temp = temp.next;
            slowptr = slowptr.next;
        }
        return temp; // but we cannot assure this works so next floyd detection will give clarification

    }

    public void removeloop(){
        node fastptr = head;
        node slowptr = head;
        while(fastptr != null  && fastptr.next != null){ // while for finding  the loop
            fastptr = fastptr.next.next;
            slowptr = slowptr.next;
            if(slowptr == fastptr){
                node temp = head;
                while(slowptr.next != temp.next){ // this is to find the loop previous and ending point temp will find the previous of the starting point and slowptr will find the previous of the loop
                    slowptr = slowptr.next;
                    temp = temp.next;                
                }
                slowptr.next = null;
                System.out.println("Loop successfully removed from the list");
                return;
            }

        }

    }
    public static void main(String[] args) {
        singlylinkedlist sll = new singlylinkedlist();
        // sll.head = new node(10); // or node head = new node(10) and use the object to join the head to other      
        // node second = new node(11);
        // node third = new node(11);
        // node fourth  = new node(12);
        // node five = new node(14);
        // sll.head.next = second;
        // second.next = third;
        // third.next = fourth;
        // fourth.next=five; 
        //  ------------------use this for only detecting loop---------------
        sll.head = new node(10);
        node second = new node(11);
        node third = new node(11);
        node fourth  = new node(12);
        node five = new node(14);
        node six = new node(19);
        sll.head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = five;
        five.next = six;        
        six.next = third;

        //---------------------finish the detecting loop------------------
                   
        while(true){
            System.out.println("\nMenu Driven for singly linked list\n1. print data\n2. Count Data\n3. Insert At Node Begining\n4. Insert at End node\n5. Insert at given position\n6. delete first node\n7. delete last node\n8. Delete at given position\n9. Search on list\n10. Reverse List\n11. Find middle element\n12. Find From last\n13. Remove the duplicated\n14. Insert node into sorted list\n15. Delete the node from given key \n16. Detect Loop in the linked list \n17. Detect First element of the loop \n18. Remove loop from list \n19. break");
            int j = scan.nextInt();
            switch(j){
                case 1: 
                    display(sll);
                    break;                
                case 2:
                    length(sll);
                    break;
                case 3:
                    System.out.println("Enter the data to be instered in the begining....");
                    int data = scan.nextInt();
                    insertbegin(data,sll);
                    display(sll);
                    break;
                case 4:
                    sll.insertend();
                    display(sll);
                    break;
                case 5:
                    sll.insertpos();
                    display(sll);
                    break;
                case 6:
                    sll.deletefirstnode();
                    break;
                case 7:
                    sll.deletelastnode();
                    break;
                case 8:
                    display(sll);
                    length(sll);
                    sll.deleteatpos();
                    break;
                case 9:
                    sll.search();
                    break;
                case 10:
                    sll.reversenode();
                    break;
                case 11:
                    sll.findmid();
                    break;
                case 12:
                    length(sll);
                    display(sll);
                    sll.fintfromlast();
                    break;
                case 13:
                    display(sll);
                    sll.removedupfromsortedlist();
                    display(sll);
                    break;
                case 14:
                    display(sll);
                    sll.insertatsortedlist();
                    display(sll);
                    break;
                case 15:
                    sll.deletegivenkey();
                    display(sll);
                    break;
                case 16:
                    sll.detectloop();
                    break;     
                case 17:
                    sll.detectloopfirstelement();
                    break;   
                case 18:
                    sll.removeloop();
                    break;            
                case 19:
                    System.exit(0);
            }  

        }
 
    }
}

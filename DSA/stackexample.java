import java.util.*;

public class stackexample {
    private static node top;
    private static Scanner scan = new Scanner(System.in);
    private static class node{
        private int data;
        private node next;

        public node(int data){
            this.data = data;
            this.next = null;
        }

    }
    public static void push(){
        System.out.println("Enter the data to push");
        int data = scan.nextInt();
        node temp = new node(data);
        temp.next = top; // null points to temp.next in first
        top = temp;
        System.out.println("successfully inserted");
    }
    public static void pop(){
        if(top == null){
            System.out.println("stack is empty");
            return;
        }
        int result = top.data;
        top = top.next; // so the previous top values will be garbage collected
        System.out.println("Data : "+result+" Success deleted");
        
    }
    public static void print(){
        node current = top;
        while(current != null){
            System.out.print(current.data+"<=");
            current = current.next;
        }
        System.out.print("null");
    }
    public static void reversestring(){
        System.out.println("Enter the string : ");
        String data = scan.next();
        Stack<Character> stack = new Stack<>();
        char[] chars = data.toCharArray();
        for(char c : chars){
            stack.push(c);
        }

       for(int i = 0; i < data.length(); i++){
           chars[i] = stack.pop();
       }
       System.out.println("Reversed String : "+new String(chars));
    }
    public static void main(String[] args) {
        while(true){
            System.out.println("\n1. push \n2. pop \n3. print \n4. peek element \n5. reverse a string \n6. break");
            int n = scan.nextInt();
            switch(n){
                case 1:
                    push();
                    break;
                case 2:
                    pop();
                    break;
                case 3:
                    print();
                    break;
                case 4:
                    if(top != null){
                        System.out.println("Top Element is :"+top.data);
                    }
                    else{
                        System.out.println("null");
                    }
                    break;
                case 5:
                    reversestring();
                    break;
                case 6:
                    System.exit(0);
            }
        }
       

    }
}

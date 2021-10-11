import java.util.*;

public class binarytree {
    private static Scanner scan = new Scanner(System.in);
    private static treenode root;

    private static class treenode{
        private int data;
        private treenode left;
        private treenode right; 

        public treenode(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public void initialtree(){
        treenode first = new treenode(10);
        treenode second = new treenode(11);
        treenode third = new treenode(12);
        treenode fourth = new treenode(13);
        treenode fifth = new treenode(14);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;


    }
    public void print(){

    }
    public static void main(String[] args) {
        binarytree bn = new binarytree();
        bn.initialtree();
       System.out.println("\n1. Print Tree \n7. break"); 
       int n = scan.nextInt();
       switch(n){
           case 1:
                bn.print();
                break;
            case 7:
                System.exit(0);
       }

    }
}

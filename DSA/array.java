import java.util.*;



public class array {
    private static Scanner scan = new Scanner(System.in);

    public int length(int[] myarray){
        return myarray.length;
        
    }
    public void print(int[] arr){
        if(length(arr) > 0){
            for(int i = 0; i < length(arr); i++){
                System.out.printf("%d\t",arr[i]);
            }            
        }else{
            System.out.println("Array is emtpy");
        }
    }

    public void reverse(int arr[]){
        int start = 0;
        int end = arr.length - 1;
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        
    }
    public void minimum(int[] arr){
        //this is for finding minimum value in array
        int min = arr[0];
        for(int i = 1; i< arr.length-1; i++){ //why i = 1 means because we have already taken the arr[0] as minimum
            if(arr[i] < min){
                min = arr[i];
            }
        } 
        System.out.println("The minimum Element in the array is : "+min);
    }

    public void movezerotolast(int[] arr){
        int j= 0;
        for(int i=0; i<arr.length;i++){
            if(arr[i] != 0 && arr[j] == 0){ // i is for checking the element is not zero and j is for zero findings
                int temp = arr[i]; //swaping begins
                arr[i] = arr[j];
                arr[j] = temp;
            }
            if(arr[j] != 0){
                j++;
            }
    }
    }
    public int[] resize(int[] arr, int newcapa){
        System.out.println("old array length : "+arr.length);
        int[] temp = new int[newcapa]; // creating new with extra space
        for(int i = 0; i < arr.length; i++){ // copying the values from original array to tempnew
            temp[i] = arr[i];
        }
    
        System.out.println("New array length : "+arr.length);
        return temp;
        }
    
    public void ispalindrome(){
        System.out.println("Enter the word to check it is palindrome or not");
        String word = scan.next();
        char[] character = word.toCharArray();
        int start = 0;
        int end = word.length()-1;
        while(start < end){
            if(character[start] != character[end]){
                System.out.println("String is Not Palindrome");
                return;
            }
            start++;
            end--;
        }
        System.out.println("String "+word+" is palindrome");
    }
    public static void main(String[] args) {
        array arr = new array();
        int[] myarray = new int[5]; // default values is zero 
        myarray[0] = 1;
        myarray[1] = 2;
        myarray[2] = 3;
        myarray[3] = 4;
        myarray[4] = 5; 
        while(true){
            System.out.println("\n1. print the array \n2. Reversed the array \n3. To find the minimum value \n4. Move Zero to last \n5. resize \n6. To check palindrome in string \n7. Exit");
            int n = scan.nextInt();
            switch(n){
                case 1:
                    arr.print(myarray); // or we can also create new constructor like arr.print(new int[] {1,2,3,4,5})
                    break;
                case 2:
                    arr.reverse(myarray);
                    arr.print(myarray);                    
                    break;
                case 3:
                    arr.minimum(myarray);
                    break;  
                case 4:
                    arr.movezerotolast(myarray);
                    arr.print(myarray);
                    break;         
                case 5: 
                    myarray = arr.resize(myarray,8);
                    arr.print(myarray);
                    break;  
                case 6:
                    arr.ispalindrome();
                    break;       
                case 7:
                    System.exit(0);
            }
        }
    }
}

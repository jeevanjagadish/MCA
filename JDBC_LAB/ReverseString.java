package mcaSem5; 

import java.util.Scanner;

class ReverseString 
{ 
    public static void main(String[] args) 
    { 
        String str, rev = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter any string: ");
        str = sc.nextLine();
        
        char[] try1 = str.toCharArray(); 
  
        for (int i = try1.length-1; i>=0; i--) 
            rev += try1[i];
        
        System.out.println("Reversed: " + rev);
        
        sc.close();
    } 
} 
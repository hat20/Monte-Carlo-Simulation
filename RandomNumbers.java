import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.Random;

public class RandomNumbers {

    public static void main(String[] args) 
    {

        Scanner fp = new Scanner(System.in);
        RandomNumbers obj = new RandomNumbers();

        System.out.println("Enter the number of random numbers you need");
        int n = fp.nextInt();

        //Skip the newline
        fp.nextLine();

        int randNum[] = new int[n];
        System.out.println("Do you want Random Number to be unique? Type 'Yes' or 'No' to answer");
        String entry = fp.nextLine();

        if(entry.equalsIgnoreCase("yes") == true)
            randNum = obj.unique_random_numbers(n);
        else
            randNum = obj.random_numbers(n);

        for(int i=0;i<n;i++)
            System.out.println(randNum[i]);      


    } 
        
    int[] unique_random_numbers(int n)
    {   
    //Adding the numbers 0-99 in an ArrayList
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i=0; i<100; i++) 
        {
            list.add(i);
        }
        
        int arr[] = new int[n];
        Collections.shuffle(list);
        for (int i=0; i<n; i++) 
        {
            arr[i] = list.get(i);
        }
        return arr;
    }

    int[] random_numbers(int n)
    {
        int arr[] = new int[n];
        Random rand = new Random();

        for(int i=0;i<n;i++)
            arr[i] = rand.nextInt(100);

        return arr;    
    }
}
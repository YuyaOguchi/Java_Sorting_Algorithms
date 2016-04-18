/*----------------------------------------------------------------------------------------------------
 * 
 * Project: Timingsort
 * Author: Yuya Oguchi              Date: 3/10/14
 * 
 * ---------------------------------------------------------------------------------------------------
 * 
 * Times for different sortings
 * Selection Sort takes 7042 milliseconds.
 * Insertion Sort takes 1146 milliseconds.
 * Merge Sort takes 53 milliseconds.
 * 
 * As I increased the quantity of numbers in arraylist, the gap widened more between each method.
 * It is mainly because when there are 3 or 4 numbers in the array, it only check few times at max,
 * so all of the methods will be similar time, but as the number increase, efficient ones will have 
 * to check far less numbers to make array in order, so there will be more gap as the array size increase.
 * 
 */

import java.util.*; 
import java.util.Scanner;
public class SortTimer
{
    public static int x = 100000;
    public static void main (String[] args)
    { 

        //ask user for number of experiment to run
        System.out.println ("Timing Sort Lab");
        System.out.println ("How many times would you like to run the test?");
        Scanner scan = new Scanner(System.in);
        int z = scan.nextInt();
        System.out.println ("--------------------------------");
        for (int j = 0; j < z; j++){

            //creates the array for the radomised numbers for the sorts
            int [] array1 = new int[x];
            int [] array2 = new int[x];
            int [] array3 = new int[x];
            //creates 10000000 random numbers for each array
            for (int i = 0 ; i < array1.length; i++)
            {
                int k = (int)(Math.random() * 10000000);
                array1[i] = k;
                array2[i] = k;
                array3[i] = k;
            }

            //print how long it took for each sort to finish
            
            System.out.println ("Try: " + (j + 1));
            System.out.println("Times for 3 sortings");
            System.out.println ("");
            long start1 = System.currentTimeMillis(); //start timer
            SelectionSort(array1);
            long end1 = System.currentTimeMillis(); //end timer
            System.out.println("Selection Sort took:");
            System.out.println((end1 - start1) + " milliseconds.");
            /*
             * for(int i = 0; i < array1.length; i++){ 
             * system.out.println(array1[i]); 
             * }
             */

            System.out.println ("");
            long start2 = System.currentTimeMillis(); //start timer 
            insertionSort(array2);
            long end2 = System.currentTimeMillis(); //end timer
            System.out.println("Insertion Sort took:");
            System.out.println((end2 - start2) + " milliseconds.");
            /*
             * for(int i = 0; i < array2.length; i++){ 
             * system.out.println(array2[i]); 
             * }
             */

            System.out.println ("");
            long start3 = System.currentTimeMillis(); //start timer
            MergeSort.sort(array3, 0, array3.length - 1);
            long end3 = System.currentTimeMillis(); //end timer
            System.out.println("Merge Sort took:");
            System.out.println((end3 - start3) + " milliseconds.");
            System.out.println ("--------------------------------");
            System.out.println ("");
            /*
             * for(int i = 0; i < array3.length; i++){ 
             * system.out.println(array3[i]); 
             * }
             */
            
            /*
            Times for different sortings
            Selection Sort takes 7042 milliseconds.
            Insertion Sort takes 1146 milliseconds.
            Merge Sort takes 53 milliseconds.
             */
        }
    }

    /*Selection sort

    takes the next number in array and read through rest of the array 
    to find a lowest value, and then switch that next number with the lowest value.
    keep going until the array hit to the last number and it is done

     */
    public static void SelectionSort(int [] selSort)
    {
        int key, temp;
        for(int index = 0; index < selSort.length-1; index++)
        {
            key = index;
            for(int position = index+1; position < selSort.length; position++)//caompare the vals
            {
                if(selSort[position] < selSort[key])
                    key = position;
            }

            temp = selSort[key];//change values
            selSort[key] = selSort[index];
            selSort[index] = temp;
        }
    } 

    /*Insertion sort

    go through each number in the array and switch the number with the next number with a lower value
    continue until the last value 

     */
    public static void insertionSort(int [] insSort)
    {
        for(int index = 1; index < insSort.length; index++)
        {
            int key = insSort[index];
            int position = index;
            while(position > 0 && insSort [position - 1] > key)//compare vals
            {
                insSort[position] = insSort[position - 1];
                position--;
            }

            insSort[position] = key; //change location of number
        }
    } 
}
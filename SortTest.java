/**Veronique Justinvil 
 * The use of sorting algorithms to display the number of iterations used to sort the data structure 
 * 12/6/22
 */ 
/** Discussion of Results:  
 * Selection Sort: each number of iterations for each list is the same because, the algorithm makes a comparision to each element which 
 * results to the same iterations and also a higher number of iterations. This makes the time complexity of O(n^2) because it requires a lot 
 * more time to go through iterations. 
 * Insertion Sort: the number of iterations for the Random list is larger than the sorted list because while it is sorted, there are less 
 * comparisions and the shifting of the list would be less, however, the reversed list required more iterations because, if in a specific 
 * ascending/desending order, it will need to revert back from its reversed order to correct order. It will have a time complexity of 
 * O(n^2) 
 * Bubble Sort: the number of iterations for both the random & reversed list is larger than the sorted list, the time complexity can be 
 * showned to be O(N^2)
 * Merge Sort/ Quick Sort: the iterations are larger because it also results with a larger space complexity of O(N) for merge sort and O(1) 
 * for quick sort, since both algorithms are divide and conquer both have a case of O(N log n) when splitting 
 * Heap Sort: The add and remove method are both a time complexity of O(log n) and a space complexity of O(N) which can be represented 
 * in terms of the add/remove methods in the heaps 
 * Bucket/Radix Sort: iterations of both the bucket/radix sort is are a bit smaller however the space complexity depends on the number of buckets
 * that are stored in memory which results on the number of iterations used when used from it. 
*/
import java.util.ArrayList;
public class SortTest { 
    public static final int size = 10000 ;
    public static void main(String[]args){ 
        ArrayList<Integer> randomList = new ArrayList<>();  
        for(int i = 0; i<size; i++){ 
            randomList.add((int)(Math.random() * (size -1) + 1)); //filling arraylist of random #'s 
        } 
        ArrayList<Integer> sortedList = (ArrayList<Integer>)(randomList.clone()); 
        ArrayList<Integer> reversedList = (ArrayList<Integer>)(randomList.clone());  
        java.util.Collections.sort(sortedList); //can use this sort, swap, or reverse  
        java.util.Collections.sort(reversedList);
        java.util.Collections.reverse(reversedList);  

        System.out.printf("%-20s\t%-15s\t%-15s\t%-15s\n", "Sorting Algorithm", "Random", "Sorted", "Reversed");
        //Selection Sort 
        Sort.selectionSort(randomList);  
        int randomIterations = Sort.iterations[0]; 
        Sort.selectionSort(sortedList);    
        int sortedIterations = Sort.iterations[0];
        Sort.selectionSort(reversedList); 
        int reversedIterations = Sort.iterations[0];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Selection Sort", randomIterations, sortedIterations, reversedIterations);

        //Insertion sort 
        java.util.Collections.shuffle(randomList);  
        java.util.Collections.reverse(reversedList); 
        Sort.insertionSort(randomList);  
         randomIterations = Sort.iterations[1]; 
        Sort.insertionSort(sortedList);    
         sortedIterations = Sort.iterations[1];
        Sort.insertionSort(reversedList); 
         reversedIterations = Sort.iterations[1];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Insertion Sort", randomIterations, sortedIterations, reversedIterations); 
 
        //Bubble sort  
        java.util.Collections.shuffle(randomList);  
        java.util.Collections.reverse(reversedList); 
        Sort.bubbleSort(randomList);  
         randomIterations = Sort.iterations[2]; 
        Sort.bubbleSort(sortedList);    
         sortedIterations = Sort.iterations[2];
        Sort.bubbleSort(reversedList); 
         reversedIterations = Sort.iterations[2];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Bubble Sort", randomIterations, sortedIterations, reversedIterations); 

        //Merge sort 
        java.util.Collections.shuffle(randomList);  
        java.util.Collections.reverse(reversedList); 
        Sort.mergeSort(randomList);  
         randomIterations = Sort.iterations[3]; 
        Sort.mergeSort(sortedList);    
         sortedIterations = Sort.iterations[3];
        Sort.mergeSort(reversedList); 
         reversedIterations = Sort.iterations[3];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Merge Sort", randomIterations, sortedIterations, reversedIterations); 

        //Quick sort  
        java.util.Collections.shuffle(randomList);  
        java.util.Collections.reverse(reversedList); 
        Sort.quickSort(randomList);  
         randomIterations = Sort.iterations[4]; 
        Sort.quickSort(sortedList);    
         sortedIterations = Sort.iterations[4];
        Sort.quickSort(reversedList); 
         reversedIterations = Sort.iterations[4];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Quick Sort", randomIterations, sortedIterations, reversedIterations);

        //Heap Sort  
        java.util.Collections.shuffle(randomList);  
        java.util.Collections.reverse(reversedList); 
        Sort.heapSort(randomList);  
         randomIterations = Sort.iterations[5]; 
        Sort.heapSort(sortedList);    
         sortedIterations = Sort.iterations[5];
        Sort.heapSort(reversedList); 
         reversedIterations = Sort.iterations[5];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Heap Sort", randomIterations, sortedIterations, reversedIterations); 

        //Bucket Sort  
        java.util.Collections.shuffle(randomList);  
        java.util.Collections.reverse(reversedList); 
        Sort.bucketSort(randomList);  
         randomIterations = Sort.iterations[6]; 
        Sort.bucketSort(sortedList);    
         sortedIterations = Sort.iterations[6];
        Sort.bucketSort(reversedList); 
         reversedIterations = Sort.iterations[6];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Bucket Sort", randomIterations, sortedIterations, reversedIterations); 
        
        //Radix sort 
        java.util.Collections.shuffle(randomList);  
        java.util.Collections.reverse(reversedList);
        Sort.radixSort(randomList);  
         randomIterations = Sort.iterations[7]; 
        Sort.radixSort(sortedList);    
         sortedIterations = Sort.iterations[7];
        Sort.radixSort(reversedList); 
         reversedIterations = Sort.iterations[7];   
        System.out.printf("%-20s\t%-15d\t%-15d\t%-15d\n", "Radix Sort", randomIterations, sortedIterations, reversedIterations); 


    }
}

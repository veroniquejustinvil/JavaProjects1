/**Veronique Justinvil 
 * The use of sorting algorithms to display the number of iterations used to sort the data structure 
 * 12/6/22
 */
import java.util.ArrayList; 
public class Sort { 
    public static int[] iterations = new int[8];  
    public static int maxIterations;
    public static <E extends Comparable<E>> void selectionSort(ArrayList<E> list) {
        int minIndex;  
        iterations[0] = 0;
        for (int i = 0; i < list.size() - 1; i++) { 
            iterations[0]++; 
            E min = list.get(i);
            minIndex = i;
            for (int j = i; j < list.size(); j++) { 
                iterations[0]++; 
                if (list.get(j).compareTo(min) < 0) {
                    min = list.get(j);
                    minIndex = j;
                }
            }
            swap(list, i, minIndex);
            /*
             * E temp = list.get(i);
             * E tempMin = list.get(minIndex);
             * list.set(i, minIndex);
             * list.set(minIndex, temp);
             */
        }
    }

    public static <E extends Comparable<E>> void insertionSort(ArrayList<E> list) { 
        iterations[1] = 0;
        for (int i = 1; i < list.size(); i++) { 
            iterations[1]++;
            // Insert element i in the sorted sub-list
            E currentVal = list.get(i);
            int j = i;
            while (j > 0 && currentVal.compareTo((list.get(j - 1))) < 0) { 
                iterations[1]++; 
                // Shift element (j-1) into element (j)
                E temp = list.get(j - 1);
                list.set(j, temp);
                j--;
            }
            // Insert currentVal at position j
            list.set(j, currentVal);
        }
    }

    public static <E extends Comparable<E>> void bubbleSort(ArrayList<E> list) { 
        iterations[2] = 0;
        boolean sorted = false;
        for (int k = 1; k < list.size() && !sorted; k++) { 
            iterations[2]++;
            sorted = true;
            for (int i = 0; i < list.size() - k; i++) { 
                iterations[2]++;
                if (list.get(i).compareTo(list.get(i + 1)) > 0) {
                    // swap
                    swap(list, i, i + 1);
                    /*
                     * E temp = list.get(i);
                     * E tempV = list.get(i + 1);
                     * list.set(i, tempV);
                     * list.set(i + 1, temp);
                     */
                    sorted = false;
                }
            }
        }
    }

    public static <E> ArrayList<E> subList(ArrayList<E> list, int start, int end) {
        if (start < 0 || start >= list.size() || end < 0 || end > list.size() || start > end) {
            throw new ArrayIndexOutOfBoundsException();
        }
        ArrayList<E> newList = new ArrayList<>(); 
        for (int i = start; i < end; i++) { 
            iterations[3]++;
            newList.add(list.get(i));
        }
        return newList;
    }

    public static <E extends Comparable<E>> void mergeSort(ArrayList<E> list) { 
        iterations[3]++;
        if (list.size() > 1) { // ==1: base case
            ArrayList<E> firstHalf = subList(list, 0, list.size()/ 2);
            ArrayList<E> secondHalf = subList(list, list.size() / 2, list.size());

            /*
             * System.arraycopy(list, 0, firstHalf, 0, list.size() / 2);
             * System.arraycopy(list, list.size() / 2, secondHalf, 0, list.size() -
             * list.size() / 2);
             */
            mergeSort(firstHalf);
            mergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }

    }

    public static <E extends Comparable<E>> void merge(ArrayList<E> list1, ArrayList<E> list2, ArrayList<E> list) {
        int list1Index = 0;
        int list2Index = 0;
        int listIndex = 0;
        while (list1Index < list1.size() && list2Index < list2.size()) { 
            iterations[3]++;
            if (list1.get(list1Index).compareTo(list2.get(list2Index)) < 0) {
                list.set(listIndex++, list1.get(list1Index++));
            } else {
                list.set(listIndex++, list2.get(list2Index++));
            }
        }
        // remaining elements in list1 (if needed)
        while (list1Index < list1.size()) { 
            iterations[3]++;
            list.set(listIndex++, list1.get(list1Index++));
        }
        while (list2Index < list2.size()) { 
            iterations[3]++;
            list.set(listIndex++, list2.get(list2Index++));
        }

    }

    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list) { 
        iterations[4]=0;
        quickSort(list, 0, list.size() - 1);
    }

    // helper method
    public static <E extends Comparable<E>> void quickSort(ArrayList<E> list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, last);
        }
    }

    public static <E extends Comparable<E>> int partition(ArrayList<E> list, int first, int last) { // O(n log n)
        E pivot;
        int index, pivotIndex;
        pivot = list.get(first);// pivot is the first element
        pivotIndex = first;
        for (index = first + 1; index <= last; index++){// O(n) 
        iterations[4]++;
            if (list.get(index).compareTo(pivot) < 0) {
                pivotIndex++;
                swap(list, pivotIndex, index);
            } 
        }
        swap(list, first, pivotIndex);
        return pivotIndex;
    }

    public static <E> void swap(ArrayList<E> list, int index1, int index2) { // O(1)
        E temp = list.get(index1);
        list.set(index1, list.get(index2));
        list.set(index2, temp);
    }

    public static <E extends Comparable<E>> void heapSort(ArrayList<E> list) {
        Heap<E> heap = new Heap<>();  
        iterations[5]=0;
        for (int i = 0; i < list.size(); i++) { 
            iterations[5]++;
            heap.add(list.get(i)); //O(log n)
        }
        for (int i = list.size() - 1; i >= 0; i--) { // O(n log n) 
            iterations[5]++;
            list.set(i, heap.remove());// O(log n)
        }
    }

    public static int max(ArrayList<Integer> list) { // O(n)
        int maximum = list.get(0); 
        maxIterations = 0;
        for (int value : list) { 
            maxIterations++;
            if (value > maximum) {
                maximum = value;
            }
        }
        return maximum;
    }

    public static void bucketSort(ArrayList<Integer> list) { // O(n)
        int t = max(list); 
        iterations[6]=maxIterations;
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(t + 1);
        for (int i = 0; i < t + 1; i++) { 
            iterations[6]++;
            buckets.add(new ArrayList<>()); // bucket i
        }
        // Distribute data on buckets
        for (int i = 0; i < list.size(); i++) { // O(n) 
            iterations[6]++;
            ArrayList<Integer> bucket = buckets.get(list.get(i));
            bucket.add(list.get(i));
            // buckets.set(list[i], bucket);
        }
        // Move data from the buckets back to the list
        int k = 0;
        for (int i = 0; i < buckets.size(); i++) { 
            iterations[6]++;
            ArrayList<Integer> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++)
                list.set(k++, bucket.get(j));
        }
    }

    public static void radixSort(ArrayList<Integer> list) {
        ArrayList<ArrayList<Integer>> buckets;
        buckets = new ArrayList<>(10);// 10 buckets 
        iterations[7]= maxIterations;
        Integer digits = max(list);
        digits = digits.toString().length();
        for (int i = 0; i < digits; i++) {// O(digits) 
            iterations[7]++;
            for (int j = 0; j < 10; j++) { // create buckets for iteration i 
                //O(1) - 10 times 
                buckets.add(new ArrayList<>()); 
                iterations[7]++;
            }
        
        // Distribute data on buckets
        for (int j = 0; j < list.size(); j++) {
            int digit = (list.get(j) %  (int) (Math.pow(10, i+1))) / (int)(Math.pow(10,i));
            ArrayList<Integer> bucket = buckets.get(digit);
            bucket.add(list.get(j)); 
            iterations[7]++;
         //   buckets.set(digit, bucket);
        } 
    
        // Move data from the buckets back to the list
        int k = 0;
        for (int l = 0; l < buckets.size(); l++) { 
            iterations[7]++;
            ArrayList<Integer> bucket = buckets.get(l);
            for (int j = 0; j < bucket.size(); j++)
                list.set(k++,bucket.get(j)); 
                iterations[7]++;
        }
        buckets.clear(); // for next iteration 
     }
    }

}

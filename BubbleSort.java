import java.util.Arrays;

/**
 * BubbleSort an Array
 */
public class BubbleSort {

    public static void bubbleSort(int[] unsorted){
        System.out.println("Unsorted Array before Sorting : "+ Arrays.toString(unsorted));

        for(int i=0; i< unsorted.length;i++){

            for(int j=1; j< unsorted.length ; j++){

                if(unsorted[j-1] > unsorted[j]){
                    int temp = unsorted[j];
                    unsorted[j] = unsorted[j-1];
                    unsorted[j-1] = temp;
                }
            }
            System.out.println("unsorted array after %d pass %s: "+ (i+1)+"  "+ Arrays.toString(unsorted));

        }




    }

    public static void main(String args[]) {
        //testing our bubble sort method in Java
        int[] unsorted = {32, 39,21, 45, 23, 3};
        bubbleSort(unsorted);

        //one more testing of our bubble sort code logic in Java
        int[] test = { 5, 3, 2, 1};
        bubbleSort(test);

    }


}

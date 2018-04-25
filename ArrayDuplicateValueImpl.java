import java.util.Random;

/**
 * This class will be used to find the duplicate value from and array where it should have values 1 to 100.
 * Array should have 1-100 values and one duplicate - length of array is 101
 */
public class ArrayDuplicateValueImpl {

    public static void main(String args[]){
        int arr[] = new int[101];
        Random r = new Random();
        for(int i = 0 ;i<100; i++ ){
            arr[i] = i+1;
           // arr[i]  = r.nextInt(100) + 1;
        }

        int duplicate = r.nextInt(100);
        System.out.println("duplicate"+duplicate);
        arr[100] = duplicate;



    }


    public static int findDuplicate(int[] arr){
        int totalArr = 0;
        //Duplicate
        for(int i=0; i< arr.length ; i++){
            totalArr += arr[i];
        }

        System.out.println("totalArr"+totalArr);

        int expectedTotal = (100*(100+1))/2;

        System.out.println("expectedTotal"+expectedTotal);

        int duplicate = expectedTotal-totalArr;
        System.out.println("Duplicate is->"+(duplicate));
        return duplicate;
    }
}

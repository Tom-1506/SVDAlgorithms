import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SVDAlgorithms{

    /**
     * Takes int[] arrayIn and finds the SVD if it exists, using solution of worst case
     * runtime complexity O(n^2)
     * @param arrayIn
     * @return SVD of arrayIn or -1 if SVD doesn't exist
     */
    private static int quadratic(int[] arrayIn){
        int count;

        for(int i = 0; i < arrayIn.length; i++){
            count = 0;
            for (int j = 0; j < arrayIn.length; j++){
                if (arrayIn[j] == arrayIn[i]){
                    count++;
                }
            }
            if (count > arrayIn.length / 2){
                return arrayIn[i];
            }
        }
        System.out.println("No SVD exists");
        return -1;
    }

    /**
     * Takes int[] arrayIn and finds the SVD if it exists, using solution of worst case
     * runtime complexity O(nlogn)
     * @param arrayIn
     * @return SVD of arrayIn or -1 if the SVD doesn't exist
     */
    private static int logLinear(int[] arrayIn){
        Arrays.sort(arrayIn);
        int count = 1;

        for(int i = 0; i < arrayIn.length - 1; i++){
            if(arrayIn[i] == arrayIn[i+1]){
                count++;
            } else{
                count = 1;
            }
            if(count > arrayIn.length / 2){
                return arrayIn[i];
            }
        }
        System.out.println("No SVD exists");
        return -1;
    }

    /**
     * Uses The Boyer-Moore Majority Vote Algorithm
     * Takes int[] arrayIn and finds the SVD if it exists, using solution of worst case
     * runtime and space complexity O(n)
     * @param arrayIn
     * @return SVD of arrayIn of -1 if the SVD doesn't exist
     */
    private static int linear(int[] arrayIn){
        int count = 0;
        int choice = 0;
        int svd = -1;

        for(int i : arrayIn){
            if(count == 0){
                choice = i;
                count = 1;
                continue;
            }
            else if(choice == i){
                count++;
            }
            else{
                count--;
            }
        }

        if(count == 0){
            System.out.println("No SVD exists");
        }
        else{
            count = 0;
            for(int i : arrayIn){
                if(choice == i){
                    count++;
                }
            }

            if(count > arrayIn.length / 2){
                svd = choice;
            }
            else{
                System.out.println("No SVD exists");
            }
        }
        return svd;
    }

    public static void main(String[] args){
        int[] arr = {7, 7, 3, 6, 2, 7, 7};

        System.out.println(linear(arr));
    }
}

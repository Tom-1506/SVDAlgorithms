import java.util.ArrayList;
import java.util.Arrays;

public class SVDAlgorithms{

    /**
     * Takes int[] arrayIn and finds the SVD if it exists, using solution of worst
     * runtime complexity O(n^2)
     * @param arrayIn
     * @return SVD of arrayIn or -1 if SVD doesn't exist
     */
    private static int quadratic(int[] arrayIn){
        ArrayList<Integer> checked = new ArrayList<>();
        int count;

        for(int i = 0; i < arrayIn.length; i++){
            if (checked.indexOf(arrayIn[i]) == -1){
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
        }
        System.out.println("No SVD exists");
        return -1;
    }

    /**
     * Takes int[] arrayIn and finds the SVD if it exists, using solution of worst
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

    public static void main(String[] args){
        int[] arr = {7, 7, 3, 6, 2, 7, 7};

        System.out.println(logLinear(arr));
    }
}

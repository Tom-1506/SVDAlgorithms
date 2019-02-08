import java.util.ArrayList;

public class SVDAlgorithms{

    /**
     * Takes int[] arrayIn and finds the SVD if it exists, using solution of worst
     * runtime complexity O(n^2).
     * returns the SVD if found or returns -1 if no SVD exists.
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


    private static int logLinear(int[] arrayIn){
        return 0;
    }

    public static void main(String[] args){
        int[] arr = {7, 7, 9, 3, 2, 7, 7};

        System.out.println(quadratic(arr));
    }
}

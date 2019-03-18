import java.util.Arrays;
import java.util.Random;

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
                if (arrayIn[j] == arrayIn[i]){ //fundamental op
                    count++;
                }
            }
            if (count > arrayIn.length / 2){
                return arrayIn[i];
            }
        }
        //System.out.println("No SVD exists");
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
            if(arrayIn[i] == arrayIn[i+1]){ //fundamental op
                count++;
            } else{
                count = 1;
            }
            if(count > arrayIn.length / 2){
                return arrayIn[i];
            }
        }
        //System.out.println("No SVD exists");
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
            if(count == 0){ //fundamental op
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

        count = 0;
        for(int i : arrayIn){
            if(choice == i){ //fundamental op
                count++;
            }
        }

        if(count > arrayIn.length / 2){
            svd = choice;
        }
        /*else{
            System.out.println("No SVD exists");
        }*/
        return svd;
    }

    public static int[] generateArray(int dimension){
        int[] arrayOut = new int[dimension];

        Random randNum = new Random();

        for(int i = 0; i < arrayOut.length; i++){
            arrayOut[i] = randNum.nextInt(20) + 1;
        }
        return arrayOut;
    }

    public static void timeAlgo(int start, int iterSize, int numTests, int numIterations){
        long startTime;
        long endTime;
        long average;
        for(int i = 0; i < numTests; i++){
            average = 0;

            for(int j = 0; j < numIterations; j++){
                int[] avgArray = generateArray(start + (iterSize * i));

                startTime = System.nanoTime();
                linear(avgArray); //this line was changed to test each function
                endTime = System.nanoTime();

                average += (endTime - startTime);
            }
            average = average/numIterations;
            System.out.println(average);
        }
    }

    public static void main(String[] args){
        int[] arr = {3,3,4,4,4};

        timeAlgo(5000, 5000, 15, 10000);

    }
}

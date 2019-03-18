package hashing;

import java.util.HashSet;
import java.util.Random;

public class ArrayHashTable extends HashTable{

    Object[][] table;
    int chainSize;
    int[] counts;


    public ArrayHashTable(){
        capacity = 10;
        table = new Object[capacity][];
        this.counts = new int[capacity];
        chainSize = 5;
    }

    @Override
    public boolean add(Object obj){
        int hash = obj.hashCode() % this.capacity;

        if(table[hash] == null){
            table[hash] = new Object[chainSize];
            table[hash][0] = obj;
            counts[hash]++;
            return true;
        }
        else{
            for(int i = 0; i < table[hash].length ; i++){
                if(table[hash][i] == null){
                    table[hash][i] = obj;
                    counts[hash]++;
                    return true;
                }
                if(table[hash][i] == obj){
                    return false;
                }
            }
            table[hash] = arrayExtend(table[hash]);
            for(int i = 0; i < table[hash].length ; i++){
                if(table[hash][i] == null){
                    table[hash][i] = obj;
                    counts[hash]++;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean contains(Object obj){
        int hash = obj.hashCode() % capacity;

        if(table[hash] != null){
            for(Object check : table[hash]){
                if(check.equals(obj)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean remove(Object obj){
        int hash = obj.hashCode() % capacity;

        if(table[hash] == null){
            return false;
        }
        else{
            for(int i = 0; i < table[hash].length; i++){
                if(table[hash][i].equals(obj)){
                    table[hash][i] = null;
                    if(i == table[hash].length-1){
                        return true;
                    }
                    else{
                        for(int j = i; j < table[hash].length-1; j++){
                            table[hash][j] = table[hash][j+1];
                            table[hash][j+1] = null;
                        }
                        return true;
                    }
                }
                else{
                    return false;
                }
            }
        }
        return false;
    }

    public Object[] arrayExtend(Object[] objArray){
        Object newArray[] = new Object[objArray.length*2];
        for(int i = 0; i < objArray.length; i++){
            newArray[i] = objArray[i];
        }
        return newArray;
    }

    public static int[] generateArray(int dimension){
        int[] arrayOut = new int[dimension];

        Random randNum = new Random();

        for(int i = 0; i < arrayOut.length; i++){
            arrayOut[i] = Math.abs(randNum.nextInt());
        }
        return arrayOut;
    }

    public static void timeAlgo(ArrayHashTable arr, int start, int iterSize, int numTests, int numIterations){
        long startTime;
        long endTime;
        long average;
        for(int i = 0; i < numTests; i++){
            average = 0;

            for(int j = 0; j < numIterations; j++){
                int[] avgArray = generateArray(start + (iterSize * i));

                startTime = System.nanoTime();
                for(int number : avgArray){
                    arr.add(number);
                }
                for(int number : avgArray){
                    arr.remove(number);
                }
                endTime = System.nanoTime();

                average += (endTime - startTime);
            }
            average = average/numIterations;
            System.out.println(average);
        }
    }

    public static void main(String[] args) {
        HashSet<Integer> arr1 = new HashSet<Integer>();
        ArrayHashTable arr2 = new ArrayHashTable();

        //this function was altered slightly when testing either the hash table or hash set
        timeAlgo(arr2, 15000, 5000, 8, 10000);

        //testing for hash table
        /*int n = 50;
        int[] numbers = new int[n];

        Random rand = new Random();
        for(int i = 0; i < n; i++){
            numbers[i] = Math.abs(rand.nextInt());
        }

        for(int i : numbers){
            arr.add(i);
        }

        int x = 456;
        arr.add(x);

        for(int i = 0; i < n; i++){
            numbers[i] = Math.abs(rand.nextInt());
        }

        for(int i : numbers) {
            arr.add(i);
        }

        int y = 46;

        System.out.println("finished");
        System.out.println(arr.contains(x));
        System.out.println(arr.remove(x));
        System.out.println(arr.remove(y));*/
    }

}
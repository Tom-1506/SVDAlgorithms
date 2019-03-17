package hashing;

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

    public static void main(String[] args) {
        ArrayHashTable arr = new ArrayHashTable();

        int n = 50;
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

        System.out.println("finished");
        System.out.println(arr.contains(x));
    }

}
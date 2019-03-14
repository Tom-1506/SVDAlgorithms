public class ArrayHashTable extends HashTable{

    Object[][] table;
    int[] counts;
    int chainSize;


    public ArrayHashTable(){
        capacity = 10;
        table = new Object[capacity][];
        chainSize = 5;
    }

    @Override
    public boolean add(Object obj){
        return false;
    }

    @Override
    public boolean contains(Object obj){
        return false;
    }

    @Override
    public boolean remove(Object obj){
        return false;
    }

    public static void main(String[] args) {

    }
}

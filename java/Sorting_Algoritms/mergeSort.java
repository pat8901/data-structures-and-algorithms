package Sorting_Algoritms;
import java.util.Random;

class MergeSort {
    private int array[];
    int capacity;

    MergeSort(int size){
        capacity = size;
        array = new int[capacity];
    }

    public void fillArray(){   
        Random random_number = new Random();
        for (int i = 0; i < array.length; i++){
            array[i] = random_number.nextInt(20);
        }

    }
    public void printArray(){
        for(int i = 0; i < array.length-1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length-1]);
    }

    public static void main(String args[]){
        MergeSort merge = new MergeSort(10);
        merge.printArray();
        merge.fillArray();
        merge.printArray();
    }

}

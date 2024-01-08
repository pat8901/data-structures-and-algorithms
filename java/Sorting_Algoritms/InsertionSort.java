package Sorting_Algoritms;

import java.util.Random;

public class InsertionSort {
    private int array[];

    InsertionSort(int size) {
        array = new int[size];
    }

    public void fillArray() {
        Random ran = new Random();
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = ran.nextInt(25);
        }
    }

    public void printArray() {
        System.out.println("--------------------");
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }
    }

    public void insertionSort() {
        for (int i = 1; i < array.length; i++) {
            int current_value = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] >= current_value) {
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = current_value;
        }
    }

    public static void main(String args[]) {
        InsertionSort insertionSort = new InsertionSort(10);
        insertionSort.fillArray();
        insertionSort.printArray();
        insertionSort.insertionSort();
        insertionSort.printArray();
    }
}

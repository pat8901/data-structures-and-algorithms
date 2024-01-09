package Sorting_Algoritms;

import java.util.Random;

class BubbleSort {
    private int[] array;

    BubbleSort(int size) {
        array = new int[size];
    }

    public void bubbleSort() {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    // I like this version better
    public void bubbleSortVers2() {
        int size = array.length;
        boolean swapped = true;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < size - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        }

    }

    public void fillArray() {
        Random ran = new Random();
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = ran.nextInt(25);
        }
    }

    public void printArray() {
        System.out.println("---------------------------");
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }
    }

    public static void main(String args[]) {
        BubbleSort bubbleSort = new BubbleSort(10);
        bubbleSort.fillArray();
        bubbleSort.printArray();
        bubbleSort.bubbleSortVers2();
        bubbleSort.printArray();
    }
}

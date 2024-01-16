package Sorting_Algoritms;

import java.util.Random;

class QuickSort {

    public static void quicksort(int[] array) {
        qs(array, 0, array.length - 1);
    }

    public static void qs(int[] array, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int pivot_index = partition(array, lo, hi);
        qs(array, lo, pivot_index - 1);
        qs(array, pivot_index + 1, hi);
    }

    public static int partition(int[] array, int lo, int hi) {

        int pivot = array[hi];
        int index = lo - 1;

        for (int i = lo; i < hi; i++) {
            if (array[i] <= pivot) {
                index++;
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;
            }

        }

        index++;
        array[hi] = array[index];
        array[index] = pivot;
        return index;
    }

    public static void printArray(int[] array) {
        System.out.println("--------------------");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }

    public static void main(String args[]) {
        Random ran = new Random();
        int[] array = new int[10];

        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = ran.nextInt(50);
        }

        printArray(array);
        quicksort(array);
        printArray(array);
    }
}
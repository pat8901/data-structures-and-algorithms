package Sorting_Algoritms;

import java.util.Random;

class MergeSort {

    public static void main(String args[]) {

        Random random_number = new Random();
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = random_number.nextInt();
        }

        System.out.println("Before sort:");
        printArray(array);

        mergeSort(array);

        System.out.println("After sort:");
        printArray(array);

    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }

    public static void mergeSort(int[] inputArray) {
        int input_length = inputArray.length;

        if (input_length < 2) {
            return;
        }

        int mid = input_length / 2;
        int[] leftHalf = new int[mid];
        int[] rightHalf = new int[input_length - mid];

        for (int i = 0; i < mid; i++) {
            leftHalf[i] = inputArray[i];
        }
        for (int i = mid; i < input_length; i++) {
            rightHalf[i - mid] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);

    }

    public static void merge(int[] inputArray, int[] leftHalf, int[] rightHalf) {
        int leftSize = leftHalf.length;
        int rightSize = rightHalf.length;
        int i = 0, j = 0, k = 0;
        while (i < leftSize && j < rightSize) {
            if (leftHalf[i] <= rightHalf[j]) {
                inputArray[k] = leftHalf[i];
                i++;
            } else {
                inputArray[k] = rightHalf[j];
                j++;
            }
            k++;
        }

        // clean up
        while (i < leftSize) {
            inputArray[k] = leftHalf[i];
            i++;
            k++;
        }

        while (j < rightSize) {
            inputArray[k] = rightHalf[j];
            j++;
            k++;
        }
    }

}

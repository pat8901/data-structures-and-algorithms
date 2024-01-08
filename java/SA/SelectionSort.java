package SA;

import java.util.Random;

public class SelectionSort {
    private int array[];

    SelectionSort(int size) {
        array = new int[size];
    }

    public void fillArray() {
        Random ran = new Random();
        for (int i = 0; i <= array.length - 1; i++) {
            array[i] = ran.nextInt(25);
        }
    }

    public void printArray() {
        System.out.println("----------------------------------");
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println("Index " + i + ": " + array[i]);
        }
    }

    public void selectionSort() {
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            int smallest = i;
            for (int j = i + 1; j < size; j++) {
                if (array[j] < array[smallest]) {
                    smallest = j;
                }
            }
            int temp = array[smallest];
            array[smallest] = array[i];
            array[i] = temp;
        }
    }

    public static void main(String args[]) {
        SelectionSort selection = new SelectionSort(10);
        selection.fillArray();
        selection.printArray();
        selection.selectionSort();
        selection.printArray();
    }
}
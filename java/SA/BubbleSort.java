package SA;

import java.util.Random;

class BubbleSort {
    private int[] array;
    private int size;

    BubbleSort(int size) {
        array = new int[size];
    }

    public void fillArray() {
        Random ran = new Random();
        int number = ran.nextInt(100);
        System.out.println(number);
    }

    public static void main(String args[]) {
        BubbleSort bubbleSort = new BubbleSort(10);
        bubbleSort.fillArray();
    }
}

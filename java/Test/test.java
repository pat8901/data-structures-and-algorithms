package Test;

import java.util.Random;

class Test {
    public static void main(String args[]) {

        Random number = new Random();
        int[] array = new int[10];
        int key = 10;

        for (int i = 0; i < array.length; i++) {
            array[i] = number.nextInt(25);
        }

    }

    public static void bubble(int[] array) {

    }

    public static void insertion(int[] array) {

    }

    public void selection(int[] array) {

    }

    public static int binary(int[] array, int key) {

        return -1;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }
}
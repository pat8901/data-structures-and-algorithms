package Search_Algorithms;

import java.util.Random;

class LinearSearch {
    private int array[];
    int key;

    LinearSearch(int size, int search_key) {
        array = new int[size];
        key = search_key;
    }

    public void fillArray() {
        Random random_number = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = random_number.nextInt(20);
        }

    }

    public void printArray() {
        System.out.println("------------------------------------");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);

    }

    public int linearSearch() {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        LinearSearch linear = new LinearSearch(10, 5);
        linear.printArray();
        linear.fillArray();
        linear.printArray();
        System.out.println(linear.linearSearch());
    }
}
package Search_Algorithms;

class BinarySearch {
    private int array[];
    private int key;

    BinarySearch(int size, int search_key) {
        array = new int[size];
        key = search_key;
    }

    public void fillArray() {
        for (int i = 0, k = 0; i < array.length; i++, k += 2) {
            array[i] = k;
        }

    }

    public void printArray() {
        System.out.println("------------------------------------");
        for (int i = 0; i < array.length - 1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);

    }

    public int binarySearch() {
        int left = 0;
        int right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            System.out.println("mid:" + mid);
            if (array[mid] == key) {
                return mid;
            }
            if (key < array[mid]) {
                right = mid - 1;
            }
            if (key > array[mid]) {
                left = mid + 1;
            }

        }
        return -1;
    }

    public static void main(String args[]) {
        BinarySearch binary = new BinarySearch(10, 6);
        binary.printArray();
        binary.fillArray();
        binary.printArray();
        System.out.println(binary.binarySearch());
    }
}

package Data_Structures;

import java.util.ArrayList;

// Will need a arraylist
// optimal load factor isi .7?

class HashTable {

    public ArrayList<ArrayList<HashNode>> container;
    public int capacity;
    public float load_factor;
    public SingleLinkedList[] array;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.array = new SingleLinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            array[i] = new SingleLinkedList();
        }
    }

    public class HashNode {
        int key;
        String value;
        HashNode next;

        public HashNode(int key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hash(int key) {
        int hash_number = key * 22;
        return hash_number;
    }

    public int compress(int hash, int size) {
        int index = hash % size;
        return index;
    }

    public int retrieve(int key) {
        return 1;
    }

    public int insert(int key, String name) {
        HashNode node = new HashNode(key, "James");
        int hash = hash(key);
        int compress = compress(hash, capacity);
        array[compress].append(node);
        return 1;
    }

    public void delete(int key) {

    }

    public void resize(SingleLinkedList[] array) {

    }

    public static void main(String args[]) {
        HashTable table = new HashTable(10);

        for (int i = 0; i < table.capacity; i++) {
            System.out.println(i + ": " + table.array[i]);
            table.array[i].getHead();
        }
    }
}

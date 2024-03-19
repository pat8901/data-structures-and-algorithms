package Hash;

// Will need a arraylist
// optimal load factor is .7?
// I will not implement my own hash function for now. So in the future learn how to make a simple good hash function

class HashMap<K, V> {

    private int current_size;
    private int capacity;
    private double load_factor;
    private HashNode<K, V>[] buckets;

    public HashMap(int capacity) {
        this.current_size = 0;
        this.load_factor = 0.7;
        this.capacity = capacity;
        this.buckets = new HashNode[capacity];
    }

    public class HashNode<K, V> {
        private K key;
        private V value;
        private HashNode<K, V> next;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    private int hash(K key) {
        int hash_number = key.hashCode();
        return hash_number;
    }

    public V retrieve(K key) {
        int hash = hash(key);
        int index = hash % this.capacity;
        HashNode<K, V> temp = buckets[index];

        if (temp == null) {
            return null;
        }
        while (temp != null) {
            if (temp.key == key) {
                return temp.value;
            }
            temp = temp.next;
        }

        return null;
    }

    public double getLoad() {
        double load = (double) this.current_size / this.capacity;
        System.out.println("current size: " + this.current_size + "capacity: " + this.capacity + "load: " + load);
        return load;
    }

    public void insert(K key, V value) {
        int hash = hash(key);
        int index = hash % this.capacity;
        HashNode<K, V> temp = buckets[index];

        if (getLoad() > this.load_factor) {
            buckets = rehash(buckets);
            System.out.println("New size: " + this.capacity);
        }
        if (temp == null) {
            buckets[index] = new HashNode<K, V>(key, value);
            current_size++;
        } else {
            while (temp.next != null) {
                if (temp.getValue() == value) {
                    temp.setValue(value);
                    return;
                }
                temp = temp.next;
            }
            if (temp.getValue() == value) {
                temp.setValue(value);
                return;
            }
            temp.next = new HashNode<K, V>(key, value);
            current_size++;
        }
    }

    public V delete(K key) {
        int hash = hash(key);
        int index = hash % this.capacity;
        HashNode<K, V> temp = buckets[index];

        if (temp == null) {
            System.out.println("is null");
            return null;
        }
        if (temp.key.equals(key)) {
            V value = temp.value;
            buckets[index] = temp.next;
            temp.next = null; // not sure if this is needed. I need to need to know more how java garb
                              // collection works
            current_size--;
            return value;
        }
        HashNode<K, V> prev = temp;
        temp = temp.next;
        while (temp != null) {
            if (temp.key == key) {
                V value = temp.value;
                prev.next = temp.next;
                temp.next = null;
                current_size--;
                return value;
            }
            prev = temp;
            temp = temp.next;
        }
        return null;
    }

    // Still need to implement the code that will rehash the values to the proper
    // locations since tha has is now different
    public HashNode<K, V>[] rehash(HashNode<K, V>[] buckets) {
        this.capacity = this.capacity * 2;
        HashNode<K, V>[] temp = new HashNode[this.capacity];

        for (int i = 0; i < buckets.length; i++) {
            temp[i] = buckets[i];
        }

        return temp;
    }

    public void printHashMap() {
        System.out.println("=======================================");
        for (int i = 0; i < this.capacity; i++) {
            HashNode<K, V> temp = buckets[i];
            System.out.print(i + ": ");
            if (temp == null) {
                System.out.println("null");
                continue;
            }
            while (temp != null) {
                System.out.print("{" + temp.key + "," + temp.value + "} " + "-> ");
                temp = temp.next;
            }
            System.out.println("null");
        }
    }

    public static void main(String args[]) {
        HashMap<Integer, String> map = new HashMap<>(10);
        map.printHashMap();
        System.out.println("Current Size: " + map.current_size);

        map.insert(70, "kevin");
        map.insert(1232, "Joe");
        map.insert(4328, "John");
        map.insert(1, "Charlie");
        map.insert(2, "Rick");
        map.insert(2, "Luke");
        map.printHashMap();
        System.out.println("Current Size: " + map.current_size);

        map.insert(97934, "Sally");
        map.insert(9432, "Kyle");
        System.out.println("Current Size: " + map.current_size);
        map.insert(3232, "jerry");
        map.insert(854287843, "kerry");
        map.insert(90419043, "tyler");
        map.insert(832, "rose");
        map.insert(90459045, "pat");
        map.printHashMap();
        map.insert(3432, "Richard");
        map.insert(7851, "Luck");
        map.insert(4324, "Keb");
        System.out.println("Current Size: " + map.current_size);
        System.out.println("capacity:" + map.capacity);
        map.insert(3201, "fndsf");

        map.printHashMap();

    }

}

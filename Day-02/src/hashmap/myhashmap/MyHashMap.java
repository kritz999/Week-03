package hashmap.myhashmap;
import java.util.LinkedList;
public class MyHashMap {
    class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private LinkedList<Node>[] map;
    private final int SIZE = 1000; // Initial size of the hash map

    // Constructor to initialize the map
    public MyHashMap() {
        map = new LinkedList[SIZE];
        for (int i = 0; i < SIZE; i++) {
            map[i] = new LinkedList<>();
        }
    }

    // Hash function to compute index from key
    private int hash(int key) {
        return key % SIZE;
    }

    // Insert or update a key-value pair
    public void put(int key, int value) {
        int index = hash(key);
        LinkedList<Node> bucket = map[index];

        // Check if the key already exists in the bucket
        for (Node node : bucket) {
            if (node.key == key) {
                node.value = value;  // Update the value if the key exists
                return;
            }
        }

        // If key does not exist, add a new node
        bucket.add(new Node(key, value));
    }

    // Retrieve the value for a given key
    public int get(int key) {
        int index = hash(key);
        LinkedList<Node> bucket = map[index];

        // Search for the key in the bucket
        for (Node node : bucket) {
            if (node.key == key) {
                return node.value;  // Return value if found
            }
        }

        // Return -1 if the key doesn't exist
        return -1;
    }

    // Delete a key-value pair
    public void remove(int key) {
        int index = hash(key);
        LinkedList<Node> bucket = map[index];

        // Search for the key and remove it if found
        for (Node node : bucket) {
            if (node.key == key) {
                bucket.remove(node);
                return;
            }
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();

        // Inserting key-value pairs
        hashMap.put(1, 100);
        hashMap.put(2, 200);
        hashMap.put(3, 300);

        // Retrieving values
        System.out.println("Value for key 1: " + hashMap.get(1)); // Output: 100
        System.out.println("Value for key 2: " + hashMap.get(2)); // Output: 200

        // Removing a key
        hashMap.remove(2);
        System.out.println("Value for key 2 after removal: " + hashMap.get(2)); // Output: -1
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

    // List to store elements for O(1) random access
    List<Integer> arr;

    // Map to store value -> index in the list
    Map<Integer, Integer> hmap;

    // Random generator
    Random rand;

    // Initialize the data structure
    public RandomizedSet() {
        arr = new ArrayList<>();
        hmap = new HashMap<>();
        rand = new Random();
    }

    // Inserts a value if it is not already present
    public boolean insert(int val) {

        // If value already exists, insertion fails
        if (hmap.containsKey(val)) {
            return false;
        }

        // Add value to the list
        arr.add(val);

        // Store its index in the map
        hmap.put(val, arr.size() - 1);

        return true;
    }

    // Removes a value if it exists
    public boolean remove(int val) {

        // If value does not exist, removal fails
        if (!hmap.containsKey(val)) {
            return false;
        }

        // Get index of the value to remove
        int index = hmap.get(val);

        // Get the last element in the list
        int lastValue = arr.get(arr.size() - 1);

        // Move last element to the index of the element being removed
        arr.set(index, lastValue);
        hmap.put(lastValue, index);

        // Remove the last element
        arr.remove(arr.size() - 1);

        // Remove value from the map
        hmap.remove(val);

        return true;
    }

    // Returns a random element from the set
    public int getRandom() {

        // Generate random index
        int randomIndex = rand.nextInt(arr.size());

        // Return element at that index
        return arr.get(randomIndex);
    }
}

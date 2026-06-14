import java.util.ArrayList;

/**
 * A generic bag (multiset) data structure backed by an ArrayList.
 * Allows duplicate elements, each stored as its own separate entry.
 * Does not enforce any particular ordering.
 */
public class Bag<T> {

    // Internal ArrayList — duplicates are stored as separate entries,
    // each at their own index position, not merged or counted together.
    private ArrayList<T> items;

    // Constructor — initializes the bag with an empty ArrayList.
    public Bag() {
        items = new ArrayList<>();
    }

    // add(T item)
    // Adds one occurrence of item to the bag.
    // Each duplicate gets its own index position — adding "Harry Potter"
    // three times creates three separate entries, not one entry of count 3.
    public void add(T item) {
        items.add(item);
    }

    // remove(T item)
    // Removes only the FIRST occurrence of item (lowest index position).
    // Remaining duplicates are unaffected. If item does not exist,
    // no change is made and no error is thrown.
    public void remove(T item) {
        items.remove(item);
    }

    // contains(T item)
    // Returns true if at least one occurrence of item exists; false otherwise.
    // Does not distinguish between one occurrence or many — use count()
    // if the exact number of occurrences matters.
    public boolean contains(T item) {
        return items.contains(item);
    }

    // count(T item)
    // Returns the total number of occurrences of item across all index positions.
    // Iterates the full list and increments a counter on each match.
    // Returns 0 if item does not exist.
    public int count(T item) {
        int occurrences = 0;

        for (T current : items) {
            if (current.equals(item)) {
                occurrences++;
            }
        }

        return occurrences;
    }

    // size()
    // Returns the total number of entries in the bag, including all duplicates.
    // Each duplicate counts as its own entry — size() reflects the true
    // number of index positions occupied, not the number of unique items.
    public int size() {
        return items.size();
    }

    // display()
    // Prints every entry alongside its actual index position (starting at 0).
    // Duplicates appear as separate lines at separate index positions,
    // showing that the bag treats each occurrence independently.
    public void display() {
        if (items.isEmpty()) {
            System.out.println("(The bag is empty)");
            return;
        }

        for (int i = 0; i < items.size(); i++) {
            System.out.println("Index position " + i + ": " + items.get(i));
        }
    }

    // merge(Bag<T> otherBag)
    // Adds every entry from otherBag into the current bag, including duplicates.
    // otherBag is not modified — only the current bag grows.
    // After merging, size() will equal the combined total of both bags.
    public void merge(Bag<T> otherBag) {
        for (T item : otherBag.items) {
            this.items.add(item);
        }
    }

    // distinct()
    // Returns a new Bag containing only one occurrence of each unique item.
    // Checks each entry against the new bag before adding — skips it if
    // already present. The original bag is not modified.
    public Bag<T> distinct() {
        Bag<T> distinctBag = new Bag<>();

        for (T item : items) {
            if (!distinctBag.contains(item)) {
                distinctBag.add(item);
            }
        }

        return distinctBag;
    }
} // end class Bag
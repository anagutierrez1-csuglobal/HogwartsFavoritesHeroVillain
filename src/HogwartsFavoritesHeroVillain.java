/**
 * HogwartsFavoritesHeroVillain.java
 * Part 1: add, display, contains, count, remove, and post-removal verification.
 * Part 2: size, merge, and distinct across two bags of characters.
 */
public class HogwartsFavoritesHeroVillain {

    public static void main(String[] args) {

        // Create the Bag and pre-load 10 Harry Potter characters
        // Changed the default characters to standard "heroes"
        Bag<String> favoriteCharacters = new Bag<>();

        favoriteCharacters.add("Harry Potter");
        favoriteCharacters.add("Hermione Granger");
        favoriteCharacters.add("Ron Weasley");
        favoriteCharacters.add("Albus Dumbledore");
        favoriteCharacters.add("Severus Snape");
        favoriteCharacters.add("Luna Lovegood");
        favoriteCharacters.add("Neville Longbottom");
        favoriteCharacters.add("Sirius Black");
        favoriteCharacters.add("Dobby");
        favoriteCharacters.add("Minerva McGonagall");


        // STEP 1: Print the initial bag contents
        printHeader("STEP 1: Initial Bag Contents");
        System.out.println("Total entries: " + favoriteCharacters.size());
        favoriteCharacters.display();


        // STEP 2: Add duplicates and a new character to show the bag allows both
        printHeader("STEP 2: Adding Elements (Including Duplicates)");
        favoriteCharacters.add("Harry Potter");
        System.out.println("Added: Harry Potter (duplicate)");
        favoriteCharacters.add("Harry Potter");
        System.out.println("Added: Harry Potter (duplicate again)");
        favoriteCharacters.add("Dobby");
        System.out.println("Added: Dobby (duplicate)");
        favoriteCharacters.add("Ginny Weasley");
        System.out.println("Added: Ginny Weasley (new entry)");
        System.out.println("Bag now contains " + favoriteCharacters.size() + " entries.");


        // STEP 3: Print bag contents after additions
        printHeader("STEP 3: Bag Contents After Additions");
        System.out.println("Total entries: " + favoriteCharacters.size());
        favoriteCharacters.display();


        // STEP 4: Test contains() — one occurrence, multiple occurrences, never added
        printHeader("STEP 4: Testing contains()");
        System.out.println("contains(\"Hermione Granger\")  -->  " + favoriteCharacters.contains("Hermione Granger"));  // true, present once
        System.out.println("contains(\"Harry Potter\")      -->  " + favoriteCharacters.contains("Harry Potter"));      // true, present multiple times
        System.out.println("contains(\"Ginny Weasley\")      -->  " + favoriteCharacters.contains("Ginny Weasley"));      // true, added in Step 2
        System.out.println("contains(\"Lord Voldemort\")    -->  " + favoriteCharacters.contains("Lord Voldemort"));    // false, never added


        // STEP 5: Test count() — returns 0 for absent, 1 for unique, >1 for duplicates
        printHeader("STEP 5: Testing count()");
        System.out.println("count(\"Harry Potter\")      -->  " + favoriteCharacters.count("Harry Potter"));    // 3: once at setup + twice in Step 2
        System.out.println("count(\"Dobby\")             -->  " + favoriteCharacters.count("Dobby"));           // 2: once at setup + once in Step 2
        System.out.println("count(\"Hermione Granger\")  -->  " + favoriteCharacters.count("Hermione Granger")); // 1: added once, no duplicates
        System.out.println("count(\"Lord Voldemort\")    -->  " + favoriteCharacters.count("Lord Voldemort"));  // 0: never added


        // STEP 6: Remove one occurrence of "Harry Potter" — only the first occurrence is removed
        printHeader("STEP 6: Removing One Occurrence of \"Harry Potter\"");
        System.out.println("Before removal -- count(\"Harry Potter\"): " + favoriteCharacters.count("Harry Potter"));
        favoriteCharacters.remove("Harry Potter");
        System.out.println("After removal  -- count(\"Harry Potter\"): " + favoriteCharacters.count("Harry Potter"));


        // STEP 7: Print bag contents after removal
        printHeader("STEP 7: Bag Contents After Removal");
        System.out.println("Total entries: " + favoriteCharacters.size());
        favoriteCharacters.display();


        // STEP 8: contains() should still return true — 2 occurrences remain after removal
        printHeader("STEP 8: Testing contains() After Removal");
        System.out.println("contains(\"Harry Potter\")  -->  " + favoriteCharacters.contains("Harry Potter"));


        // STEP 9: count() should return 2 — was 3 before removal, decremented by 1
        printHeader("STEP 9: Testing count() After Removal");
        System.out.println("count(\"Harry Potter\")  -->  " + favoriteCharacters.count("Harry Potter"));


        System.out.println("\n=======================================================");
        System.out.println("  Original Demonstration complete. Mischief Managed!");
        System.out.println("=======================================================");

        // ---------------------------------------------------------------
        // PART 2: size(), merge(), and distinct()
        // Two bags are created — heroes and villains — then merged and
        // reduced to distinct entries to demonstrate the new methods.
        // ---------------------------------------------------------------

        // Create two bags and add characters including deliberate duplicates
        Bag<String> heroesBag = new Bag<>();
        Bag<String> villainsBag = new Bag<>();

        // Heroes bag — some duplicates included across both bags intentionally
        heroesBag.add("Harry Potter");
        System.out.println("Added to heroesBag: Harry Potter");
        heroesBag.add("Hermione Granger");
        System.out.println("Added to heroesBag: Hermione Granger");
        heroesBag.add("Ron Weasley");
        System.out.println("Added to heroesBag: Ron Weasley");
        heroesBag.add("Neville Longbottom");
        System.out.println("Added to heroesBag: Neville Longbottom");
        heroesBag.add("Luna Lovegood");
        System.out.println("Added to heroesBag: Luna Lovegood");
        heroesBag.add("Harry Potter");   // duplicate within heroesBag
        System.out.println("Added to heroesBag: Harry Potter (duplicate)");

        // Villains bag — Harry Potter added intentionally as a cross-bag duplicate for distinct() demo
        villainsBag.add("Lord Voldemort");
        System.out.println("Added to villainsBag: Lord Voldemort");
        villainsBag.add("Draco Malfoy");
        System.out.println("Added to villainsBag: Draco Malfoy");
        villainsBag.add("Bellatrix Lestrange");
        System.out.println("Added to villainsBag: Bellatrix Lestrange");
        villainsBag.add("Dolores Umbridge");
        System.out.println("Added to villainsBag: Dolores Umbridge");
        villainsBag.add("Peter Pettigrew");
        System.out.println("Added to villainsBag: Peter Pettigrew");
        villainsBag.add("Draco Malfoy");   // duplicate within villainsBag
        System.out.println("Added to villainsBag: Draco Malfoy (duplicate)");
        villainsBag.add("Harry Potter");   // intentional cross-bag duplicate for demo purposes
        System.out.println("Added to villainsBag: Harry Potter (cross-bag duplicate)");


        // STEP 10: Print size of each bag before merging
        printHeader("STEP 10: Size of Each Bag");
        System.out.println("heroesBag size()   -->  " + heroesBag.size());    // 6: 5 unique + 1 duplicate
        System.out.println("villainsBag size() -->  " + villainsBag.size());  // 7: 5 unique + 2 duplicates


        // STEP 11: Display each bag's contents before merging
        printHeader("STEP 11: heroesBag Contents Before Merge");
        heroesBag.display();

        printHeader("STEP 11: villainsBag Contents Before Merge");
        villainsBag.display();


        // STEP 12: Merge villainsBag into heroesBag where all entries including duplicates are added
        printHeader("STEP 12: Merging villainsBag into heroesBag");
        heroesBag.merge(villainsBag);
        System.out.println("Merge complete. heroesBag now contains " + heroesBag.size() + " entries.");
        System.out.println("villainsBag is unchanged at " + villainsBag.size() + " entries.");


        // STEP 13: Display merged bag contents
        printHeader("STEP 13: Merged Bag Contents");
        System.out.println("Total entries: " + heroesBag.size());
        heroesBag.display();


        // STEP 14: Create a distinct bag — one occurrence of each unique item only
        printHeader("STEP 14: Distinct Bag Contents");
        Bag<String> distinctCharacters = heroesBag.distinct();
        System.out.println("Distinct entries: " + distinctCharacters.size()
                + " (down from " + heroesBag.size() + " after duplicates removed)");
        distinctCharacters.display();


        System.out.println("\n=======================================================");
        System.out.println("  Part 2 complete. Now let's clear the system. Evanesco!");
        System.out.println("=======================================================");

    } // end main

    // printHeader(String title)
    // Prints a labeled section divider to the console.
    // Used to visually separate each step in the output.
    static void printHeader(String title) {
        System.out.println("\n=======================================================");
        System.out.println("  " + title);
        System.out.println("=======================================================");
    }
} // end class HogwartsFavorites
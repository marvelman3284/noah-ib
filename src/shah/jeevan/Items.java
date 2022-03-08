package shah.jeevan;

import java.util.*;

public class Items {

    public static void Create(HashMap<String, Integer> dict, String k, int v) {
        dict.put(k, v);
    }

    public static void Add(Scanner sc, HashMap<String, Integer> items_dict, HashMap<String, List<String>> people_dict) {
        System.out.println("Enter the name of the person checking out an item: ");
        String person = sc.nextLine();

        System.out.println("What item(s) is " + person + " checking out? (Separate multiple items with spaces) ");
        String items = sc.nextLine();

        String[] split = items.split("[ ]");
        ArrayList<String> items_list = new ArrayList<>();

        for (String item : split) {
            int count = items_dict.get(item.toLowerCase());
            System.out.println("How many " + item + "s is " + person + " checking out?(1-" + count + ")");
            count = sc.nextInt();

            for (int i = 0; i < count; i++) {
                items_list.add(item);
            }

            if (items_dict.containsKey(item)) {
                items_dict.put(item, items_dict.get(item) - count);
            }
        }

        people_dict.put(person, items_list);
        System.out.println("Successfully check out items for " + person);
    }

    public static void View(HashMap<String, Integer> items_dict, HashMap<String, List<String>> people_dict, Scanner sc) {
        System.out.println("Would you like to view total item counts or person specific counts? (T/V): ");
        String choice = sc.nextLine();

        if (choice.equalsIgnoreCase("t")) {
            Set<String> items_keys = items_dict.keySet();

            for (String s : items_keys) {
                int count = items_dict.get(s);
                System.out.println("There are " + (100-count) + " " + s + "s currently checked out. Which means that there are " + count + " " + s + "s left in stock.");
            }

            System.out.println(items_dict);
        } else if (choice.equalsIgnoreCase("s")) {
            System.out.println("Who would you like to check stock for?");
            for (String name : people_dict.keySet()) {
                System.out.println(name);
            }

            String person = sc.nextLine();

            while (!(people_dict.containsKey(person))) {
                System.out.println("Sorry, that person doesn't exist.");
                for (String name : people_dict.keySet()) {
                    System.out.println(name);
                }
                person = sc.nextLine();
            }

            for (String item : people_dict.get(person)) {
                System.out.println(person + " has " + (Collections.frequency(people_dict.get(person), item)) + " " + item + " checked out.");
            }
        }
    }
}

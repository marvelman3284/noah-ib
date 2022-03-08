package shah.jeevan;

import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> items_dict = new HashMap<>();
        HashMap<String, List<String>> people_dict = new HashMap<>();

        items_dict.put("sabre", 100);
        items_dict.put("mask", 100);
        items_dict.put("epee", 100);
        items_dict.put("foil", 100);


        System.out.println("Would you like to add, remove or view an item? (A/R/V/E): ");
        String choice = sc.nextLine();

        while (!choice.equalsIgnoreCase("e")) {
            // TODO: use switch case statement instead
            if (choice.equalsIgnoreCase("A")) {
                Items.Add(sc, items_dict, people_dict);
            } else if (choice.equalsIgnoreCase("V")) {
                Items.View(items_dict, people_dict, sc);
            }
            System.out.println("Would you like to add, remove or view an item? (A/R/V/E): ");
            choice = sc.nextLine();
        }
    }
}

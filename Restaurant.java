import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Scanner;

public class Restaurant {
	public static void main(String[] args) {
		
		Hashtable <String, Integer> menu = new Hashtable<>();
		menu.put("dumplings", 10);
		menu.put("pizza", 15);
		menu.put("pie", 5);
		
		Scanner input = new Scanner(System.in);
		System.out.println("Hello Welcome to Restaurant! What would you like to order?\n"
				+ "Please choose an item from the menu below and enter the item followed by the quantity.\n"
				+ "For example: Dumplings 2\n\n"
				+ "Here is the menu:");
		for(String key : menu.keySet()) {
			System.out.println(key + "\t" + menu.get(key));
		}
		System.out.println("\nEnter your first item and quantity: ");
		
		String item = input.nextLine();
		ArrayList<String> order = new ArrayList<>();
		order.add(item);
		
		while(!item.equals("f")) {
			System.out.println("Enter your next item and quantity or enter f to finish ordering: ");
			item = input.nextLine();
			if(!item.equals("f")) {
				order.add(item);
			}
		}
		
		Waiter wait1 = new Waiter(1, menu);
		System.out.println(wait1.takeOrder(order, 1));
		
		System.out.println("When you are ready for your food, enter r: ");
		while(!input.nextLine().equals("r")) {
			System.out.println("When you are ready for your food, enter r: ");
		}
		System.out.println("Here is your order: \n");
		wait1.deliverOrder(1);

		
	}
}

import java.util.ArrayList;
import java.util.Hashtable;

public class Waiter {
	
	int id = 0;
	Hashtable<Integer, ArrayList<String>> orders = new Hashtable<>();
	Hashtable<String, Integer> menu = new Hashtable<>();
	
	public Waiter(int id, Hashtable<String, Integer> menu) {
		this.id = id;
		this.menu = menu;
	}
	
	public String takeOrder(ArrayList<String> order, int table) {
		ArrayList<String> check = new ArrayList<>();
		int total = 0;
		
		for(String item : order) {
			String[] line = item.split(" ");
			String name = line[0];
			int quantity = Integer.parseInt(line[1]);
			int cost = menu.get(name);
			for(int i = 0; i < quantity; i++) {
				check.add(name);
				total += cost;
			}
		}
		check.add("Your total is: $" + String.valueOf(total));
		this.orders.put(table, check);

		return "Thank you! You're order has been placed!";
	}
	
	public void deliverOrder(int table) {
		ArrayList<String> order = orders.get(table);
		for(String item: order) {
			System.out.println(item);
		}
	}

}

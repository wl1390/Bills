// clear README.md: run code, run test, get coverage reports
// unit tests
// user interface for the retail store


package test;

import model.Category;
import model.Item;
import model.Store;
import model.User;

import java.util.ArrayList;

public class Simulation{

	public static void main(String[] args){
	
		Store store1 = new Store("Store 1");
		Store store2 = new Store("Store 2");
		User user1 = new User("User 1");
		User user2 = new User("User 2");
		User user3 = new User("User 3");
		User user4 = new User("User 4");
	

		 
		store1.putOnSale(new Item("apple",10,Category.GROCERY));
		store1.putOnSale(new Item("phone",1000,Category.ELECTRONICS));
		store1.putOnSale(new Item("car",10000,Category.OTHER));

		store2.putOnSale(new Item("banana",100,Category.GROCERY));
		store2.putOnSale(new Item("pear",100,Category.GROCERY));
		store2.putOnSale(new Item("ball",100,Category.OTHER));

	
		 store1.employ(user2);
		 store1.affiliate(user1);
		 store2.addLoyalty(user2);


		// store.display();



		user1.enter(store1);
		user1.addToBasket("car");
		user1.addToBasket("phone");
		user1.addToBasket("apple");

		user1.enter(store2);
		user1.addToBasket("ball");
		
		user1.addToBasket("banana");

		user1.display();
		System.out.println(user1.getSum());



		user2.enter(store1);
		user2.addToBasket("apple");
		user2.enter(store2);
		user2.addToBasket("banana");





		user2.display();
		System.out.println(user2.getSum());


		System.out.println("Complete");
		
	}


}

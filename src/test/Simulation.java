package test;

import model.Category;
import model.Item;
import model.Store;
import model.User;

public class Simulation{

	public static void main(String[] args){
	
		Store fruitstore = new Store("Fruit Store");
		Store estore = new Store("Electronics Store");
		User fruitlover = new User("I LOVE EATING FRUITS");
		User techguy = new User("I LOVE TECH");

		System.out.println("Fruit store puts on sale apple and banana.");
		fruitstore.putOnSale(new Item("apple",10,Category.GROCERY));
		fruitstore.putOnSale(new Item("banana",10,Category.GROCERY));

		System.out.println("Fruitlover becomes loyalty in fruit store.");
		fruitstore.addLoyalty(fruitlover);

		System.out.println("Fruitlover enters fruit store.");
		fruitlover.enter(fruitstore);

		System.out.println("Fruitlover put 10 apples and 5 bananas into basket.");
		estore.employ(techguy);
		for (int i=0;i<10;i++){
			fruitlover.addToBasket("apple");
		}
		for (int i=0;i<5;i++){
			fruitlover.addToBasket("banana");
		}		

		System.out.println("Fruitlover should pay ( 10*10 + 5*10 ) - 5 = 145.");
		System.out.println("Fruitlover checks out and pays "+ fruitlover.getSum()+".");

		System.out.println();
		System.out.println("Electronics store puts on sale lap and phone.");
		estore.putOnSale(new Item("cellphone",1000,Category.ELECTRONICS));
		estore.putOnSale(new Item("laptop",10000,Category.ELECTRONICS));
		
		System.out.println("Electronics Store hires techguy.");
		estore.employ(techguy);

		System.out.println("Techguy enters Electronics store.");
		techguy.enter(estore);

		System.out.println("Techguy adds a laptop into basket.");
		techguy.addToBasket("laptop");

		System.out.println("Techguy is an employee and should pay (10000*0.7) - 70*5 = 6650.");
		System.out.println("Techguy pays "+techguy.getSum()+".");


		System.out.println();
		System.out.println("Complete");
		
	}


}

package test.unit;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import model.Category;
import model.Item;
import model.Store;
import model.User;

public class StoreTest{

	private User user1;
	private User user2;
	private Store store;

	@Before
	public void setup(){
		user1= new User("Spiderman");
		user2 = new User("BlackPanther");
		store = new Store("Avenger Shop");
	}

	@Test
	public void testEmploy(){
		store.employ(user1);
		assertTrue(store.getEmployee().contains(user1));
	}

	@Test
	public void testPutOnSale(){
		Item suit = new Item("Black Panther's fight suit", 200, Category.OTHER);
		store.putOnSale(suit);
		assertTrue(store.getSales().contains(suit));
	}

	@Test
	public void testGetDiscountPercent(){
		store.employ(user1);
		store.addLoyalty(user1);
		assertTrue(store.getDiscountPercent(user1)==0.7);
	}
	
	@Test
	public void testOnlyOneDiscount(){
		store.affiliate(user2);
		store.addLoyalty(user2);
		assertTrue(store.getDiscountPercent(user2)==0.9);
	}
	
	@Test
	public void testCheckOut(){
		Item food = new Item("food",10.0, Category.GROCERY);
		Item football = new Item("football",10.0, Category.OTHER);
		ArrayList<Item> items = new ArrayList<>();
		items.add(food);
		items.add(football);
		
		assertTrue(store.checkOut(user1, items)==20);
	}
	
	@Test
	public void testMinusFivePerHundred(){
		Item drink = new Item("drink",299.0, Category.GROCERY);
		ArrayList<Item> items = new ArrayList<>();
		items.add(drink);
		
		assertTrue(store.checkOut(user1, items)==289);
	}
	
	@Test
	public void testNoDiscountOnGrocery(){
		Item carrot = new Item("Carrot",99.0, Category.GROCERY);
		ArrayList<Item> items = new ArrayList<>();
		items.add(carrot);

		store.employ(user1);
		assertTrue(store.checkOut(user1, items)==99);

	}


}
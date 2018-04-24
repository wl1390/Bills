package test.unit;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import model.Category;
import model.Item;
import model.Store;
import model.User;

public class UserTest{

	private User user;
	private Store store;

	@Before
	public void setup(){
		user = new User("Thor");
		store = new Store("Avenger Shop");
	}

	@Test
	public void testGetName(){
		assertEquals(user.getName(),"Thor");
	}

	@Test
	public void testEnterStore(){
		user.enter(store);
		assertEquals(user.getCurrentStore(),store);
	}
	
	@Test
	public void testGetEmployed(){
		user.getEmployed(store);
		assertEquals(user.getEmployer(),store);
	}

	@Test
	public void testAddToBasketOne(){
		Item hammer = new Item("Thor's hammer",100.0, Category.GROCERY);
		store.putOnSale(hammer);

		user.enter(store);
		user.addToBasket("Thor's hammer");

		assertEquals(hammer,user.getBasket().get(store).get(0));
	}

	@Test (expected = NullPointerException.class)
	public void testAddToBasketBeforeEnterStore(){
		Item hammer = new Item("Thor's hammer",100.0, Category.GROCERY);
		store.putOnSale(hammer);
		user.addToBasket("Thor's hammer");
	}

	@Test (expected = IndexOutOfBoundsException.class)
	public void testAddToBasketWhenNothingOnSale(){
		Item hammer = new Item("Thor's hammer",100.0, Category.GROCERY);
		user.addToBasket("Thor's hammer");
	}

	@Test
	public void testGetSumOne(){
		Item hammer = new Item("Thor's hammer",100.0, Category.GROCERY);
		store.putOnSale(hammer);
		user.addToBasket("Thor's hammer");
		assertEquals(user.getSum(),95);
	}

	@Test
	public void testGetSumTwo(){
		Item helmet = new Item("helmet",100.0, Category.OTHER);
		store.putOnSale(helmet);
		store.employ(user);
		user.addToBasket("helmet");
		assertEquals(user.getSum(),70);

	}
	




}
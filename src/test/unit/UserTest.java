package test.unit;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertTrue;
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
	public void testComeAndGo(){
		user.enter(store);
		Store store2 = new Store("SHEILD store");
		user.enter(store2);
		assertEquals(user.getCurrentStore(),store2);
	}
	
	@Test
	public void testGetEmployed(){
		user.getEmployed(store);
		assertEquals(user.getEmployer(),store);
	}
	
	@Test
	public void testGetAlliated(){
		user.getAffiliated(store);
		assertTrue(user.getAffiliate().contains(store));
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

	@Test
	public void testAddToBasketWhenNothingOnSale(){
		user.enter(store);
		user.addToBasket("Thor's hammer");
		assertTrue(user.getSum()==0);
	}

	@Test
	public void testGetSumOne(){
		Item hammer = new Item("Thor's hammer",100.0, Category.GROCERY);
		store.putOnSale(hammer);
		user.enter(store);
		user.addToBasket("Thor's hammer");
		assertTrue(user.getSum()==95);
	}

	@Test
	public void testGetSumTwo(){
		Item helmet = new Item("helmet",100.0, Category.OTHER);
		store.putOnSale(helmet);
		store.employ(user);
		user.enter(store);
		user.addToBasket("helmet");
		assertTrue(user.getSum()==70);
	}
	
}
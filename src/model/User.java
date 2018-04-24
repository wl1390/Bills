package model;

import java.util.ArrayList;
import java.util.HashMap;

public class User{
	private String name;
	private Store employer;
	private Store currentStore;
	private ArrayList<Store> affiliated = new ArrayList<>();
	private HashMap<Store, ArrayList<Item>> basket = new HashMap<>();

	public User(String name){
		this.name = name;
	}

	public String getName(){
		return this.name;
	}

	public HashMap<Store, ArrayList<Item>> getBasket(){
		return this.basket;
	}

	public Store getEmployer(){
		return this.employer;
	}
	
	public ArrayList<Store> getAffiliate() {
		return this.affiliated;
	}

	public Store getCurrentStore(){
		return this.currentStore;
	}

	public void enter(Store store){
		this.currentStore = store;
		//HERE WE COULD RETURN store.getSales() to the UI.
	}

	public void getEmployed(Store store){
		this.employer = store;
	}

	public void getAffiliated(Store store){
		this.affiliated.add(store);
	}

	public void addToBasket(String itemName){
		try{
			if (basket.get(currentStore)==null){
				basket.put(currentStore,new ArrayList<Item>());
			}

			for (Item item : currentStore.getSales()){
				if (item.getName() == itemName){
					basket.get(currentStore).add(item);
					break;
				}
			}



		}catch(NullPointerException e ){
			throw e;
		}

	}

	public double getSum(){
		double amount = 0;
		if(basket != null){
			for (Store store : basket.keySet()){
				amount += store.checkOut(this,basket.get(store));
			}
		}
		return amount;
	}


	@Override
	public String toString(){
		return this.name;
	}

	public void display(){
		System.out.println("User Info");
		System.out.println("name: "+this.name);
		System.out.println("employer: "+this.employer);
		System.out.println("affiliated: "+this.affiliated.toString());
		System.out.println("basket: "+this.basket.toString());
		System.out.println();
	}

}
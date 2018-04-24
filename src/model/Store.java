package model;

import java.util.ArrayList;

public class Store{

	private String name;
	private ArrayList<User> employee = new ArrayList<>();
	private ArrayList<User> affiliation = new ArrayList<>();
	private ArrayList<User> loyalty = new ArrayList<>(); 
	private ArrayList<Item> sales = new ArrayList<>();

	public Store(String name){
		this.name = name;
	}

	public ArrayList<User> getEmployee(){
		return this.employee;
	}

	public ArrayList<Item> getSales(){
		return sales;
	}

	public void employ(User user){
		this.employee.add(user);
		user.getEmployed(this);
	}

	public void affiliate(User user){
		this.affiliation.add(user);
		user.getAffiliated(this);
	}

	public void addLoyalty(User user){
		this.loyalty.add(user);
	}

	public void putOnSale(Item item){
		this.sales.add(item);
	}

	/*
		Takes a user and a list of items as arguments;
		Apply percentage based discount on each item;
		Apply minus 5 per 100 discount in the end;
		Returns the amount; 
	*/
	public double checkOut(User user, ArrayList<Item> items){
		
		double percent = getDiscountPercent(user);
		double amount = 0;

		for (Item item : items){
			amount += (item.getCategory()==Category.GROCERY) ? item.getCost() : item.getCost()*percent;
		}
		
		amount -= 5*Math.floor((amount/100));
		return amount;
	}

	//Takes a user as the argument and returns how much discount user should get
	public double getDiscountPercent(User user){
		double percent = 1;
		if (loyalty.contains(user)) percent = 0.95;
		if (affiliation.contains(user)) percent = 0.9;
		if (employee.contains(user)) percent = 0.7;
		return percent;
	}

	@Override
	public String toString(){
		return this.name;
	}

	public void display(){
		System.out.println("Store Info");
		System.out.println("name: "+this.name);
		System.out.println("employee: "+this.employee);
		System.out.println("affiliation: "+this.affiliation);
		System.out.println("loyalty: "+this.loyalty);
		System.out.println("sales: "+this.sales);
		System.out.println();
		
	}


}
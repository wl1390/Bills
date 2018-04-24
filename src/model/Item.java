package model;

public class Item{
	private String name;
	private double cost;
	private Category category;
	
	public Item(String name, double cost, Category category){
		this.name = name;
		this.cost = cost;
		this.category = category;
	}

	public double getCost(){
		return cost;
	}

	public String getName(){
		return name;
	}

	public Category getCategory(){
		return this.category;
	}


	@Override
	public String toString(){
		return this.name + " " + this.cost + " " + this.category;
	}


}
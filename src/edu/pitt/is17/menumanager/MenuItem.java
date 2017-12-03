package edu.pitt.is17.menumanager;

/**
 * Class MunuManager
 * @author ChuntzuL
 * @created:12/01/2017
 */

public class MenuItem {
	private String name;
	private String description;
	private int calories;
	private double price;
	
	public MenuItem(){
		
	}
	
	public MenuItem(String name, String desc, int cal, double price){
		super();
		this.name = name;
		this.description = desc;
		this.calories = cal;
		this.price = price;
	}
	
    public String toString(){
		
		return getName();
	}
	
	public double getPrice(){
		return this.price;
	}
	
	public void setPrice(double price){
		this.price=price;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCalories() {
		return calories;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

}

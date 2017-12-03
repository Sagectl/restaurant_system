package edu.pitt.is17.menumanager;

/**
 * Class MunuManager
 * @author ChuntzuL
 * @created:12/01/2017
 */

import java.util.ArrayList;

public class MenuManager {
	private ArrayList<Entree> entrees;
	private ArrayList<Side> sides;
	private ArrayList<Salad> salads;
	private ArrayList<Dessert> desserts;
	private ArrayList<MenuItem> menuItems;
	
	public MenuManager(String dishesFile){
		menuItems = FileManager.readItems(dishesFile);
		entrees = new ArrayList<Entree>();
		sides = new ArrayList<Side>();
		salads = new ArrayList<Salad>();
		desserts = new ArrayList<Dessert>();
		
		for(MenuItem m : menuItems){
			if( m instanceof Entree) entrees.add((Entree) m);
			if( m instanceof Side) sides.add((Side) m);
			if( m instanceof Salad) salads.add((Salad) m);
			if( m instanceof Dessert) desserts.add((Dessert) m);	
		}
	}
	

	public Menu randomMenu(){
			Menu res = null;
			
			int idx1 = (int)( Math.random()* entrees.size());
			int idx2 = (int)(Math.random()* sides.size());
			int idx3 = (int)(Math.random()* salads.size());
			int idx4 = (int)(Math.random()* desserts.size());
			
			res = new Menu("A random menu", entrees.get(idx1), sides.get(idx2), salads.get(idx3), desserts.get(idx4));
			 return res;
		}

	//minimum calories
	public Menu minCaloriesMenu(){
		Menu res = null;
		
		//int minEntree = entrees.get(1).getCalories();
		Entree minEntree = entrees.get(1);
		for( Entree elementEntree : entrees){
			if( minEntree.getCalories() > elementEntree.getCalories()){
				minEntree = elementEntree;
				
			}
		}
		
		//int minSide = sides.get(1).getCalories();
		Side minSide = sides.get(1);
		for( Side elementSide : sides){
			if( minSide.getCalories()  > elementSide.getCalories()){
				minSide  =elementSide;
			}
		}
		
		//int minSalad = salads.get(1).getCalories();
		Salad minSalad = salads.get(1);
		for( Salad elementSalad : salads){
			if( minSalad.getCalories() > elementSalad.getCalories()){
				minSalad =elementSalad;
			}
		}
		
		//int minDessert = desserts.get(1).getCalories();
		Dessert minDessert = desserts.get(1);
		for( Dessert elementDessert : desserts){
			if( minDessert.getCalories() > elementDessert.getCalories()){
				minDessert =elementDessert;
			}
		}
		
		res = new Menu("A minimal calories menu", minEntree, minSide, minSalad, minDessert);
		
		return res;
	}
	
	//maximum calories
	public Menu maxCaloriesMenu(){
		Menu res = null;
		
		Entree maxEntree = entrees.get(1);
		for( Entree elementEntree : entrees){
			if( maxEntree.getCalories() < elementEntree.getCalories()){
				maxEntree = elementEntree;
				
			}
		}
		
		Side maxSide = sides.get(1);
		for( Side elementSide : sides){
			if( maxSide.getCalories()  < elementSide.getCalories()){
				maxSide  =elementSide;
			}
		}

		Salad maxSalad = salads.get(1);
		for( Salad elementSalad : salads){
			if( maxSalad.getCalories() < elementSalad.getCalories()){
				maxSalad =elementSalad;
			}
		}
		
		
		Dessert maxDessert = desserts.get(1);
		for( Dessert elementDessert : desserts){
			if( maxDessert.getCalories() < elementDessert.getCalories()){
				maxDessert =elementDessert;
			}
		}
		
		res = new Menu("A maximal calories menu", maxEntree, maxSide, maxSalad, maxDessert);
		
		return res;
	}
	
	public Menu getMenuByIDs(String IDs){
		Menu res = null;
		
		String[] theIDs = IDs.split(",");
		
		Entree maxEntree = entrees.get(Integer.parseInt(theIDs[0]));

		Side maxSide = sides.get(Integer.parseInt(theIDs[1]));

		Salad maxSalad = salads.get(Integer.parseInt(theIDs[2]));	
		
		Dessert maxDessert = desserts.get(Integer.parseInt(theIDs[3]));
		
		res = new Menu("A maximal calories menu", maxEntree, maxSide, maxSalad, maxDessert);
		
		return res;
	}
	
	public ArrayList<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}

	public ArrayList<Side> getSides() {
		return sides;
	}

	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}

	public ArrayList<Salad> getSalads() {
		return salads;
	}

	public void setSalads(ArrayList<Salad> salads) {
		this.salads = salads;
	}

	public ArrayList<Dessert> getDesserts() {
		return desserts;
	}

	public void setDesserts(ArrayList<Dessert> desserts) {
		this.desserts = desserts;
	}

	public ArrayList<MenuItem> getMenuItems() {
		return menuItems;
	}

	public void setMenuItems(ArrayList<MenuItem> menuItems) {
		this.menuItems = menuItems;
	}

}

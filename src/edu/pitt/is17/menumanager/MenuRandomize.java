package edu.pitt.is17.menumanager;



/**
 * Class MenuRandomize
 * @author ChuntzuL
 * @created:11/27/2017
 */

import java.util.ArrayList;

public class MenuRandomize {
	private ArrayList<Entree> entrees;
	private ArrayList<Side> sides;
	private ArrayList<Salad> salads;
	private ArrayList<Dessert> desserts;
	
   /*
	public MenuRandomize(String entreeFile, String sideFile, String saladFile, String dessertFile){
		entrees = FileManager.readEntrees(entreeFile);
		sides = FileManager.readSides(sideFile);
		salads = FileManager.readSalads(saladFile);
		desserts = FileManager.readDesserts(dessertFile);
		
	}
	*/
	
	/**
	 * Method Random
	 *
	 * @return random one of each menu
	 */

	public Menu randomMenu(){
		Menu res = null;
		
		int idx1 = (int)( Math.random()* entrees.size());
		int idx2 = (int)(Math.random()* sides.size());
		int idx3 = (int)(Math.random()* salads.size());
		int idx4 = (int)(Math.random()* desserts.size());
		
		res = new Menu("A random menu", entrees.get(idx1), sides.get(idx2), salads.get(idx3), desserts.get(idx4));
		 return res;
	}
}

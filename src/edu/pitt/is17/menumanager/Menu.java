package edu.pitt.is17.menumanager;

/**
 * Class Menu
 * @author ChuntzuLiu
 * @created:10/25/2017
 *
 */

public class Menu {
	private String name;
	private Entree entree;
	private Salad salad;
	private Side side;
	private Dessert dessert;

	public Menu(String name){
		this.name=name;
		this.entree=null;
		this.side=null;
		this.salad=null;
		this.dessert=null;
	}
	

	public Menu(String name, Entree entree, Side side){
		this.name=name;
		this.entree=entree;
		this.side=side;
		this.salad=null;
		this.dessert=null;
	}

	public Menu(String name, Entree entree, Side side, Salad salad, Dessert dessert){
		this.name=name;
		this.entree=entree;
		this.side=side;
		this.salad=salad;
		this.dessert=dessert;
	}

	public int totalCalories(){
		int sumOfCalories = 0;
		if(entree != null) sumOfCalories+=entree.getCalories();
		if(side != null) sumOfCalories+=side.getCalories();
		if(salad != null)  sumOfCalories+=salad.getCalories();
		if(dessert != null)  sumOfCalories+=dessert.getCalories();

		return sumOfCalories;
	}

	public String description(){
		String desc = "";

		desc += "Entree:";
		if(entree != null) {
			desc += entree.getName() +"--" + entree.getDescription();
		}else{
			desc += "N/A.";
		}
		desc += "\n";
		desc += "Side:" ;
		if(side != null){
			desc += side.getName() +"--" + side.getDescription();
		}else{
			desc += "N/A.";
		}
		desc += "\n";
		desc += "Salad:";
		if(salad != null){
			desc += salad.getName() +"--" + salad.getDescription();
		}else{
			desc += "N/A.";
		}
		desc += "\n";
		desc += "Dessert:";
		if(dessert != null){
			desc += dessert.getName() +"--" + dessert.getDescription();
		}else{
			desc += "N/A.";
		}


		return desc ;
	}
	
	public String entreeDescription(){
		String desc = "";
		desc+=entree.getDescription();
		return desc;
	}
	
	public String sideDescription(){
		String desc = "";
		desc+=side.getDescription();
		return desc;	
	}
	
	public String saladDescription(){
		String desc = "";
		desc+=salad.getDescription();
		return desc;	
	}
	
	public String dessertDescription(){
		String desc = "";
		desc+=dessert.getDescription();
		return desc;	
	}

	public String getName(){
		return this.name;
	}

	public Entree getEntree(){
		return this.entree;	
	}


	public Salad getSalad(){
		return this.salad;
	}

	public Side getSide(){
		return this.side;
	}

	public Dessert getDessert(){
		return this.dessert;
	}

	public void setName(String name){
		this.name=name;
	}

	public void setEntree(Entree entree){
		this.entree=entree;
	}

	public void setSalad(Salad salad){
		this.salad=salad;
	}

	public void setSide(Side side){
		this.side=side;
	}

	public void setDessert(Dessert dessert){
		this.dessert= dessert;
	}
	
	public double getTotalPrice(){
		return this.entree.getPrice()+this.salad.getPrice()+this.side.getPrice()+this.dessert.getPrice();
	}
	
	public int getTotalCalories(){
		return this.entree.getCalories()+this.salad.getCalories()+this.side.getCalories()+this.dessert.getCalories();
	}
	
	@Override
    public String toString(){
		
		return getName();
	}
}

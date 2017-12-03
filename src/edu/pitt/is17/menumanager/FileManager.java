package edu.pitt.is17.menumanager;

/**
 * Class FileManager
 * @author ChuntzuL
 * @created:11/27/2017
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class FileManager {

	public static void main(String[] args) {
		

	}
	
	public static ArrayList<MenuItem> readItems(String fileName){
		ArrayList<MenuItem> res = new ArrayList<MenuItem>();
		try{
		FileReader fr = new FileReader("/Users/Liuchuntzu/Desktop/dish.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		while( (line = br.readLine()) != null){
			String[] lineParts = line.split("@@");
			MenuItem m;
			if(lineParts[1].equalsIgnoreCase("entree")){
				m=new Entree(lineParts[0],lineParts[2], Integer.parseInt(lineParts[3]), Double.parseDouble(lineParts[4]));
			}else if(lineParts[1].equalsIgnoreCase("side")){
				m=new Side(lineParts[0],lineParts[2], Integer.parseInt(lineParts[3]), Double.parseDouble(lineParts[4]));
			}else if(lineParts[1].equalsIgnoreCase("salad")){
				m=new Salad(lineParts[0],lineParts[2], Integer.parseInt(lineParts[3]), Double.parseDouble(lineParts[4]));
			}else{
			    m=new Dessert(lineParts[0],lineParts[2], Integer.parseInt(lineParts[3]), Double.parseDouble(lineParts[4]));
			}
			res.add(m);
		}
		
		br.close();
		fr.close();
		
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		
		return res;
	}
	
	
	public static void writeMenus(String fileName, String text){
		
		try{
			FileWriter fw = new FileWriter("/Users/Liuchuntzu/Desktop/fileNmae.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			
			//ArrayList<Menu> menuData = new ArrayList<Menu>();
			
		
			bw.write(text);
			
			bw.newLine();
			
			bw.flush();
			fw.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	/*
	/**
	 * Method read entree file
	 * @param fileName
	 * @return dish, description, calories
	 */
	/*
	public static ArrayList<Entree> readEntrees(String fileName) {
		ArrayList<Entree> res = new ArrayList<Entree>();
		
		try{
		FileReader fr = new FileReader("/Users/Liuchuntzu/Desktop/data/entrees.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line=null;
		while((line = br.readLine()) != null){
			String[] lineParts = line.split("@@");
			Entree entree = new Entree(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]));
		
			res.add(entree);
		}
		
		br.close();
		fr.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	
		return res;
	}
	*/
	/**
	 * Method read side file
	 * @param fileName
	 * @return dish, description, calories
	 */
	/*
	public  static ArrayList<Side> readSides(String fileName){
		ArrayList<Side> res = new ArrayList<Side>();
		try{
		FileReader fr = new FileReader("/Users/Liuchuntzu/Desktop/data/sides.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		while( (line = br.readLine()) != null){
			String[] lineParts = line.split("@@");
			Side side = new Side(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]));
			res.add(side);
		}
		
		br.close();
		fr.close();
		
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return res;
	}
	*/
	/**
	 * Method read salad file
	 * @param fileName
	 * @return dish, description, calories
	 */

	/*
	public static ArrayList<Salad> readSalads(String fileName){
		ArrayList<Salad> res = new ArrayList<Salad>();
		try{
		FileReader fr = new FileReader("/Users/Liuchuntzu/Desktop/data/salads.txt");
		BufferedReader br = new BufferedReader(fr);
		
		String line = null;
		while((line = br.readLine()) != null){
			String[] lineParts = line.split("@@");
			Salad salad = new Salad( lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]));
			res.add(salad);
		}
		br.close();
		fr.close();
		
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return res;
	}
	*/
	/*
	/**
	 * Method read dessert file
	 * @param fileName
	 * @return dish, description, calories
	 */
	
	/*
	public static ArrayList<Dessert> readDesserts(String fileName){
		ArrayList<Dessert> res = new ArrayList<Dessert>();
		try{
		FileReader fr = new FileReader("/Users/Liuchuntzu/Desktop/data/desserts.txt");
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while( (line=  br.readLine()) != null){
			String[] lineParts = line.split("@@");
			Dessert dessert = new Dessert(lineParts[0], lineParts[1], Integer.parseInt(lineParts[2]));
			res.add(dessert);
		}
		br.close();
		fr.close();
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
		return res;
	}
	*/
	

}

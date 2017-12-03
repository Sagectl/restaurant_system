package edu.pitt.is17.menumanager;

/**
 * Class GUI
 * @author ChuntzuL
 * @created:12/01/2017
 */


	import java.awt.Color;
	import java.awt.TextArea;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;
	import java.lang.reflect.Array;
	import java.util.ArrayList;

	import javax.swing.BorderFactory;
	import javax.swing.DefaultListModel;
	import javax.swing.JButton;
	import javax.swing.JComboBox;
	import javax.swing.JFrame;
	import javax.swing.JLabel;
	import javax.swing.JList;
	import javax.swing.JOptionPane;
	import javax.swing.JTextArea;
	import javax.swing.JTextField;
	import javax.swing.ListModel;
	import javax.swing.ListSelectionModel;
	import javax.swing.event.ListSelectionEvent;
	import javax.swing.event.ListSelectionListener;

	import edu.pitt.is17.menumanager.Entree;
	import edu.pitt.is17.menumanager.FileManager;
	import edu.pitt.is17.menumanager.Menu;
	import edu.pitt.is17.menumanager.MenuItem;
	import edu.pitt.is17.menumanager.MenuManager;
	import edu.pitt.is17.menumanager.Side;

	public class GUI implements ActionListener, ListSelectionListener {

		//Main Window
		private MenuManager menuManager;	
		private MenuItem selectMenu;
		private ArrayList<String> createdMenu;

		private JFrame frmMainWindow;
		private JTextArea txtArea;
		private JButton btnDatialsText;
		private JButton btnDeleteText;
		private JButton btnSaveText;
		private JLabel lblCreate;
		private JLabel lblBuild;
		private JLabel lblEntree;
		private JLabel lblSide;
		private JLabel lblSalad;
		private JLabel lblDessert;
		private JButton btnCreateMenu;
		private JLabel lblGenerate;
		private JButton btnRandom;
		private JButton btnMinimumCal;
		private JButton btnMaximumCal;
		private JComboBox cboEntreeOptions;
		private JComboBox cboSideOptions;
		private JComboBox cboSaladOptions;
		private JComboBox cboDessertOptions;


		//Go to SecondFrame
		private JList list1;
		private DefaultListModel listModel;

		//Second Window

		private JFrame frmSecondWindow;
		private JTextArea txtEntree;
		private JTextArea txtSide;
		private JTextArea txtSalad;
		private JTextArea txtDessert;
		private JTextArea txtCal;
		private JTextArea txtPrice;
		private JLabel lblEntree2;
		private JLabel lblSide2;
		private JLabel lblSalad2;
		private JLabel lblDessert2;
		private JLabel lblAllCol;
		private JLabel lblAllPrice;


		/**
		 * Launch the application.
		 */
		public static void main(String[] args) {
			GUI window = new GUI();
			window.frmMainWindow.setVisible(true);

		}

		/**
		 * Create the application.
		 */
		public GUI() {
			menuManager = new MenuManager("/Users/LiuChuntzu/Desktop/data.txt");
			selectMenu=null;
			createdMenu = new ArrayList<String>();
			//listModel = new DefaultListModel();

			initMainFrame();
			initSecondFrame();
		}

		/**
		 * Initialize the contents of the frame.
		 */
		private void initMainFrame() {
			frmMainWindow = new JFrame("Menu Manager"); 
			frmMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
			frmMainWindow.setResizable(false); 
			frmMainWindow.setBounds(200,200,750,425); 
			frmMainWindow.setLayout(null);



			//defines the label
			lblCreate = new JLabel("Created Menus :)");
			lblCreate.setBounds(405,15, 150, 25);
			frmMainWindow.getContentPane().add(lblCreate);

			lblBuild = new JLabel("Build your own menu:)");
			lblBuild.setBounds(15, 15, 150, 25);
			frmMainWindow.getContentPane().add(lblBuild);

			lblEntree= new JLabel("Entree");
			lblEntree.setBounds(25, 45, 100, 25);
			frmMainWindow.getContentPane().add(lblEntree);

			lblSide= new JLabel("Side");
			lblSide.setBounds(25, 75, 100, 25);
			frmMainWindow.getContentPane().add(lblSide);

			lblSalad= new JLabel("Salad");
			lblSalad.setBounds(25, 105, 100, 25);
			frmMainWindow.getContentPane().add(lblSalad);

			lblDessert= new JLabel("Dessert");
			lblDessert.setBounds(25, 135, 100, 25);
			frmMainWindow.getContentPane().add(lblDessert);


			lblGenerate = new JLabel("Or generate a Menu:)");
			lblGenerate.setBounds(15, 240, 150, 25);
			frmMainWindow.getContentPane().add(lblGenerate);


			//defines the button
			btnCreateMenu = new JButton("Create Menu with these dishes");
			btnCreateMenu.setBounds(20,180,325,25);
			
			//create create button
					btnCreateMenu.addActionListener(this);

					btnCreateMenu.addActionListener(new ActionListener(){

						public void actionPerformed(ActionEvent e) {

							String menuName = JOptionPane.showInputDialog("Please input a name of the menu");
							//if(txtArea.getText().length() == 0) txtArea.setText(menuName);
							//else txtArea.setText(txtArea.getText()+"\n"+menuName);
							int selectedEntree = cboEntreeOptions.getSelectedIndex();
							int selectedSide = cboSideOptions.getSelectedIndex();
							int selectedSalad = cboSaladOptions.getSelectedIndex();
							int selectedDessert = cboDessertOptions.getSelectedIndex();
							
							createdMenu.add(selectedEntree+","+selectedSide+","+selectedSalad+","+selectedDessert);
							listModel.addElement(menuName);
						}
					});

					
					
			btnRandom = new JButton("Generate a Random Menu");
			btnRandom.setBounds(20,280,325,25);
			
			//create random button
					btnRandom.addActionListener(this);
					btnRandom.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							System.out.println("You just clicked a random button!");
							Menu m = menuManager.randomMenu();
							
							//System.out.println("**"+m.toString());
							txtEntree.setText(m.getEntree().toString()+" :) "+m.entreeDescription().toString() );
							txtSide.setText(m.getSide().toString()+" :) "+m.sideDescription().toString()  );
							txtSalad.setText(m.getSalad().toString()+" :) "+m.saladDescription().toString() );
							txtDessert.setText(m.getDessert().toString()+" :) "+m.dessertDescription().toString()  );
							
							double price= m.getTotalPrice();
							txtPrice.setText(Double.toString(price));
							
							int calories=m.getTotalCalories();
							txtCal.setText(Integer.toString(calories));
							
							frmSecondWindow.setVisible(true);
						}
					});
					frmMainWindow.getContentPane().add(btnRandom);

					
					

			btnMinimumCal = new JButton("Generate a Minimum Calories Menu");
			btnMinimumCal.setBounds(20,320,325,25);
			
			//create minimum calories button
			btnMinimumCal.addActionListener(this);
			btnMinimumCal.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e) {
					System.out.println("You just clicked a minimum calories button!");
					Menu m = menuManager.minCaloriesMenu();
					
					txtEntree.setText(m.getEntree().toString()+" :) "+m.entreeDescription().toString() );
					txtSide.setText(m.getSide().toString()+" :) "+m.sideDescription().toString()  );
					txtSalad.setText(m.getSalad().toString()+" :) "+m.saladDescription().toString() );
					txtDessert.setText(m.getDessert().toString()+" :) "+m.dessertDescription().toString()  );
					
					double price= m.getTotalPrice();
					txtPrice.setText(Double.toString(price));
					
					int calories=m.getTotalCalories();
					txtCal.setText(Integer.toString(calories));
					
					
					frmSecondWindow.setVisible(true);
				}
			});
			frmMainWindow.getContentPane().add(btnMinimumCal);


			
			
			btnMaximumCal = new JButton("Generate a Maximum Calories Menu");
			btnMaximumCal.setBounds(20,360,325,25);
			
			//create maximum calories button
					btnMaximumCal.addActionListener(this);
					btnMaximumCal.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							System.out.println("You just clicked a maximum calories button!");
							Menu m = menuManager.maxCaloriesMenu();
							
							txtEntree.setText(m.getEntree().toString()+" :) "+m.entreeDescription().toString() );
							txtSide.setText(m.getSide().toString()+" :) "+m.sideDescription().toString()  );
							txtSalad.setText(m.getSalad().toString()+" :) "+m.saladDescription().toString() );
							txtDessert.setText(m.getDessert().toString()+" :) "+m.dessertDescription().toString()  );
							
							double price= m.getTotalPrice();
							txtPrice.setText(Double.toString(price));
							
							int calories=m.getTotalCalories();
							txtCal.setText(Integer.toString(calories));
							
							frmSecondWindow.setVisible(true);
						}
					});
					frmMainWindow.getContentPane().add(btnMaximumCal);

					
					
			btnDatialsText = new JButton("Details");
			btnDatialsText.setBounds(400,360,110,25);
			
			//create details button
			btnDatialsText.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("You just clicked a details button!");
					frmSecondWindow.setVisible(true);
				}
			});
			frmMainWindow.getContentPane().add(btnDatialsText);


			
			

			btnDeleteText = new JButton("Delete all");
			btnDeleteText.setBounds(510,360,110,25);
			
			//create delete button
					btnDeleteText.addActionListener(this);
					btnDeleteText.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e) {
							listModel.clear();;
						}
					});

					
					
					
			btnSaveText = new JButton("Save to file");
			btnSaveText.setBounds(620,360,110,25);
			//create save button
			btnSaveText.addActionListener(this);
			btnSaveText.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					System.out.println("You just clicked a save button!");
					
					String output = "";
					for (int i = 0; i < createdMenu.size(); i++) {
						//System.out.println(list.get(i));
						String c = createdMenu.get(i);
						Menu m = menuManager.getMenuByIDs(c);
						
						output += listModel.getElementAt(i).toString()+",";
					    output += m.getEntree().toString()+",";
						output += m.getSide().toString()+",";
						output += m.getSalad().toString()+",";
						output += m.getDessert().toString()+"\n";
					}
	                
					
					FileManager.writeMenus("/Users/Liuchuntzu/Desktop/fileNmae.txt", output);
				}
			});

			txtArea = new JTextArea(10,25);
			txtArea.setBounds(405,50,320,290);

			//The ComboBox
			cboEntreeOptions = new JComboBox(menuManager.getEntrees().toArray());
			cboEntreeOptions.setBounds(100,45,240,25);
			cboEntreeOptions.setSelectedIndex(0);


			cboSideOptions = new JComboBox(menuManager.getSides().toArray());
			cboSideOptions.setBounds(100,75,240,25);
			cboSideOptions.setSelectedIndex(0);


			cboSaladOptions = new JComboBox(menuManager.getSalads().toArray());
			cboSaladOptions.setBounds(100,105,240,25);
			cboSaladOptions.setSelectedIndex(0);


			cboDessertOptions = new JComboBox(menuManager.getDesserts().toArray());
			cboDessertOptions.setBounds(100,135,240,25);
			cboDessertOptions.setSelectedIndex(0);


			
			
			
			


			
			//go to SecondFrame
			listModel = new DefaultListModel();
			list1 = new JList(listModel);

			list1.setBounds(405,50,320,290);
			list1.setBorder(BorderFactory.createLineBorder(Color.black));
			list1.addListSelectionListener(this);





			//adds the components to the window
			frmMainWindow.add(btnDatialsText);
			frmMainWindow.add(btnDeleteText);
			frmMainWindow.add(btnSaveText);
			frmMainWindow.add(list1);
			frmMainWindow.add(lblCreate);
			frmMainWindow.add(lblBuild);
			frmMainWindow.add(lblEntree);
			frmMainWindow.add(lblSide);
			frmMainWindow.add(lblSalad);
			frmMainWindow.add(lblDessert);
			frmMainWindow.add(btnCreateMenu);
			frmMainWindow.add(lblGenerate);
			frmMainWindow.add(btnRandom);
			frmMainWindow.add(btnMinimumCal);
			frmMainWindow.add(btnMaximumCal);

			frmMainWindow.add(cboEntreeOptions);
			frmMainWindow.add(cboSideOptions);
			frmMainWindow.add(cboSaladOptions);
			frmMainWindow.add(cboDessertOptions);



			//display the main window
			frmMainWindow.setVisible(true);

		}

		private void initSecondFrame(){


			frmSecondWindow = new JFrame("Menu :) My own Menu");
			frmSecondWindow.setBounds(100, 100, 600, 400);
			frmSecondWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frmSecondWindow.getContentPane().setLayout(null);

			lblEntree2 = new JLabel("Entree");
			lblEntree2.setBounds(20, 20, 150, 25);
			frmSecondWindow.getContentPane().add(lblEntree2);

			lblSide2 = new JLabel("Side");
			lblSide2.setBounds(20, 80, 150, 25);
			frmSecondWindow.getContentPane().add(lblSide2);

			lblSalad2 = new JLabel("Salad");
			lblSalad2.setBounds(20, 140, 150, 25);
			frmSecondWindow.getContentPane().add(lblSalad2);

			lblDessert2 = new JLabel("Dessert");
			lblDessert2.setBounds(20, 200, 150, 25);
			frmSecondWindow.getContentPane().add(lblDessert2);

			lblAllCol = new JLabel("Total calories:");
			lblAllCol.setBounds(20, 260, 150, 25);
			frmSecondWindow.getContentPane().add(lblAllCol);

			lblAllPrice = new JLabel("Total price: $");
			lblAllPrice.setBounds(20, 300, 150, 25);
			frmSecondWindow.getContentPane().add(lblAllPrice);

			txtEntree = new JTextArea();
			txtSide = new JTextArea();
			txtSalad = new JTextArea();
			txtDessert = new JTextArea();
			txtCal = new JTextArea();
			txtPrice = new JTextArea();

			txtEntree.setBounds(120,20,450,50);
			txtEntree.setLineWrap(true);
			txtSide.setBounds(120,80,450,50);
			txtSide.setLineWrap(true);
			txtSalad.setBounds(120,140,450,50);
			txtSalad.setLineWrap(true);
			txtDessert.setBounds(120,200,450,50);
			txtDessert.setLineWrap(true);
			txtCal.setBounds(120,260,150,30);
			txtPrice.setBounds(120,300,150,30);

			frmSecondWindow.add(lblEntree2);
			frmSecondWindow.add(lblSide2);
			frmSecondWindow.add(lblSalad2);
			frmSecondWindow.add(lblDessert2);
			frmSecondWindow.add(lblAllCol);
			frmSecondWindow.add(lblAllPrice);
			frmSecondWindow.add(txtEntree);
			frmSecondWindow.add(txtSide);
			frmSecondWindow.add(txtSalad);
			frmSecondWindow.add(txtDessert);
			frmSecondWindow.add(txtCal);
			frmSecondWindow.add(txtPrice);


			//frmSecondWindow.setVisible(true);


		}

		@Override
		public void valueChanged(ListSelectionEvent e) {
			if(!e.getValueIsAdjusting()){
	            ListSelectionModel lsm = list1.getSelectionModel();
	            System.out.println("value Changed");
	            if (lsm.isSelectionEmpty()) {
	                // nothing
	            } else {
	                // Find out which indexes are selected.
	                int minIndex = lsm.getMinSelectionIndex();
	                int maxIndex = lsm.getMaxSelectionIndex();
	                //String output = "";
	                int selectedID = 0;
	                for (int i = minIndex; i <= maxIndex; i++) {
	                    if (lsm.isSelectedIndex(i)) {
	                        
	                        //output += " " + list1.getModel().getElementAt(i).toString();
	                    	selectedID = i;
	                    }
	                }
	                
	                String output = createdMenu.get(selectedID);
	                
	                
	                Menu m = menuManager.getMenuByIDs(output);
					
					txtEntree.setText(m.getEntree().toString()+" :) "+m.entreeDescription().toString() );
					txtSide.setText(m.getSide().toString()+" :) "+m.sideDescription().toString()  );
					txtSalad.setText(m.getSalad().toString()+" :) "+m.saladDescription().toString() );
					txtDessert.setText(m.getDessert().toString()+" :) "+m.dessertDescription().toString()  );
					
					double price= m.getTotalPrice();
					txtPrice.setText(Double.toString(price));
					
					int calories=m.getTotalCalories();
					txtCal.setText(Integer.toString(calories));
					
	                //frmSecondWindow.setVisible(true);
	                //JOptionPane.showMessageDialog(null, output);
	            }
	            
	        }

		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

		}

	}




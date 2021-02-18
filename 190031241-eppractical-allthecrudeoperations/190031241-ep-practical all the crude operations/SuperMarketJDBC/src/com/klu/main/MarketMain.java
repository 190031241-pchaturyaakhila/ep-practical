package com.klu.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.Bean;
import com.klu.DOA.DOA;

public class MarketMain {

	private static Scanner sc;

	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		
		Bean ab = new Bean();
		DOA cd = new DOA();
		sc = new Scanner(System.in);
		String choice = null;
		do
		{
			System.out.println("Market Operations");
			System.out.println("1.Insertion");
			System.out.println("2.Display");
			System.out.println("3.Total Cost");
			System.out.println("4.Exit");
			System.out.println("Enter an number to perform Operation : ");
			int ch = sc.nextInt();
			switch(ch)
			{
				case 1 :  System.out.println("Insertion");
				 		  System.out.println("Enter itemid : ");
				 		  int id = sc.nextInt();
				 		  ab.setItemid(id);
				 		  System.out.println("Enter itemname : ");
				 		  String name = sc.next();
				 		  ab.setItemname(name);
				 		  System.out.println("Enter itemcost : ");
				 		  int cost = sc.nextInt();
				 		  ab.setItemcost(cost);
				 		  int i = cd.item_Insert(ab);
				 		  if(i>0)
				 		  {
				 			  System.out.println("Ur insertion is successfull");
				 		  }
				 		  else
				 		  {
				 			  System.out.println("Ur insertion is failed");
				 		  }
				 		  break;
				 		  
				case 2 : System.out.println("Display of items");
						 cd.Items_Display();
						 break;
						 
				case 3 : System.out.println("Total Cost of items");
						 cd.items_totalCost();
				  		 break;
				  		 
				case 4 : cd.Delete_Records();
						  break;
			}
			System.out.println("Enter your choice to repeat the Market operation [ Yes/No ] : ");
			choice = sc.next();
		}
		while(choice.equals("Yes"));
	}
}

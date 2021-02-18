package com.klu.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.StudentBean;
import com.klu.insert.StudentInsertion;

public class Studentmain {
	
	private static Scanner sc;
 
	public static void main(String args[]) throws ClassNotFoundException, SQLException {
		StudentBean sb = new StudentBean();
		StudentInsertion si = new StudentInsertion();
		sc = new Scanner(System.in);
		String choice;
		do 
		{
			System.out.println("Select an CRUD Operation");
			System.out.println("1.Insertion");
			System.out.println("2.Update");
			System.out.println("3.Delete");
			System.out.println("4.Display");
			System.out.println("Enter your choice : ");
			int ch =sc.nextInt();
			switch(ch)
			{
				case 1 : System.out.println("Insertion");
						 System.out.println("Enter reg no. : ");
						 int id = sc.nextInt();
					 	 sb.setReg_no(id);
						 System.out.println("Enter name : ");
						 String name = sc.next();
					 	 sb.setName(name);
					 	 System.out.println("Enter email : ");
					 	 String email = sc.next();
					 	 sb.setEmail(email);
					 	 int i = si.StudentInsert(sb);
					 	 if(i>0)
					 	 {
					 		 System.out.println("Ur insertion is successfull");
					 	 }
					 	 else
					 	 {
					 		 System.out.println("Ur insertion is failed");
					 	 }
					 	 break;
					
				case 2 : System.out.println("Updation");
						 System.out.println("Select an element to update with");
						 System.out.println("1.Name");
						 System.out.println("2.Email");
						 int inner_cho = sc.nextInt();
						 switch(inner_cho)
						 {
						 			 
						 	case 1 : System.out.println("Update Name : ");
						 			 System.out.println("Enter reg no to update : ");
						 			 int num = sc.nextInt();
						 			 System.out.println("Enter a name to update : ");
						 			 String em_1 = sc.next();
						 			 si.StudentUpdate_name(num,em_1);
						 			 break;
						 			 
						 	case 2 : System.out.println("Update Email : ");
						 			 System.out.println("Enter reg no to update : ");
						 			 int num_1 = sc.nextInt();
						 			 System.out.println("Enter an email to update : ");
						 			 String em_2 = sc.next();
						 			 si.StudentUpdate_email(num_1,em_2);
						 			 break;
						 			 
						 	default : System.exit(0);
						 	
						 }
						 break;
						 
				case 3 : System.out.println("Deletion");
						 System.out.println("Select an element to delete with");
						 System.out.println("1.Registration no.");
						 System.out.println("2.Name");
						 System.out.println("3.Email");
						 int inner_ch = sc.nextInt();
						 switch(inner_ch)
						 {
						 	
						 	case 1 : System.out.println("Delete using Reg no. : ");
						 			 System.out.println("Enter a reg no to delete : ");
						 			 int num = sc.nextInt();
						 			 si.StudentDelete_regno(num);
						 			 break;
						 			 
						 	case 2 : System.out.println("Delete using Name : ");
				 			 		 System.out.println("Enter a name to delete : ");
				 			 		 String na= sc.next();
				 			 		 si.StudentDelete_name(na);
				 			 		 break;
				 			 		 
						 	case 3 : System.out.println("Delete using Email : ");
		 			 		 		 System.out.println("Enter an email to delete : ");
		 			 		 		 String na_1 = sc.next();
		 			 		 		 si.StudentDelete_email(na_1);
		 			 		 		 break;
		 			 		 		 
		 			 		default : System.exit(0);
						 		     
						 }
						 break;
						 
				case 4 : System.out.println("Display Data");
						 si.Student_Display();
				         break;
						 		 
				default : System.exit(0);
			}
			System.out.println("Enter your choice to repeat the CRUD operation [ Yes/No ] : ");
			choice = sc.next();
		}
		while(choice.equals("Yes"));
	}
}
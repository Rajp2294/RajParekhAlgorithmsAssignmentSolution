package driver;

import java.util.Scanner;
import service.LinearSearch;
import service.MergeSort;
public class Stockers {
	
	//main method
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter the no of companies");
		int noOfCompanies = sc.nextInt();
		
		double[] arr = new double[noOfCompanies];
		
		int priceRise = 0;
		int priceDecline = 0;
		
		for (int i = 0; i < noOfCompanies; i++) {
			System.out.println("Enter current stock price of company" + (i+1));
			arr[i] = sc.nextDouble();
			System.out.println("Whether company's stock price rose today compare to yesterday?");
			Boolean stock = sc.nextBoolean();
			if (stock) {
				priceRise++;
			} else {
				priceDecline++;
			}
		} 
		int operation = 0;
		do {
			System.out.println("----------------------------------------------------------------------------------");
			System.out.println("Enter the operation you want to perform");
			System.out.println("1. Display the companies stock prices in ascending order");
			System.out.println("2. Display the companies stock prices in descending order");
			System.out.println("3. Display the total no of companies for which stock prices rose today");
			System.out.println("4. Display the total no of companies for which stock prices declined today");
			System.out.println("5. Search a specific stock price");
			System.out.println("6. Press 0 to exit");
			operation = sc.nextInt();
			switch(operation) {
				case 0:
					System.out.println("Exited Successfully");
					operation = 0;					
					break;				
				case 1: 
					double[] asc = MergeSort.sort(arr, 0, arr.length-1);
					System.out.println("Stockprices in ascending order are :");					
				  		  for (int i = 0; i < asc.length; i++) {
				  	  		  System.out.print(asc[i]+ " "); 
				  		  }
				    System.out.print("\n");
				    break;
				case 2:
					double[] desc = new double[arr.length];
					int j = 0;
				    System.out.println("Stock prices in descending order are :");
				  		for (int i= arr.length-1; i >= 0; i--) {
				  		desc[j] = arr[i];
				  			j++;
				  		}
				  		for (int i = 0; i < desc.length; i++){
					  		  System.out.print(desc[i]+ " "); 
						  }
				  	System.out.print("\n");
					break;
				case 3:
					System.out.println("Total no of companies whose stock price rose today :" +priceRise);
					System.out.print("\n");
					break;
				case 4:
					System.out.println("Total no of companies whose stock price declined today :" +priceDecline);
					System.out.print("\n");
					break;
				case 5:
					System.out.println("Enter the key value");
					double key = sc.nextDouble();
					boolean valPresent = LinearSearch.search(arr, key);
					if (valPresent)
						System.out.println("Stock of value " + key + " is present");
					else
						System.out.println("Stock value not present");
					break;					  
				default:
					System.out.println("Invalid option. Please enter a valid option!");
					break;
			}
		} while (operation != 0);
		sc.close();
	}

}

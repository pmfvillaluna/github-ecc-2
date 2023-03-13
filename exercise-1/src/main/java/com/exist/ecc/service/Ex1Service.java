package com.exist.ecc.service;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Ex1Service{
	static Scanner sc = new Scanner(System.in);
	
	public void start(){
		boolean works = false;
		while(!works){
			try{
				int rows;
				int columns;
				System.out.println("Please input number of rows: ");
				rows = sc.nextInt();
				
				System.out.println("Please input number of columns: ");
				columns = sc.nextInt();
								
				selection(createTable(rows, columns));

				works = true;
			}catch(InputMismatchException e){
				System.out.println("You have entered the wrong value, please enter a number");
				sc.next();
			}	
		}
	}
	
	public void selection(String[][]table){
		int rows = table.length;
		int column = table[0].length;
		boolean notFinished = true;
		String option;
		System.out.println("\nWelcome to your 2-D Array Sample"
		+"\nPlease input which action you would like to take:");
		while(notFinished){
			System.out.println("[A] Search - Search for a value within the table"
			+"\n[B] Edit   - Edit specific data in the table"
			+"\n[C] Print  - Print table data"
			+"\n[D] Reset  - Reset the table's data"
			+"\n[E] Exit   - Exit the Program");
			option = sc.next();
			sc.nextLine();
				switch(option.toUpperCase()){
					case "A":
					findOccurences(table);
					break; 
							
					case "B":
					editTable(table, rows, column);
					break;
							
					case "C":
					displayTable(table, rows, column);
					break;
					
					case "D":
					System.out.println("You have chosen to restart your table's data.\nReseting...");
					start(); 
					break;
					
					case "E":
					System.out.println("Thank you for using our system. We hope to see you again!"); 
					System.exit(0);
					break;

					default: 
					System.out.println("You have chosen an invalid option...\nPlease choose again from the selection: \n");
					break;
				}
			}
	}
	
	
	public String[][] createTable(int rows, int columns){ 
		String[][]table = new String[rows][columns];
		String generatedText = "";
		int charLimit = 2;
		
		for (int ctrRows = 0; ctrRows < rows ; ctrRows++){
			for (int ctrColumns = 0; ctrColumns < columns; ctrColumns++){	
				for(int ctrChar = 0; ctrChar <= charLimit; ctrChar++){
					generatedText +=	(char)((int) Math.round(Math.random()*93+33));;
					if (ctrChar >= charLimit){
						table[ctrRows][ctrColumns] = generatedText;
						generatedText ="";
					}
				}
			}	
		}
		return table;
	}
	
	
	public void findOccurences(String[][]arr){
		boolean finished = false;
		String searchValue="";
		
			System.out.println("Enter the value you want to search ");
			while(!finished){
				searchValue = sc.nextLine();
			
				switch(searchValue.length()){
					case 1:
					char ans = searchValue.charAt(0);
					finished = true;
					findOccurence1(arr, ans);
					break;
					
					case 2:
					findOccurence2(arr, searchValue);
					finished = true;
					break;

					case 3:
					findOccurence3(arr, searchValue);
					finished = true;
					break; 
						
					default:
					System.out.println("Please only enter anywhere between 1 to 3 characters");
					break;
				}
		}
    }
	
	public void findOccurence1(String[][]tableData, char occurence){
		int occurenceCount = 0;
		String output="";
		for (int ctrRows = 0; ctrRows < tableData.length; ctrRows++) {
			for (int ctrColumns = 0; ctrColumns < tableData[ctrRows].length; ctrColumns++) {
				for (int ctrChar = 0; ctrChar < tableData[ctrRows][ctrColumns].length(); ctrChar++) {
					if (tableData[ctrRows][ctrColumns].charAt(ctrChar) == occurence) {
						occurenceCount++;
						output += "Occurence#"+occurenceCount+" found at array[" + ctrRows + "][" + ctrColumns + "] = "+tableData[ctrRows][ctrColumns]+"\n";
					}
				}
			}
		}

	System.out.println(output +"Total number of occurence: " + occurenceCount+"\n");
	}
	
	public void findOccurence2(String[][]tableData, String occurence){
		int occurenceCount = 0;
		String output = "";
		for (int ctrRows = 0; ctrRows < tableData.length; ctrRows++) {
			for (int ctrColumns = 0; ctrColumns < tableData[ctrRows].length; ctrColumns++) {
				String sub1 = tableData[ctrRows][ctrColumns].substring(0, 2);
				String sub2 = sub1.substring(1) +tableData[ctrRows][ctrColumns].substring(2);
					if(sub1.contains(occurence)||sub2.contains(occurence)){
						occurenceCount++;
						output += "Occurence#"+occurenceCount+" found at array[" + ctrRows + "][" + ctrColumns + "] = "+tableData[ctrRows][ctrColumns]+"\n";
					}
				}
			}
	System.out.println(output+"Total number of occurence: " + occurenceCount+"\n");		
	}
	
	public void findOccurence3(String[][]tableData, String occurence){
		int occurenceCount = 0;
		String output= "";
		for (int ctrRows = 0; ctrRows < tableData.length; ctrRows++) {
			for (int ctrColumns = 0; ctrColumns < tableData[ctrRows].length; ctrColumns++) {
					if (tableData[ctrRows][ctrColumns].equals(occurence)) {
						occurenceCount++;
						output += "Occurence#"+occurenceCount+" found at array[" + ctrRows + "][" + ctrColumns + "] = "+tableData[ctrRows][ctrColumns]+"\n";
					}
			}
		}

	System.out.println(output +"Total number of occurence: " + occurenceCount+"\n");
	}
	
	public void editTable(String [][] table, int maxRows, int maxCols){
		int row = 0, col = 0;
		String value="";
		boolean correctValRow = false, correctValCol = false, correctVal=false;
		boolean correctAll = false;
		while(!correctAll){
					try{
			while(!correctValRow){
				System.out.println("Enter row number you wish to edit:");
				row = sc.nextInt();
					if(row <= maxRows && row>=0){
						correctValRow = true;

					}else{
						System.out.println("Please enter a number from 0 to " + maxRows);					
					}
			}		
			while(!correctValCol){
				System.out.println("Enter column number you wish to edit:");
				col = sc.nextInt();
					if(col<= maxCols && col>=0){
						correctValCol = true;
					}else{
						System.out.println("Please enter a number from 0 to " + maxCols);
				}
			}	
			
			while(!correctVal){
				System.out.println("Enter the value you wish to change it to:");
				value = sc.next();
				if(value.length() == 3){
					correctVal = true;
				}else{
					System.out.print("Enter 3 characters only");
				}
			}
			if(correctValRow && correctValCol && correctVal){
				correctAll = true;
			}
			table[row][col]=value;

			System.out.println("Table updated...");
			displayTable(table, maxRows, maxCols);
		
		}catch(InputMismatchException e){
				System.out.println("You have entered the wrong value, please enter a number");
		}
		}
	}
	
	public void displayTable(String[][] table, int rows, int columns){
		System.out.println("You have chosen to display your table:");
			for (int ctrRows=0; ctrRows < rows ; ctrRows++) {
				for (int ctrColumns=0; ctrColumns < columns ; ctrColumns++) {
					System.out.print( " | ["+ ctrRows +"]"+  "["+ctrColumns+"]"+" = " + table[ctrRows][ctrColumns]);
				}
				System.out.println("");
			}
		}
	
}
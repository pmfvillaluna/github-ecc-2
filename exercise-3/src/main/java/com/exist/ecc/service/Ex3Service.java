package com.exist.ecc.service;

import java.util.ArrayList;
import java.io.FileReader; 
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.IOException;
import java.io.File;
import java.util.Arrays;
import java.util.Map;
import java.util.LinkedHashMap;
import java.util.InputMismatchException;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Ex3Service{
	static Scanner sc = new Scanner(System.in);

	public String chooseFile(String[] files){
		File file1 = new File(files[0]);
        File file2 = new File(files[1]);
		String fileName = "";

		boolean finished = true; 
			while(finished){
				if((file2.length()!=0) && file1.length()!=0){
					System.out.println("Please choose which file that you want to choose\n"
					+"[1] = txt1.txt\n"
					+"[2] = txt2.txt");
					String choice = sc.nextLine();
						switch(choice){
							case "1":
							fileName = files[0];
							finished = false;
							break;
							
							case "2":
							fileName = files[1];
							finished = false;
							break;
							
							default:
							System.out.println("Please only choose between 1 and 2");
						}
				}else{
					System.out.println("Chose the default file");
					fileName = files[0];
					finished = false;
				}
			}
		return fileName;
	}

		public com.exist.ecc.service.Ex3DataHandler createMap(String fileName){
			String lines = "";
			LinkedHashMap<String, String> keyPair = new LinkedHashMap<>();
			ArrayList<ArrayList<String>> listOfWords = new ArrayList<>();
			BufferedReader br;
			int lineLimit = 0;
			int wordLimit = 0;
			try{
				br = new BufferedReader(new FileReader(fileName));
				while((lines = br.readLine())!=null){
					String [] words = lines.split("\\s");
					ArrayList<String> linesOfWords = new ArrayList<>(Arrays.asList(words)); 
					for(int counter = 0; counter< words.length; counter+=2){
							keyPair.put(words[counter], words[counter+1]);
					}
					if(wordLimit < words.length){
						wordLimit = words.length;
					}
				lineLimit++;
				listOfWords.add(linesOfWords);
				}
			}catch(IOException e){
				e.printStackTrace();
			}
			com.exist.ecc.service.Ex3DataHandler kp = new com.exist.ecc.service.Ex3DataHandler(listOfWords, keyPair, lineLimit, wordLimit, fileName);
		return kp;
	}	
	
	public void selection(String[]files){
		String word = "";
		String fileName;
		boolean notFinished = true;
		boolean sameFile = true;
		fileName = chooseFile(files);
		while(notFinished){
			if(sameFile){
				fileName = fileName;
			}else{
				fileName = chooseFile(files);
				sameFile = true;
			}
			com.exist.ecc.service.Ex3DataHandler kp = createMap(fileName);
			System.out.println("Choose an option from the following..."
			+"\nA - Search"
			+"\nB - Add Row"
			+"\nC - Edit"
			+"\nD - Print"
			+"\nE - Reset"
			+"\nF - Choose File"
			+"\nG - Exit");
			word = sc.nextLine();
			switch(word.toUpperCase()){
				case "A":
					searchTable(kp);
					break;
				
				case "B":
					 addRow(kp);
					break;

				case "C":
					editTable(kp);
					break;
				
				case "D":
					printTable(kp);
					break;
				
				case "E":
					reset();
					break;

				case "F":
					sameFile = false;
					break;
				
				case "G":
					System.out.println("System shutting down...");
					System.exit(0);
					break;
			}
		}
	}
	
	public void searchTable(com.exist.ecc.service.Ex3DataHandler kp){
		LinkedHashMap<String, String> keyPair = kp.getKeyPair();
		System.out.println("Please enter what you want to search:");
		String userInput = sc.nextLine();

		kp.setFilteredWords(keyPair.entrySet()
				.stream()
				.flatMap(entry-> Stream.of(entry.getKey(), entry.getValue()))
				.filter(elements-> elements.contains(userInput))
				.collect(Collectors.toList()));

		if(kp.getFilteredWords().isEmpty()){
			System.out.println("No Occurrence");	
		}else{
			kp.getFilteredWords()
				.stream()
				.forEach(word->kp.countOccurrences(word, userInput));
			kp.setFilteredWords(new ArrayList<>());
		}
	}

	public int countOccurrences(String mainString, String userInput){
        int position = 0;
        int count = 0;
        int inputLength = userInput.length();
        while ((position = mainString.indexOf(userInput, position)) != -1) {
           position = position + inputLength;
           count++;
        }
       return count;
	}
	
	public void printTable(com.exist.ecc.service.Ex3DataHandler kp){
		LinkedHashMap<String, String> keyPair = kp.getKeyPair();
		int columnLimit = kp.getWordLimit();
        int rows = 0;
        int columns = 0;
        for (Map.Entry<String, String> entry : keyPair.entrySet()) {
            System.out.print("[" + rows +"][" + columns + "]" + entry.getKey() + "\t[" + rows + "][" + (columns + 1) + "]" + entry.getValue()  + "\t");
            columns += 2;
			if(columns>= columnLimit){
				System.out.println(" ");
				rows++;
				columns=0;
			}
        }
		System.out.println("\n");
	}
	
	public void editTable(com.exist.ecc.service.Ex3DataHandler kp){
		retrieveValue(kp);
	}
	
	public void retrieveValue(com.exist.ecc.service.Ex3DataHandler kp){
		LinkedHashMap<String, String> keyPair = kp.getKeyPair();
		int lineLimit =  kp.getLineLimit();
		int wordLimit = kp.getWordLimit();
		int userRow = 0;
		int userColumn = 0;
		int rows = 0;
		int columns = 0;
		String oldValue = "";
		String newValue;
		boolean finished = false;
		while(!finished){
			try{
					System.out.println("Please enter row number:");
					userRow = Integer.parseInt(sc.nextLine());
					if(userRow>lineLimit || userRow<0){
						System.out.println("Please choose within the given matrix shown in the Print function");
						return;
					}else{
						finished = true;
					}
				
					System.out.println("Please enter a column number: ");
					userColumn = Integer.parseInt(sc.nextLine());
						if(userColumn>lineLimit || userColumn<0){
							System.out.println("Please choose within the given matrix shown in the Print function");
							return;
						}else{
							finished = true;
						}
				
			}catch(Exception e){
				System.out.println("Please enter a valid input");
			}
		}
		
		
		System.out.println("Please enter the value you want to replace it with: ");
		newValue = sc.nextLine();
        for (Map.Entry<String, String> entry : keyPair.entrySet()) {
			if(columns>= wordLimit){
				rows++;
				columns=0;
			}
			if(	userRow==rows && (userColumn<columns+2 && userColumn >= columns)){
				if(userColumn %2==0){
					oldValue = entry.getKey();
					System.out.println(rows + " " + columns);
				} 
				if(userColumn %2==1){
					oldValue = entry.getValue();
					System.out.println(rows + " " + columns);
				}
			}
			columns += 2;
        }
		updateFile(kp, oldValue, newValue);
	}

	public void updateFile(com.exist.ecc.service.Ex3DataHandler kp, String oldValue, String newValue){
		ArrayList<ArrayList<String>> listOfWords = kp.getListOfWords();
		String fileName = kp.getFileName();
			try{
				String line;
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
				for (ArrayList<String> linesOfWords : listOfWords) {
					for (int ctrWords = 0; ctrWords < linesOfWords.size(); ctrWords++) {
						if (linesOfWords.get(ctrWords).equals(oldValue)) {
							linesOfWords.set(ctrWords, newValue);
						}
					}
					String newLines = String.join(" ", linesOfWords);
					writer.write(newLines);
					writer.newLine();
				}
				writer.close();
			}catch(IOException io){
				io.printStackTrace();
			}
	}
	
	public void addRow(com.exist.ecc.service.Ex3DataHandler kp){
		ArrayList<ArrayList<String>> listOfLines = createRows(kp);
		printAddedRows(listOfLines, kp.getFileName());
	}
	
	public ArrayList<ArrayList<String>> createRows(com.exist.ecc.service.Ex3DataHandler kp){
		ArrayList<ArrayList<String>> listOfLines = kp.getListOfWords();
		String fileName = kp.getFileName();
		int wordLimit = kp.getWordLimit();
		int lineLimit = kp.getLineLimit();
		String input;
		int number;		
		
		System.out.println("How many rows do you want to add?");
		input = sc.nextLine();
		number = Integer.parseInt(input);
		while(number!=0){
			ArrayList<String> wordContainer = new ArrayList<>();
			for(int numberOfWords = 0; numberOfWords <wordLimit; numberOfWords++){
					wordContainer.add(generateText());
			}
			listOfLines.add(wordContainer);
			number--;
		}
		return listOfLines;
	}
	
		
	public String generateText(){
		String generatedText = "";
		int charLimit = 2;
		int min = 3;
		int max = 5;
		int generatedLimit;
		generatedLimit = (int)(Math.random() * (max - min + 1)) + min;
			for(int ctrChar = 0; ctrChar <= generatedLimit; ctrChar++){
				generatedText +=(char)((int) Math.round(Math.random()*93+33));
			}
		return generatedText;
	}
	
	public void printAddedRows(ArrayList<ArrayList<String>> listOfLines, String fileName){
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
			for(ArrayList<String> linesOfWords: listOfLines){
				String newLines = String.join(" ", linesOfWords);
				writer.write(newLines);	
				writer.newLine();

			}
				writer.close();
		}catch(IOException io){
			io.printStackTrace();
		}
	}
	

	public void reset(){
		boolean works = false;
		while(!works){
			try{
				int rows;
				int columns;
				System.out.println("Please input number of rows: ");
				rows = sc.nextInt();
				
				System.out.println("Please input number of columns: ");
				columns = sc.nextInt();
				sc.nextLine();
				createTable(rows, columns);

				works = true;
			}catch(InputMismatchException e){
				System.out.println("You have entered the wrong value, please enter a number");
				sc.next();
			}	
		}
	}
	
	public void createTable(int rows, int columns){ 
		try{
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/text-files/txt2.txt"));
			for (int ctrRows = 0; ctrRows < rows ; ctrRows++){
				for (int ctrColumns = 0; ctrColumns < columns*2; ctrColumns++){	
					writer.write(generateText() + " ");
				}
				writer.newLine();
			}
			writer.close();
		System.out.println("Please check your file");	
		}catch(IOException e){
			e.printStackTrace();
		}
	}	

}

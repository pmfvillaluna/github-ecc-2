package com.exist.ecc.service;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
class Ex2Data {
	
	ArrayList<ArrayList<String>> listOfWords;
	ArrayList<String> linesOfWords;
    LinkedHashMap<String, String> keyPair;
	List<String> filteredWords = new ArrayList<>();
    int lineLimit;
    int wordLimit;
    String fileName;
	
    public Ex2Data(ArrayList<ArrayList<String>> listOfWords,LinkedHashMap<String, String> keyPair,
						int lineLimit, int wordLimit, String fileName) {
		this.listOfWords = listOfWords;
        this.keyPair = keyPair;
        this.lineLimit = lineLimit;
        this.wordLimit = wordLimit;
        this.fileName = fileName;

    }

	public void setFilteredWords(List<String> filteredWords){
		this.filteredWords = filteredWords;
	}

	public List<String> getFilteredWords(){
		return filteredWords;
	}
	
	public ArrayList<ArrayList<String>> getListOfWords(){
		return listOfWords;
	}

    public LinkedHashMap<String, String> getKeyPair() {
        return keyPair;
    }
    public int getLineLimit() {
        return lineLimit;
    }
    public int getWordLimit() {
        return wordLimit;
    }
    public String getFileName() {
        return fileName;
    }

	public void countOccurrences(String mainWord, String userInput){
		int position = 0;
        int count = 0;
        int inputLength = userInput.length();
        while ((position = mainWord.indexOf(userInput, position)) != -1) {
           position = position + inputLength;
           count++;
        }
		System.out.println(mainWord + "\tcontains " +count + " occurrences");
	}
	
	
	
}
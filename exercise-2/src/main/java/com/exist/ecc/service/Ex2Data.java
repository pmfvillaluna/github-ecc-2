package com.exist.ecc.service;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.List;
public class Ex2Data {
	
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
	
	
	
}
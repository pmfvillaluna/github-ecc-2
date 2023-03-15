package com.exist.ecc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.exist.ecc.service.Ex3Data;
import com.exist.ecc.service.Ex3Service;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

/**
 * Unit test for simple App.
 */
public class Ex3DataTest
{
    String fileName = "src/main/resources/text-files/txt1.txt";
    Ex3Data data;
    Ex3Service service;

    @Test
    public void dataListOfWordsTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex3Service();
        data = service.createMap(fileName);
        assertTrue(data.getListOfWords() instanceof ArrayList);
    }
    @Test
    public void keyPairTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex3Service();
        data = service.createMap(fileName);
        assertTrue(data.getKeyPair() instanceof Map);
    }
    @Test
    public void lineLimitTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex3Service();
        data = service.createMap(fileName);
        int expected = 4;
        int actual = data.getLineLimit();
        assertEquals(expected, actual);
    }
    @Test
    public void wordLimitTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex3Service();
        data = service.createMap(fileName);
        int expected = 4;
        int actual = data.getWordLimit();
        assertEquals(expected, actual);
    }
    @Test
    public void fileNameTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex3Service();
        data = service.createMap(fileName);
        assertEquals(fileName, data.getFileName());
    }
}


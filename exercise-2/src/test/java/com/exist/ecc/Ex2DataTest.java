package com.exist.ecc;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import com.exist.ecc.app.Exercise2;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import com.exist.ecc.service.Ex2Data;
import com.exist.ecc.service.Ex2Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;


public class Ex2DataTest
{
    String fileName = "src/main/resources/text-files/txt1.txt";
    Ex2Data data;
    Ex2Service service;

    @Test
    public void dataListOfWordsTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex2Service();
        data = service.createMap(fileName);
        assertTrue(data.getListOfWords() instanceof ArrayList);
    }
    @Test
    public void keyPairTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex2Service();
        data = service.createMap(fileName);
        assertTrue(data.getKeyPair() instanceof Map);
    }
    @Test
    public void lineLimitTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex2Service();
        data = service.createMap(fileName);
        int expected = 4;
        int actual = data.getLineLimit();
        assertEquals(expected, actual);
    }
    @Test
    public void wordLimitTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex2Service();
        data = service.createMap(fileName);
        int expected = 4;
        int actual = data.getWordLimit();
        assertEquals(expected, actual);
    }
    @Test
    public void fileNameTest(){
        fileName = "src/main/resources/text-files/txt1.txt";
        service = new Ex2Service();
        data = service.createMap(fileName);
        assertEquals(fileName, data.getFileName());
    }
}

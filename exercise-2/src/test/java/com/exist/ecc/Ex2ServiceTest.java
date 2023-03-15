package com.exist.ecc;

import com.exist.ecc.app.Exercise2;
import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.*;


public class Ex2ServiceTest
{
    String fileName = "src/main/resources/text-files/txt1.txt";
    com.exist.ecc.service.Ex2Data data;
    com.exist.ecc.service.Ex2Service service;

    @Test
    public void countOccurrenceTest(){
        int expected = 2;
        String mainString = "paolo";
        String searchInput = "o";
        com.exist.ecc.service.Ex2Service service = new com.exist.ecc.service.Ex2Service();
        int actual = service.countOccurrences(mainString, searchInput);
        assertEquals(expected, actual);
    }

    @Test
    public void generateTextTest(){
        com.exist.ecc.service.Ex2Service service = new com.exist.ecc.service.Ex2Service();
        String output = null;
        output = service.generateText();
        assertNotNull(output);
    }    @Test
    public void generateTextTest_isString(){
        com.exist.ecc.service.Ex2Service service = new com.exist.ecc.service.Ex2Service();
        assertTrue(service.generateText() instanceof String);
    }

}

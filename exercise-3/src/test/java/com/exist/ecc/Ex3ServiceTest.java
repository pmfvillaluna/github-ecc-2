package com.exist.ecc;
import com.exist.ecc.service.Ex3Data;
import com.exist.ecc.service.Ex3Service;
import org.junit.Test;

import static org.junit.Assert.*;

public class Ex3ServiceTest {
    String fileName = "src/main/resources/text-files/txt1.txt";
    Ex3Data data;
    Ex3Service service;

    @Test
    public void countOccurrenceTest(){
        int expected = 2;
        String mainString = "paolo";
        String searchInput = "o";
        data = new Ex3Data();
        int actual = data.countOccurrences(mainString, searchInput);
        assertEquals(expected, actual);
    }

    @Test
    public void generateTextTest(){
        Ex3Service  service = new Ex3Service();
        String output = null;
        output = service.generateText();
        assertNotNull(output);
    }    @Test
    public void generateTextTest_isString(){
        Ex3Service  service = new Ex3Service();
        assertTrue(service.generateText() instanceof String);
    }

}

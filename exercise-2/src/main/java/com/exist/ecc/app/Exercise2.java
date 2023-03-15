package com.exist.ecc.app;
import com.exist.ecc.service.Ex2Service;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Exercise2{
    public static void main(String[] args) {
		String files[] = new String[2];

		files[0] = "exercise-2/src/main/resources/text-files/txt1.txt";
		files[1] = "exercise-2/src/main/resources/text-files/txt2.txt";
		Ex2Service exercise2 = new Ex2Service();
		exercise2.selection(files);
	}
}
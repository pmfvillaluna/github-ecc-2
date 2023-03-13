package com.exist.ecc.app;
import com.exist.ecc.service.Ex2Service;

public class Exercise2{
    public static void main(String[] args) {
		String files[] = new String[2];
        files[0] = "src/main/resources/text-files/txt1.txt";
		files[1] = "src/main/resources/text-files/txt2.txt";
		Ex2Service exercise2 = new Ex2Service();
		exercise2.selection(files);
	}
}
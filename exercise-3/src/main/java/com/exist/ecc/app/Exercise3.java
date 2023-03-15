package com.exist.ecc.app;
import com.exist.ecc.service.Ex3Service;
public class Exercise3 {
    public static void main(String[] args) {
		String files[] = new String[2];
		files[0] = "exercise-2/src/main/resources/text-files/txt1.txt";
		files[1] = "exercise-2/src/main/resources/text-files/txt2.txt";
		Ex3Service exercise3 = new Ex3Service();
		exercise3.selection(files);
	}
}

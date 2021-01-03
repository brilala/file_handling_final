package com.hcl.projects.file_handling_final;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileHandlingMain {

	public static void main(String[] args) throws IOException {

		// create file
		String fileName = "src/main/resources/newFile.txt";
		PrintWriter writeOut = null;

		try {
			writeOut = new PrintWriter(fileName);

		} catch (FileNotFoundException e) {
			System.out.println("Error opening: " + fileName);
			System.exit(0);
		}
		System.out.println(fileName + " has been created!");
		System.out.println();

		// write to file
		System.out.println("Enter 3 lines of text: ");
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 3; i++) {
			String line = scanner.nextLine();
			writeOut.println(line);
		}
		writeOut.close();
		scanner.close();

		System.out.println("Lines have been written to: " + fileName);
		System.out.println("");

		// append
		try {
			FileWriter appendFile = new FileWriter(fileName, true);
			PrintWriter appendOut = new PrintWriter(appendFile);
			appendOut.println("d ");
			appendOut.println("e ");
			appendOut.println("f");
			appendOut.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("Lines have been appended to:" + fileName);
		System.out.println("");

		// read
		System.out.println("Final document reads: ");
		try (FileReader readOut = new FileReader(fileName)) {
			int containsText;
			while ((containsText = readOut.read()) != -1) {
				System.out.print((char) containsText);
			}
		} catch (FileNotFoundException e) {
		}

	}
}
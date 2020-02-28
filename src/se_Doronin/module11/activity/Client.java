package se_Doronin.module11.activity;

import java.io.*;
import java.nio.file.FileSystems;
import java.util.Scanner;

public class Client {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextEditor editor = new Notepad(args[0]);
		editor.typeIn();

		Scanner scanner = new Scanner(System.in);

		while (true){
			String line = scanner.nextLine();
			if(line.equals("END"))
				break;
			editor.saveAs(line);
		}
		editor.typeIn();
	}
}


package se_Doronin.module11.activity;

import java.io.*;

public class Notepad implements TextEditor {
	public static String filename;
	
	public Notepad(String filename) {
		Notepad.filename = filename;
	}

	@Override
	public void saveAs(String text) {
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true)))
		{
			bw.append(text);
			bw.newLine();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void typeIn() {
		try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

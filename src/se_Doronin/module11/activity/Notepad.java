package se_Doronin.module11.activity;

import java.io.*;
import java.util.Scanner;

public class Notepad implements TextEditor {
    public static String filename;
    private File file;
	private Scanner scanner = new Scanner(System.in);

    public Notepad(String filename) {
        Notepad.filename = filename;
        file = new File(filename);
        //file.createNewFile();
    }

    @Override
    public void saveAs(String text) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))) {
            bw.append(text);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String typeIn() {
		return scanner.nextLine();
    }

    public void printAll() {
        if (file.exists()) {

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
}

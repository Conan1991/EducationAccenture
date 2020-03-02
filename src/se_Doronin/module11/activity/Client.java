package se_Doronin.module11.activity;

public class Client {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TextEditor editor = new Notepad(args[0]);
        editor.printAll();

        while (true) {
            String text = editor.typeIn();
            if (text.equals("END"))
                break;
            editor.saveAs(text);
        }


    }
}


package se_Doronin.module12.activity;

import java.io.*;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class Chat {
    private final int port = 6666;
    private String server = "127.0.0.1";
    private Socket socket;
    Scanner in;

    String userName;
    PrintWriter writer;
    BufferedReader reader;

    public Chat() {
        try {
            socket = new Socket(server, port);
            in = new Scanner(System.in);
            writer = new PrintWriter(new DataOutputStream(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Please, enter your username: ");
        userName = in.nextLine();
        System.out.println("Enter your message:");

        Runnable clientWriter = () -> {
            while (true) {
                if (socket.isClosed() || !socket.isConnected()) {
                    break;
                }
                String input = in.nextLine();
                if(input.contains("logout")) {
                    writeToSocket(input);
                    break;
                }
                writeToSocket(userName + ": " + input);
            }
            try {
                reader.close();
                writer.close();
                in.close();
                userName = "";
            } catch (IOException e) {
                e.printStackTrace();
            }
        };


        Runnable clientReader = () -> {
            while (true) {
                String incoming = null;
                if (socket.isClosed() || !socket.isConnected()) {
                    break;
                }
                try {
                    incoming = reader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (Objects.isNull(incoming))
                    break;
                System.out.println(incoming);
            }

            try {
                reader.close();
                writer.close();
                in.close();
                userName = "";
            } catch (IOException e) {
                e.printStackTrace();
            }
        };

        new Thread(clientReader).start();
        new Thread(clientWriter).start();
    }

    public void writeToSocket(String s) {
        writer.println(s);
        writer.flush();
    }

    public static void main(String[] args) {
        new Chat();
    }

}

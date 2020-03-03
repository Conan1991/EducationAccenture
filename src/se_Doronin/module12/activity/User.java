package se_Doronin.module12.activity;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

class User implements Runnable {
    //Scanner scn = new Scanner(System.in);
    private String name;
    private int userID;

    BufferedReader input;
    PrintWriter printWriter;

    Socket socket;
    private final OnGetMessage listener;

    // constructor User
    public User(Socket socket, OnGetMessage listener, int userID) {

        this.socket = socket;
        try {
            printWriter = new PrintWriter(new DataOutputStream(socket.getOutputStream()));
            input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //dataInputStream = new DataInputStream(socket.getInputStream());
            //bufferedWriter = new BufferedWriter(dataOutputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }


        this.userID = userID;
        this.listener = listener;
    }

    public void writeToSocket(String s) {

        printWriter.println(s);
        printWriter.flush();
    }

    public int getUserID() {
        return userID;
    }

    @Override
    public void run() {
        System.out.println("User " + Thread.currentThread().getName() + " started");

        String received = "";
        while (true) {
            try {
                // receive the string
//                if(input.hasNext())
                received = input.readLine();
                System.out.println(Thread.currentThread().getName() + " recieve a message " + received);

                if (received.equals("logout")) {
                    close();
                    break;
                }

                listener.sendToAll(received, userID);
                //if (!received.isEmpty())
                 //   ChatServer.sendToAll(received);

            } catch (IOException e) {  e.printStackTrace(); }
        }

    }

    private void close() throws IOException {
        socket.close();
        input.close();
        printWriter.close();
        System.out.println("User with ID " + userID + " has left chat");
        ChatServer.users.remove(this);
        return;
    }

    public interface OnGetMessage {
        void sendToAll(String message, int id);
    }
}

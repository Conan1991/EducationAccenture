package se_Doronin.module12.activity;

// Java implementation of  Server side
// It contains two classes : Server and ClientHandler
// Save file as Server.java

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

// Server class
public class ChatServer {

    // Vector to store active clients
    static List<User> users = new ArrayList<>();

    // counter for clients
    static int i = 0;

    public static void main(String[] args) throws IOException {
        System.out.println("Server start");
        // server is listening on port 6666
        ServerSocket ss = new ServerSocket(6666);
        Socket socket;
        // running infinite loop for getting
        // client request
        while (true) {

            // Accept the incoming request
            socket = ss.accept();

            System.out.println("New client request received : " + socket);
            // Create a new handler object for handling this request.
            User user = new User(socket, ChatServer::sendToAllExclude, i);
            users.add(user);
            // Create a new Thread with this object.
            Thread t = new Thread(user);
            // start the thread.
            t.start();
            // increment i for new client.
            i++;
        }
    }

    public static void sendToAllExclude(String str, int excludeID) {
        System.out.println("Number of users = " + users.size());
        for (User user : users) {
            if (user.getUserID() != excludeID)
                user.writeToSocket(str);
        }
    }
}
package tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {
        System.out.println("Server initializing...");
        ServerSocket serverSocket = new ServerSocket(12321);
        System.out.println(serverSocket);
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            new Thread(new Server_listen(socket)).start();
            new Thread(new Server_send(socket)).start();
        }
    }





}

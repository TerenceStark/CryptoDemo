package tcp;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TCPClient {
    private static Socket socket;
    private static boolean connection_state = false;
    private static ObjectOutputStream oos;

    public static void main(String[] args) throws IOException {
        System.out.println("Connecting to server..");
        connect();
        if (connection_state) {
            System.out.println(socket);
            oos = new ObjectOutputStream(socket.getOutputStream());
            new Thread(new Client_listen(socket)).start();
            new Thread(new Client_send(socket, oos)).start();
            new Thread(new Client_heart(socket, oos)).start();
        }
    }

    private static void connect() throws IOException {
        socket = new Socket("192.168.31.218", 12321);
        connection_state = true;
    }
}


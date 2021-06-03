package tcp;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Server_listen implements Runnable {
    private Socket socket;

    public Server_listen(Socket socket) {
        this.socket = socket;
    }

    @SneakyThrows
    @Override
    public void run() {
        ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
        while (true) {
            System.out.println("From Client" + socket.getRemoteSocketAddress() + objectInputStream.readObject());
        }
    }
}

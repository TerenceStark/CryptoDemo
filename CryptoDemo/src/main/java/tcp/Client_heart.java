package tcp;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.Scanner;

public class Client_heart implements Runnable {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    public Client_heart(Socket socket, ObjectOutputStream objectOutputStream) {
        this.socket = socket;
        this.objectOutputStream = objectOutputStream;

    }

    @SneakyThrows
    @Override
    public void run(){
        while (true) {
            Thread.sleep(20000);
            JSONObject object = new JSONObject();
            object.put("heartbeat", socket.getLocalSocketAddress());
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        }
    }
}

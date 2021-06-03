package tcp;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Server_send implements Runnable {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    public Server_send(Socket socket) {
        this.socket = socket;
    }

    @SneakyThrows
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String data = sc.nextLine();
            JSONObject object = new JSONObject();
            object.put("msg", data);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        }
    }
}

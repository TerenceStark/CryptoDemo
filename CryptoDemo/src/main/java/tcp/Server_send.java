package tcp;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Server_send implements Runnable {
    private Socket socket;

    public Server_send(Socket socket) throws IOException {
        this.socket = socket;
    }

    @SneakyThrows
    @Override
    public void run() {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
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

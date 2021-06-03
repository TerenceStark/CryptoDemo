package tcp;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;

import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client_send implements Runnable {
    private Socket socket;
    private ObjectOutputStream objectOutputStream;

    public Client_send(Socket socket, ObjectOutputStream objectOutputStream) {
        this.socket = socket;
        this.objectOutputStream = objectOutputStream;
    }

    @SneakyThrows
    @Override
    public void run() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            String data = sc.nextLine();
/*            if (data.equals("exit")){
                JSONObject object = new JSONObject();
                object.put("break", data);
                objectOutputStream.writeObject(object);
                objectOutputStream.flush();
                break;
            }*/
            JSONObject object = new JSONObject();
            object.put("msg", data);
            objectOutputStream.writeObject(object);
            objectOutputStream.flush();
        }
    }
}

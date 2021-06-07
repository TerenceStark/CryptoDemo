package tcp;

import lombok.SneakyThrows;
import org.json.simple.JSONObject;

import java.io.*;
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
            Object object;
            if ((object = objectInputStream.readObject())!= null) {
                String s = object + "";
                if (s.equals("{\"break\":\"exit\"}")) {
                    socket.shutdownInput();
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(socket.getOutputStream());
                    String close = "{\"break\":\"exit\"}";
                    byte[] bytes = close.getBytes();
                    bufferedOutputStream.write(bytes);
                    bufferedOutputStream.flush();
                    bufferedOutputStream.close();
                    bufferedOutputStream.close();
                    break;
                } else {
                    System.out.println("From Client" + socket.getRemoteSocketAddress() + s);
                }
            }
        }
    }
}

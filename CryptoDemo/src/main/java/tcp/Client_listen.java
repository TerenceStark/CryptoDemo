package tcp;

import lombok.SneakyThrows;

import java.io.ObjectInputStream;
import java.net.Socket;

public class Client_listen implements Runnable {
    private Socket socket;

    public Client_listen(Socket socket) {
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
                    break;
                } else {
                    System.out.println("From Server" + socket.getRemoteSocketAddress() + object);
                }
            }
        }
        socket.close();
    }
}

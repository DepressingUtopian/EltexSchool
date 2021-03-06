package ru.eltex.app.java.model.net;


import ru.eltex.app.java.model.shop.Order;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ServerListener extends Thread {

    private int udpAlertPort = 0;
    private int clientIP = 0;
    private Socket socket;
    private ObjectInputStream in;
    private BufferedWriter out;

    ServerListener(Socket _socket) throws IOException {
        this.socket = _socket;
        in = new ObjectInputStream(socket.getInputStream());
        this.start();
    }
    @Override
    public void run() {
        try {
            Order order = (Order) in.readObject();
            this.udpAlertPort = (int) in.readObject();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(socket.getLocalAddress(),this.udpAlertPort);

            Server.addOrderToOrderMap(inetSocketAddress, order);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}



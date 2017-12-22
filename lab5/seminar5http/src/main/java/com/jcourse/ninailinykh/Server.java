package com.jcourse.ninailinykh;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
//    private static ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        /* обрабатываем аргументы. Сначала проверяем, чтобы порт был>0*/
        if (args == null) {
            System.out.println("Введите аргументы");
            return;
        }
        int port;
        port = Integer.parseInt(args[0]);
        if ((port > 0) && (port <= 65535)) {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket socket = serverSocket.accept();
                System.err.println("Прием клиента");

                try {
                    new Thread(new HandlerSocket(socket)).start();
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }
        /*Проверяем второй аргумент*/
        String pathName = args[1];
        CreateIndex ind = new CreateIndex(pathName);

    }

}


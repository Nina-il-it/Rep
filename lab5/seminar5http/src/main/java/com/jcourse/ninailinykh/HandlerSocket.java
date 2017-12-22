package com.jcourse.ninailinykh;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class HandlerSocket implements Runnable {
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public HandlerSocket(Socket socket) throws Throwable {
        this.socket = socket;
        this.inputStream = socket.getInputStream();
        this.outputStream = socket.getOutputStream();
    }


    public void run() {
        try {
            readInputHeaders();
            writeAnswer("<html><title>test</title<body><h1>Hello world!!!</h1></body></html>");
        } catch (Throwable t) {
        } finally {
            try {
                socket.close();
            } catch (Throwable t) {
            }
        }
        System.err.println("Обработка клиента завершена");
    }

    /*запись ответов*/
    private void writeAnswer(String s) throws Throwable {
        /*пишем статус ответа*/
        outputStream.write("HTTP/1.0 200 OK\r\n".getBytes());
        /*минимально необходимые заголовки, тип и длина*/
        outputStream.write("Content-Type: text/html\r\n".getBytes());
        outputStream.write(("Content-Length: " + s.length() + "\r\n").getBytes());
        /*пустая строка отделяет заголовки от тела*/
        outputStream.write("\r\n".getBytes());
        /*записываем ответ*/
        outputStream.write(s.getBytes());
        outputStream.flush();
    }

    /*Чтение заголовков*/
    private void readInputHeaders() throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        while (true) {
            String s = br.readLine();
            if (s == null || s.trim().length() == 0) {
                break;
            }
        }
    }
}


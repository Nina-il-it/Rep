package com.jcourse.ninailinykh;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CreateIndex {
    public CreateIndex(String pathName) throws IOException {

        /*Конструируем объект File*/
        File root = new File(pathName);

        /*Проверяем, что ме передали существующую папку*/
        if (!root.exists()) {
            System.out.println("Заданная папка не существует");
            return;
        }
        if (!root.isDirectory()) {
            System.out.println("Не является папкой");
        }
        /*Здесь мы будем хранить все файлы в нашей папке*/
        List<File> files = new ArrayList<File>();

        /*Здесь мы будем хранить все подпапки в нашей папке*/
        List<File> directories = new ArrayList<File>();

        /*Обойдем все объекты в нашей папке*/
        for (File object : root.listFiles()) {
            if (object.isDirectory()) {
                /*Если объект - папка, то добавим в лист directories*/
                directories.add(object);
            } else {
                /*Иначе добавим в лист files*/
                files.add(object);
            }
        }
        /*!!!НЕОБХОДИМО ОТСОРТИРОВАТЬ МАССИВЫ!!!!*/
        try {
            //создаем HTML String Builder
            StringBuilder htmlStringBuilder = new StringBuilder();
            //append html header and title
            htmlStringBuilder.append("<html><head><title>Directory File: </title></head>");
            //append body
            htmlStringBuilder.append("<body>");
            //append table
            htmlStringBuilder.append("<table border='1' bordercolor='#000000'>");
            //append row
            htmlStringBuilder.append("<tr><td><b>Directory</b></td><td><b>DateChanges</b></td><td><b>Size</b></td></tr>");
            htmlStringBuilder.append("<tr><td><a href = \"..\">..</a></td><td></td><td></td></tr>");
            for (File object : directories) {
//                System.out.println(object.length());
                htmlStringBuilder.append("<tr><td>" + "<a href='" + object.getName() + "/'>" + object.getName() + "</a>" + "</td><td>" + new Date(object.lastModified()) + "</td><td>"
                        + object.length() + "</td></tr>");
            }
            for (File object : files) {
                htmlStringBuilder.append("<tr><td>" + "<a href='" + object.getName() + "'>" + object.getName() + "</a>" + "</td><td>" + new Date(object.lastModified()) + "</td><td>" + object.length() + "</td></tr>");
            }
            //close html file
            htmlStringBuilder.append("</table></body></html>");
            //write html string content to a file
            writeToFile(pathName, htmlStringBuilder.toString(), "index.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String pathName, String fileContent, String fileName) throws IOException {
        String tempFile = pathName + File.separator + fileName;
        File file = new File(tempFile);
        // если файл существует, удаляем и создаем новый файл
        if (file.exists()) {
            try {
                File newFileName = new File(pathName + File.separator + "backup_" + fileName);
                file.renameTo(newFileName);
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //write to file with OutputStreamWriter
        OutputStream outputStream = new FileOutputStream(file.getAbsoluteFile());
        Writer writer = new OutputStreamWriter(outputStream);
        writer.write(fileContent);
        writer.close();

    }

}

package com.lazyben;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class MyWebServer {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        while (true) {
            String url = getUrlByUserInput();
            Servlet servlet = getServlet(url);
            servlet.service();
        }
    }

    private static Servlet getServlet(String url) throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Properties config = new Properties();
        config.load(new FileReader("/Users/lazyben/Projects/learn-java-2023/servlet-learn/my-servlet/src/main/java/com/lazyben/config.properties"));
        Class<?> klass = Class.forName(config.getProperty(url));
        return (Servlet) klass.newInstance();
    }

    private static String getUrlByUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }
}

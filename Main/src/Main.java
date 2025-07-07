import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Scanner;
import java.util.concurrent.Executor;

public class Main {
    public static void main(String[] args){

        HttpServer server = null;

        try {
            server = HttpServer.create(new InetSocketAddress(8080), 0);
        } catch (IOException e) {
            throw new RuntimeException("Create servidor: " + e);
        }

        server.setExecutor(null);



        server.start();

        System.out.println(new InetSocketAddress(8080));
        System.out.println("Servidor rodando em http://localhost:8080");

    }
}
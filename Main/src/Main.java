import com.sun.net.httpserver.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/", exchange -> {
            String resposta = "Funcionando!";
            exchange.sendResponseHeaders(200, resposta.length());
            exchange.getResponseBody().write(resposta.getBytes());

            exchange.close();
        });

        server.setExecutor(null);
        server.start();

    }
}

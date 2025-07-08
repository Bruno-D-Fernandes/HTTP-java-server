import com.sun.net.httpserver.*;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);


        server.createContext("/", exchange -> entregaArquivo(exchange, "index.html"));

        server.setExecutor(null);
        server.start();

    }

    static void entregaArquivo(HttpExchange exchange, String nome) throws IOException {
        File arquivo = new File("www/" + nome);
        if (!arquivo.exists()) {
            System.out.println("Caiu no erro");

            String resposta = "<h1>Arquivo não encontrado</h1>";
            byte[] corpo = resposta.getBytes("UTF-8");

            exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
            exchange.sendResponseHeaders(404, corpo.length);
            exchange.getResponseBody().write(corpo);

            exchange.close();
            return;
        }


        exchange.getResponseHeaders().set("Content-Type", "text/html; charset=utf-8");
        byte[] conteudo = Files.readAllBytes(arquivo.toPath());

        exchange.sendResponseHeaders(200, conteudo.length);
        exchange.getResponseBody().write(conteudo);
        exchange.close();
    }
}

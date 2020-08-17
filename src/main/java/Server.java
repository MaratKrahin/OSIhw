import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static int PORT = 33333;
    static ServerSocket serverSocket;
    static Socket clientSocket;
    static PrintWriter out;
    static BufferedReader in;

    public static void main(String[] args) throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            System.out.println("Сервер запущен!");

            clientSocket = serverSocket.accept();
            System.out.println("Соединение установлено");

            out = new PrintWriter(clientSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            final String name = in.readLine();
            out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
            out.println("Напишите имя");
            String userName = in.readLine();
            out.println("Вы ребенок?(Да/нет)");
            if ("нет".equals(in.readLine())){
                out.println(String.format("Welcome to the kids area, %s! Let's play!", userName));
            }else {
                out.println(String.format("Welcome to the adult zone, %s! Have a good rest, or a good working day!"
                        , userName));
            }
        } catch (IOException e) {
            System.out.println();
        } finally {
            clientSocket.close();
            System.out.println("disconnect");
            out.close();
            in.close();
        }
    }
}
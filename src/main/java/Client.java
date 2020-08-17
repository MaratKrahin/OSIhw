import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static String host = "netology.homework";
    static int port = 33333;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try (
                Socket clientSocket = new Socket(host, port);
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("Пользователь");
            String resp = in.readLine();
            System.out.println(resp);
            System.out.println(in.readLine());
            out.println("Гулдан");
            System.out.println(in.readLine());
            out.println("Да");
            System.out.println(in.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thesoap
 */
public class Server {

    static String ip = "localhost";
    static int port = 8080;

    public static void clientHandler(Socket s) {
        try {
            Scanner scan = new Scanner(s.getInputStream());
            PrintWriter prnt = new PrintWriter(s.getOutputStream(), true);
            String msg = "a";
            prnt.println("Welcome"); 
            while (!msg.equals("STOP")) {
                msg = scan.nextLine();
                if (msg.startsWith("UPPER#")) {
                    String Input = msg.substring(6, msg.length());
                    prnt.println(Input.toUpperCase());
                    System.out.println("");
                } else if (msg.startsWith("LOWER#")) {
                    String Input = msg.substring(6, msg.length());
                    prnt.println(Input.toLowerCase());
                } else if (msg.startsWith("REVERSE#")) {
                    String Input = msg.substring(8, msg.length());
                    StringBuilder sb = new StringBuilder();
                    sb.append(Input);
                    sb.reverse();
                    prnt.println(sb.toString().substring(0, 1).toUpperCase() + sb.toString().substring(1, sb.length()));
                } else if (msg.startsWith("TRANSLATE#")) {
                    String Input = msg.substring(10, msg.length());
                    if (Input.equals("hund")) {
                        prnt.println("dog");
                    } else if (Input.equals("kat")) {
                        prnt.println("cat");
                    }
                }
            }
            scan.close();
            prnt.close();
            s.close();
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {

        try {
            ExecutorService executor = Executors.newCachedThreadPool();
            ip = "localhost";
            port = 8080;
            ServerSocket ss = new ServerSocket();
            ss.bind(new InetSocketAddress(ip, port));
            System.out.println("Started");
            while(true){
            Socket link = ss.accept();
            ClientThread cli = new ClientThread(link);
            executor.execute(cli);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

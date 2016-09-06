
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
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

    public static void main(String[] args) {

        try {
            ip = "localhost";
            port = 8080;
            ServerSocket ss = new ServerSocket();
            ss.bind(new InetSocketAddress(ip, port));
            System.out.println("Started");
            
            while (true) {
                Socket link = ss.accept();
                System.out.println("Connected");
                clientHandler(link);
            }
        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

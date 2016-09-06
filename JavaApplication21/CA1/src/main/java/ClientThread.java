
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
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
public class ClientThread extends Thread {

    protected Socket socket;
    @Override
    public void run(){
        try {
            Scanner scan = new Scanner(socket.getInputStream());
            PrintWriter prnt = new PrintWriter(socket.getOutputStream(), true);
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
                } else if (msg.startsWith("LOGIN:")) {
                    String[] Input = msg.split(":");
                    prnt.println("Velkommen " + Input[1]);
                }
            }
            scan.close();
            prnt.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
       

    ClientThread(Socket link) {
        this.socket = link;
    }

}

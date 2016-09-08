
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.NoSuchElementException;
import java.util.Observable;
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
    protected String username;
    protected Server server;
    Scanner scan;
    PrintWriter prnt;

    public String getUsername() {
        return username;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        try {
            String msg = scan.nextLine();
            String[] parts = msg.split(":");
            if (!parts[0].equals("LOGIN")) {
                scan.close();
                prnt.close();
                socket.close();
                return;
            } else {
                server.AddUser(msg, this);
            }

            while (!msg.equals("LOGOUT:")) {
                msg = scan.nextLine();
                String[] part = msg.split(":");
                System.out.println(part[0]);
                switch (part[0]) {
                    case "MSG":
                        server.msg(msg, this);
                        break;
                }
            }
            
            server.logout(this);
            
        } catch (NoSuchElementException | IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
            server.logout(this);
        }
    }

    ClientThread(Socket link, Server server) throws IOException {
        this.socket = link;
        this.server = server;
        this.scan = new Scanner(socket.getInputStream());
        this.prnt = new PrintWriter(socket.getOutputStream(), true);
    }

    void send(String s) {
        this.prnt.println(s);
        this.prnt.flush();
    }
}

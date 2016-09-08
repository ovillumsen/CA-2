
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
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
            prnt.println("bah");
            String msg = scan.nextLine();
            String[] parts = msg.split(":");
            if (!parts[0].equals("LOGIN")) {
                return;
                // Need to close socket
            } else {
                server.AddUser(msg, this);
            }

            while (!msg.equals("STOP")) {
                msg = scan.nextLine();
                String[] part = msg.split(":");
                System.out.println(part[0]);
                switch (part[0]) {
                    case "MSG":
                        server.msg(msg, this);
                        break;
                    case "LOGOUT":
                        this.socket.close();
                        server.ctlist.remove(this);
                        String s = "Clientlist: ";
                        for (ClientThread user : server.ctlist) {
                            s = s + user.getUsername() + ",";
                        }
                        s = s.substring(0, s.length() - 1);
                        for (ClientThread user : server.ctlist) {
                            user.send(s);
                        }
                        break;

                }
            }

            scan.close();
            prnt.close();
            socket.close();
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
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


import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
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

    static String ip = "46.101.157.16";
    static int port = 8080;
    ArrayList<ClientThread> ctlist = new ArrayList<>();

    public void AddUser(String msg, ClientThread cli) {
        String[] sa = msg.split(":");
        cli.username = sa[1];
        ctlist.add(cli);
        for (int i = 0; i < ctlist.size(); i++) {
            System.out.println(ctlist.get(i).username);
        }

        String s = "Clientlist: ";
        for (ClientThread user : ctlist) {
            s = s + user.getUsername() + ",";
        }
        s = s.substring(0, s.length() - 1);
        for (ClientThread user : ctlist) {
            user.send(s);
        }
    }

    public void msg(String msg, ClientThread cli) {
        String[] sa = msg.split(":");
        if (sa[1].isEmpty()) {
            for (ClientThread user : ctlist) {
                user.send("MSGRES:"+cli.username+":"+sa[2]);
            }
        }else{
            String[] userlist = sa[1].split(",");
            for (ClientThread user : ctlist) {
                for (String userl : userlist) {
                    if(user.getUsername().equals(userl))
                        user.send("MSGRES:"+cli.username+":"+sa[2]);
                }
            }
        }
    }

    public static void main(String[] args) {

        try {
            Server server = new Server();
            ExecutorService executor = Executors.newCachedThreadPool();
            ServerSocket ss = new ServerSocket();
            ss.bind(new InetSocketAddress(ip, port));
            System.out.println("Started");

            MyRunnable r = new MyRunnable();
            executor.execute(r);

            executor.execute(() -> {

                while (true) {
                    try {
                        Socket link = ss.accept();
                        ClientThread cli = new ClientThread(link, server);
                        executor.execute(cli);
                    } catch (IOException ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (Exception ex) {
                        Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            String info;
            while (true) {
                info = "";
                switch (info) {
                    case "LOGIN:":

                        break;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
        }

    }
}

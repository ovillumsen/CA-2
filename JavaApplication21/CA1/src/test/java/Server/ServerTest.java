/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Server;

import java.io.IOException;
import java.net.Socket;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;

/**
 *
 * @author Thesoap
 */
public class ServerTest {

    public ServerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        new Thread(
                new Runnable() {
            @Override
            public void run() {
                Server.main(null);
            }
        }
        ).start();
        new Server();
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {

    }

    @After
    public void tearDown() {
    }

    /**
     * Test of logout method, of class Server.
     */
    @Test
    public void testLogout() {
        try {
            Server server = new Server();
            Socket socket = new Socket("localhost", 8888);
            ClientThread CT = new ClientThread(socket, server);
            server.AddUser("LOGIN:Tim", CT);
            server.logout(CT);
            assertEquals("CLIENTLIST:", server.getctlist());
        } catch (IOException ex) {
            Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of printList method, of class Server.
     */
    @Test
    public void testPrintList() {
        try {
            Server server = new Server();
            Socket socket = new Socket("localhost", 8888);
            ClientThread CT = new ClientThread(socket, server);
            server.AddUser("LOGIN:Hello", CT);
            assertEquals("CLIENTLIST:Hello", server.getctlist());
            server.logout(CT);
        } catch (IOException ex) {
            Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Test of AddUser method, of class Server.
     */
    @Test
        public void testAddUser() {
            try {
                Server server = new Server();
                Socket socket = new Socket("localhost", 8888);
                ClientThread CT = new ClientThread(socket, server);
                server.AddUser("LOGIN:Tim", CT);
                String Goal = server.getctlist();
                assertEquals("CLIENTLIST:Tim", Goal);
            } catch (IOException ex) {
                Logger.getLogger(ServerTest.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    /**
     * Test of msg method, of class Server.
     */
    @Test
    public void testMsg() {
    }

    /**
     * Test of main method, of class Server.
     */
    @Test
    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Server.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

}